package com.practice.web;

import com.practice.service.UploadImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by administer on 29/5/19.
 */
@RestController
public class UpLoadImgController {

    @Autowired
    UploadImgService uploadImgService;

    @RequestMapping(value = "uploadimg", method = RequestMethod.POST)
    public Map<String, Object> upLoadImg(MultipartFile file) {
        Map<String, Object> modelMap = new HashMap<>();
        String imgUrl = uploadImgService.uploadImg(file);
        modelMap.put("success", imgUrl);
        return modelMap;
    }
}
