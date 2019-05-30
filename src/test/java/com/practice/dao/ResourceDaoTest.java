package com.practice.dao;

import com.practice.entity.Resource;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by administer on 29/5/19.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ResourceDaoTest {

    @Autowired
    ResourceDao resourceDao;

    @Test
    @Ignore
    public void queryResourceByContent() throws Exception {
        List<Resource> list = resourceDao.queryResourceByContent(1);
        assertEquals(3, list.size());
    }

    @Test
    @Ignore
    public void insertResource() throws Exception {
        Resource resource = new Resource();
        resource.setContentId(3);
        int effectedNum = resourceDao.insertResource(resource);
        assertEquals(1, effectedNum);
    }

    @Test
    @Ignore
    public void deleteResource() throws Exception {
        int effectedNum = resourceDao.deleteResource(3);
        assertEquals(1, effectedNum);
    }

    @Test
    @Ignore
    public void deleteResourceByContent() throws Exception {
        int effectedNum = resourceDao.deleteResourceByContent(3);
        assertEquals(2, effectedNum);
    }

}