package com.practice.service;

import com.practice.entity.Resource;

import java.util.List;

/**
 * Created by administer on 29/5/19.
 */
public interface ResourceService {

    List<Resource> getResourceByContent(int contentId);

    boolean addResource(Resource resource);

    boolean deleteResource(int resId);

    boolean deleteResourceByContent(int contentId);
}
