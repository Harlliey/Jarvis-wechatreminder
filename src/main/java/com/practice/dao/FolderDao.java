package com.practice.dao;

import com.practice.entity.Folder;

import java.util.List;

/**
 * Created by administer on 26/5/19.
 */
public interface FolderDao {
    List<Folder> queryFolder();
    List<Folder> queryFolderByUser(String creatorId);
    int insertFolder(Folder folder);
    int updateFolder(Folder folder);
    int deleteFolder(int folderId);
}
