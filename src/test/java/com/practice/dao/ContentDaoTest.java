package com.practice.dao;

import com.practice.entity.Content;
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
 * Created by administer on 29/5/19.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ContentDaoTest {

    @Autowired
    ContentDao contentDao;

    @Test
    @Ignore
    public void queryContentByUser() throws Exception {
        List<Content> contentList = contentDao.queryContentByUser("aaa");
        assertEquals(3, contentList.size());
    }

    @Test
    @Ignore
    public void queryContentByFolder() throws Exception {
        List<Content> contentList = contentDao.queryContentByFolder(6);
        assertEquals(2, contentList.size());
    }

    @Test
    @Ignore
    public void insertCotent() throws Exception {
        Content content = new Content();
        content.setFolderId(2);
        content.setCreatorId("aaa");
        content.setCreateTime(new Date());
        int effectedNum = contentDao.insertContent(content);
        assertEquals(effectedNum, 1);
    }

    @Test
    @Ignore
    public void modifyContent() throws Exception {
        Content content = new Content();
        content.setContentId(5);
        content.setContentTitle("test modify");
        content.setContentText("success");
        int effectedNum = contentDao.modifyContent(content);
        assertEquals(1, effectedNum);
    }

    @Test
    @Ignore
    public void deleteContent() throws Exception {
        int effectedNum = contentDao.deleteContent(5);
        assertEquals(1, effectedNum);
    }

    @Test
    @Ignore
    public void getLastInsertId() throws Exception {
        int num = contentDao.getLastInsertId();
        assertEquals(5, num);
    }

    @Test
    @Ignore
    public void deleteContentByFolder() throws Exception {
        int effectedNum = contentDao.deleteContentByFolder(1);
        assertEquals(3, effectedNum);
    }

    @Test
    public void queryIdByFolder() throws Exception {
        List<Integer> list = contentDao.queryIdByFolder(1);
        assertEquals(0, list.size());
    }
}