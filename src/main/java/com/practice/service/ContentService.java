package com.practice.service;

import com.practice.entity.Content;

import java.util.List;

/**
 * Created by administer on 29/5/19.
 */
public interface ContentService {
    List<Content> getContentByFolder(int folderId);

    List<Content> getContentByUser(String creatorId);

    Content getContentById(int contentId);

    int addContent(Content content);

    boolean modifyContent(Content content);

    boolean deleteContent(int contentId);

    boolean deleteContentByFolder(int folderId);
}
