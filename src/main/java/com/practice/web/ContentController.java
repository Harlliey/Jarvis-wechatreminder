package com.practice.web;

import com.practice.entity.Content;
import com.practice.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by administer on 29/5/19.
 */
@RestController
@RequestMapping("/content")
public class ContentController {

    @Autowired
    ContentService contentService;

    @RequestMapping(value = "/listcontentbyfolder", method = RequestMethod.GET)
    public Map<String, Object> listContentByFolder(Integer folderId) {
        Map<String, Object> modelMap = new HashMap<>();
        List<Content> contentList = contentService.getContentByFolder(folderId);
        modelMap.put("contentListbyFolder", contentList);
        return modelMap;
    }

    @RequestMapping(value = "/listcontentbyuser", method = RequestMethod.GET)
    public Map<String, Object> listContentByUser(String creatorId) {
        Map<String, Object> modelMap = new HashMap<>();
        List<Content> contentList = contentService.getContentByUser(creatorId);
        modelMap.put("contentListbyFolder", contentList);
        return modelMap;
    }

    @RequestMapping(value = "/listcontentbyid", method = RequestMethod.GET)
    public Map<String, Object> listContentById(int contentId) {
        Map<String, Object> modelMap = new HashMap<>();
        Content content = contentService.getContentById(contentId);
        modelMap.put("content", content);
        return modelMap;
    }

    @RequestMapping(value = "/addcontent", method = RequestMethod.POST)
    public Map<String, Object> addContent(Content content) {
        Map<String, Object> modelMap = new HashMap<>();
        int lastInsertId = contentService.addContent(content);
        modelMap.put("success", lastInsertId);
        return modelMap;
    }

    @RequestMapping(value = "/modifycontent", method = RequestMethod.POST)
    public Map<String, Object> modifyContent(Content content) {
        Map<String, Object> modelMap = new HashMap<>();
        boolean flag = contentService.modifyContent(content);
        modelMap.put("success", flag);
        return modelMap;
    }

    @RequestMapping(value = "/deletecontent", method = RequestMethod.GET)
    public Map<String, Object> deleteContent(Integer contentId) {
        Map<String, Object> modelMap = new HashMap<>();
        boolean flag = contentService.deleteContent(contentId);
        modelMap.put("success", flag);
        return modelMap;
    }
}
