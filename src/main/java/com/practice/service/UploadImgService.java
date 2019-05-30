package com.practice.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * Created by administer on 29/5/19.
 */
public interface UploadImgService {
    String uploadImg(MultipartFile file);
}
