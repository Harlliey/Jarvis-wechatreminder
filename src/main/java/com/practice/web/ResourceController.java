package com.practice.web;

import com.practice.entity.Resource;
import com.practice.service.ResourceService;
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
@RequestMapping("/resource")
public class ResourceController {

    @Autowired
    ResourceService resourceService;

    @RequestMapping(value = "/listresbycontent", method = RequestMethod.GET)
    public Map<String, Object> listResByContent(Integer contentId) {
        Map<String, Object> modelMap = new HashMap<>();
        List<Resource> resList = resourceService.getResourceByContent(contentId);
        modelMap.put("reslist", resList);
        return modelMap;
    }

    @RequestMapping(value = "/addresource", method = RequestMethod.POST)
    public Map<String, Object> addContent(Resource resource) {
        Map<String, Object> modelMap = new HashMap<>();
        boolean flag = resourceService.addResource(resource);
        modelMap.put("success", flag);
        return modelMap;
    }

    @RequestMapping(value = "/deleteresource", method = RequestMethod.GET)
    public Map<String, Object> deleteContent(Integer resId) {
        Map<String, Object> modelMap = new HashMap<>();
        boolean flag = resourceService.deleteResource(resId);
        modelMap.put("success", flag);
        return modelMap;
    }
}
