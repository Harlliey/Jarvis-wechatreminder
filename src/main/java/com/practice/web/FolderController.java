package com.practice.web;

import com.practice.entity.Content;
import com.practice.entity.Folder;
import com.practice.service.ContentService;
import com.practice.service.FolderService;
import com.practice.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.security.auth.login.Configuration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by administer on 26/5/19.
 */
@RestController
@RequestMapping("/folder")
public class FolderController {
    @Autowired
    FolderService folderService;
    @Autowired
    ContentService contentService;

    @RequestMapping(value = "/listfolder", method = RequestMethod.GET)
    public Map<String, Object> listFolder() {
        Map<String, Object> modelMap = new HashMap<>();
        List<Folder> folderList = folderService.getFolderList();
        modelMap.put("folderlist", folderList);
        return modelMap;
    }

    @RequestMapping(value = "listfolderbyid", method = RequestMethod.GET)
    public Map<String, Object> listFolderById(int folderId) {
        Map<String, Object> modelMap = new HashMap<>();
        Folder folder = folderService.getFolderById(folderId);
        modelMap.put("folder", folder);
        return modelMap;
    }


    @RequestMapping(value = "/getfolderbyuser", method = RequestMethod.GET)
    public Map<String, Object> getFolderByUser(String creatorId) {
        Map<String, Object> modelMap = new HashMap<>();
        List<Folder> folderList = folderService.getFolderByUser(creatorId);
        modelMap.put("userfolderlist", folderList);
        return modelMap;
    }

    @RequestMapping(value = "/addfolder", method = RequestMethod.POST)
    public Map<String, Object> addFolder(Folder folder) {
        Map<String, Object> modelMap = new HashMap<>();
        boolean flag = folderService.addFolder(folder);
        modelMap.put("success", flag);
        return modelMap;
    }

    @RequestMapping(value = "/modifyfolder", method = RequestMethod.POST)
    public Map<String, Object> modifyFolder(Folder folder) {
        Map<String, Object> modelMap = new HashMap<>();
        boolean flag = folderService.modifyFolder(folder);
        modelMap.put("success", flag);
        return modelMap;
    }

    @RequestMapping(value = "/deletefolder", method = RequestMethod.GET)
    public Map<String, Object> deleteFolder(Integer folderId) {
        Map<String, Object> modelMap = new HashMap<>();
        boolean flag1 = contentService.deleteContentByFolder(folderId);
        if (flag1) {
            boolean flag2 = folderService.deleteFolder(folderId);
            modelMap.put("success", flag2);
        } else {
            modelMap.put("success", "先行删除备忘失败!");
        }
        return modelMap;
    }
}
