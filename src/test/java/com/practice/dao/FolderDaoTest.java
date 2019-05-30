package com.practice.dao;

import com.practice.entity.Folder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by administer on 26/5/19.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FolderDaoTest {

    @Autowired
    FolderDao folderDao;

    @Test
    @Ignore
    public void queryFolder() throws Exception {
        List<Folder> list = folderDao.queryFolder();
        assertEquals(2, list.size());
    }

    @Test
    @Ignore
    public void queryFolderByUser() throws Exception {
        List<Folder> list = folderDao.queryFolderByUser("aaa");
        assertEquals(2, list.size());
    }

    @Test
    @Ignore
    public void insertFolder() throws Exception {
        Folder folder = new Folder();
        folder.setFolderName("大英");
        folder.setNumItems(1);
        folder.setPriority(0);
        folder.setCreateTime(new Date());
        folder.setModifyTime(new Date());
        folder.setCreatorId("aaa");
        int effectedNum = folderDao.insertFolder(folder);
        assertEquals(1, effectedNum);
    }

    @Test
    @Ignore
    public void updateFolder() throws Exception {
        Folder folder = new Folder();
        folder.setFolderId(3);
        folder.setFolderName("大学英语");
        folder.setModifyTime(new Date());
        int effectedNum = folderDao.updateFolder(folder);
        assertEquals(1, effectedNum);
    }

    @Test
    @Ignore
    public void deleteFolder() throws Exception {
        int effectedNum = folderDao.deleteFolder(3);
        assertEquals(1, effectedNum);
    }

}