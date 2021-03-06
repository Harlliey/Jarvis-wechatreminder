package com.practice.service.impl;

import com.practice.dao.ResourceDao;
import com.practice.entity.Resource;
import com.practice.service.ResourceService;
import com.practice.service.UploadImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by administer on 29/5/19.
 */
@Service
public class ResourceServiceImpl implements ResourceService{

    @Autowired
    ResourceDao resourceDao;
    @Autowired
    UploadImgService uploadImgService;

    @Override
    public List<Resource> getResourceByContent(int contentId) {
        return resourceDao.queryResourceByContent(contentId);
    }

    @Transactional
    @Override
    public boolean addResource(Resource resource) {
        if (resource.getContentId() != null && resource.getContentId() > 0) {
            try {
                int effectedNum = resourceDao.insertResource(resource);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("资源创建不成功!");
                }
            } catch (RuntimeException e) {
                throw new RuntimeException("资源创建不成功!" + e.getMessage());
            }
        } else {
            throw new RuntimeException("备忘ID不合法!");
        }
    }

    @Transactional
    @Override
    public boolean deleteResource(int resId) {
        if (resId > 0) {
            try {
                Resource resource = resourceDao.queryResourceById(resId);
                int effectedNum = resourceDao.deleteResource(resId);
                if (effectedNum > 0) {
                    String imgUrl = resource.getResUrl();
                    uploadImgService.deleteImg(imgUrl);
                    return true;
                } else {
                    throw new RuntimeException("资源删除不成功!");
                }
            } catch (RuntimeException e) {
                throw new RuntimeException("资源删除不成功!" + e.getMessage());
            }
        } else {
            throw new RuntimeException("资源ID不合法!");
        }
    }

    @Transactional
    @Override
    public boolean deleteResourceByContent(int contentId) {
        if (contentId > 0) {
            try {
                List<Resource> list = resourceDao.queryResourceByContent(contentId);
                int effectedNum = resourceDao.deleteResourceByContent(contentId);
                if (effectedNum > 0) {
                    if (list.size() > 0) {
                        for (Resource item : list) {
                            String imgUrl = item.getResUrl();
                            System.out.println(imgUrl);
                            uploadImgService.deleteImg(imgUrl);
                        }
                    }
                    return true;
                } else {
                    throw new RuntimeException("资源删除不成功!");
                }
            } catch (RuntimeException e) {
                throw new RuntimeException("资源删除不成功!" + e.getMessage());
            }
        } else {
            throw new RuntimeException("备忘ID不合法!");
        }
    }
}
