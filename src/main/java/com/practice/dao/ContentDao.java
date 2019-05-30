package com.practice.dao;

import com.practice.entity.Content;

import java.util.List;

/**
 * Created by administer on 28/5/19.
 */
public interface ContentDao {
    List<Content> queryContentByUser(String creatorId);
    List<Content> queryContentByFolder(int folderId);
    List<Integer> queryIdByFolder(int folderId);
    Content queryContentById(int contentId);
    int insertContent(Content content);
    int modifyContent(Content content);
    int deleteContent(int contentId);
    int getLastInsertId();
    int deleteContentByFolder(int folderId);
}
