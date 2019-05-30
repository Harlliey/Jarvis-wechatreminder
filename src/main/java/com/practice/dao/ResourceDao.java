package com.practice.dao;

import com.practice.entity.Resource;

import java.util.List;

/**
 * Created by administer on 29/5/19.
 */
public interface ResourceDao {
    List<Resource> queryResourceByContent(int contentId);
    int insertResource(Resource resource);
    int deleteResource(int resId);
    int deleteResourceByContent(int contentId);
}