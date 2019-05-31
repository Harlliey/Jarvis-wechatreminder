package com.practice.service;

import com.practice.entity.Folder;

import java.util.List;

/**
 * Created by administer on 26/5/19.
 */
public interface FolderService {
    List<Folder> getFolderList();

    Folder getFolderById(int folderId);

    List<Folder> getFolderByUser(String creatorId);

    boolean addFolder(Folder folder);

    boolean modifyFolder(Folder folder);

    boolean deleteFolder(int folderId);
}
