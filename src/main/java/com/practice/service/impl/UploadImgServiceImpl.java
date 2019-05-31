package com.practice.service.impl;

import com.practice.service.UploadImgService;
import com.practice.utils.RandomUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by administer on 29/5/19.
 */
@Service
public class UploadImgServiceImpl implements UploadImgService{

    @Value("${absoluteImgPath}")
    String absoluteImgPath;

    @Value("${sonImgPath}")
    String sonImgPath;

    @Override
    public String uploadImg(MultipartFile file) {
//        Map<String,String> map = new HashMap<>();
        if(file.isEmpty()){
            return null;
        }

        String originalFilename = file.getOriginalFilename();
        String fileName = RandomUtils.createRandomString(10) + originalFilename.substring(0, 8) + ".png";
        File dest = new File(absoluteImgPath + fileName);
        String imgUrl = "https://cxyxh.top/jarvis" + sonImgPath + fileName;
        System.out.println(imgUrl);
        try{
            file.transferTo(dest);
        }catch (IllegalStateException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return imgUrl;
    }

    @Override
    public boolean deleteImg(String imgUrl) {
        String localPath = imgUrl.replaceFirst("https://cxyxh.top/jarvis/images/", absoluteImgPath);
        System.out.println(localPath);
        File file = new File(localPath);
        try {
            if (file.delete()) {
                System.out.println(file.getName() + "已删除");
                return true;
            } else {
                System.out.println(file.getName() + "删除失败!");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


}
