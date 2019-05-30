package com.practice.service.impl;

import com.practice.dao.ContentDao;
import com.practice.dao.ResourceDao;
import com.practice.entity.Content;
import com.practice.service.ContentService;
import com.practice.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by administer on 29/5/19.
 */
@Service
public class ContentServiceImpl implements ContentService{
    @Autowired
    ContentDao contentDao;
    @Autowired
    ResourceDao resourceDao;

    @Override
    public List<Content> getContentByFolder(int folderId) {
        return contentDao.queryContentByFolder(folderId);
    }

    @Override
    public List<Content> getContentByUser(String creatorId) {
        return contentDao.queryContentByUser(creatorId);
    }

    @Override
    public Content getContentById(int contentId) {
        return contentDao.queryContentById(contentId);
    }

    @Transactional
    @Override
    public int addContent(Content content) {
        if (content.getFolderId() != null && content.getFolderId() > 0) {
            content.setCreateTime(new Date());
            content.setModifyTime(new Date());
            try {
                int effectedNum = contentDao.insertContent(content);
                if (effectedNum > 0) {
                    int lastInsertId = contentDao.getLastInsertId();
                    if (lastInsertId > 0) {
                        return lastInsertId;
                    } else {
                        throw new RuntimeException("获取刚刚插入的备忘ID失败!");
                    }
                } else {
                    throw new RuntimeException("插入备忘失败!");
                }
            } catch (RuntimeException e) {
                throw new RuntimeException("插入备忘失败" + e.getMessage());
            }
        } else {
            throw new RuntimeException("文件ID不能为空!");
        }
    }

    @Transactional
    @Override
    public boolean modifyContent(Content content) {
        if (content.getContentId() > 0 && content.getContentId() != null) {
            content.setModifyTime(new Date());
            try {
                int effectedNum = contentDao.modifyContent(content);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("修改备忘失败!");
                }
            } catch (RuntimeException e) {
                throw new RuntimeException("修改备忘失败" + e.getMessage());
            }
        } else {
            throw new RuntimeException("备忘ID不能为空!");
        }
    }

    @Transactional
    @Override
    public boolean deleteContent(int contentId) {
        if (contentId > 0) {
            int lines = resourceDao.deleteResourceByContent(contentId);
            if (lines <= 0) throw new RuntimeException("删除备忘前删除资源失败了!");
            try {
                int effectedNum = contentDao.deleteContent(contentId);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("删除备忘失败!");
                }
            } catch (RuntimeException e) {
                throw new RuntimeException("删除备忘失败" + e.getMessage());
            }
        } else {
            throw new RuntimeException("备忘ID不合法!");
        }
    }

    @Override
    public boolean deleteContentByFolder(int folderId) {
        if (folderId > 0) {
            List<Integer> cIdList = contentDao.queryIdByFolder(folderId);
            if (cIdList.size() != 0) {
                for (Integer id : cIdList) {
                    int lines = resourceDao.deleteResourceByContent(id);
                    if (lines <= 0) throw new RuntimeException("删除备忘时删除资源失败!");
                }
            }
            try {
                int effectedNum = contentDao.deleteContentByFolder(folderId);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("删除文件夹所有备忘失败!");
                }
            } catch (RuntimeException e) {
                throw new RuntimeException("删除文件夹所有备忘失败" + e.getMessage());
            }
        } else {
            throw new RuntimeException("文件夹ID不合法!");
        }
    }
}
