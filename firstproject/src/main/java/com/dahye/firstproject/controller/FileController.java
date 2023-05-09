package com.dahye.firstproject.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("file")
public class FileController { //api 서버가 아니므로 api 붙이지 않았다.

    // 파일 업로드 (이미지만 진행)
    @PostMapping("upload")
    public String upload(
        @RequestParam("file") MultipartFile file
    ) {
        return file.getOriginalFilename();
    }
    
}
