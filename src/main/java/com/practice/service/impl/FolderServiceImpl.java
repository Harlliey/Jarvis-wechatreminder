package com.practice.service.impl;

import com.practice.dao.FolderDao;
import com.practice.entity.Folder;
import com.practice.service.FolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by administer on 26/5/19.
 */
@Service
public class FolderServiceImpl implements FolderService{
    @Autowired
    FolderDao folderDao;

    @Override
    public List<Folder> getFolderList() {
        List<Folder> list = folderDao.queryFolder();
        return list;
    }

    @Override
    public List<Folder> getFolderByUser(String creatorId) {
        List<Folder> userFolderList = folderDao.queryFolderByUser(creatorId);
        return userFolderList;
    }

    @Transactional
    @Override
    public boolean addFolder(Folder folder) {
        if (folder.getCreatorId() != null) {
            folder.setCreateTime(new Date());
            folder.setModifyTime(new Date());
            try {
                int effectedNum = folderDao.insertFolder(folder);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("插入文件夹信息失败!");
                }
            } catch (RuntimeException e) {
                throw new RuntimeException("插入文件夹信息失败!" + e.getMessage());
            }
        } else {
            throw new RuntimeException("文件夹创建者不能为空!");
        }
    }

    @Transactional
    @Override
    public boolean modifyFolder(Folder folder) {
        if (folder.getFolderId() > 0 && folder.getFolderId() != null) {
            folder.setModifyTime(new Date());
            try {
                int effectedNum = folderDao.updateFolder(folder);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("修改文件夹信息失败!");
                }
            } catch (RuntimeException e) {
                throw new RuntimeException("修改文件夹信息失败!" + e.getMessage());
            }
        } else {
            throw new RuntimeException("文件夹ID不能为空!");
        }
    }

    @Transactional
    @Override
    public boolean deleteFolder(int folderId) {
        if (folderId > 0) {
            try {
                int effectedNum = folderDao.deleteFolder(folderId);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("删除文件夹信息失败!");
                }
            } catch (RuntimeException e) {
                throw new RuntimeException("删除文件夹信息失败!" + e.getMessage());
            }
        } else {
            throw new RuntimeException("文件夹ID不合法!");
        }
    }
}
