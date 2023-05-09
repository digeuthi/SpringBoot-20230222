package com.dahye.firstproject.service.implement;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dahye.firstproject.service.FileService;

@Service
public class FileServiceImplement implements FileService{
    @Value("${file.path}") 
    private String FILE_PATH;
    @Value("${file.url}") 
    private String FILE_URL;

    @Override
    public String upload(MultipartFile file) {
        //검증
        if(file.isEmpty()) return null;

        //파일명 가져오기
        String originalFileName = file.getOriginalFilename();
        // 확장자 가져오기
        int extensionIndex = originalFileName.lastIndexOf("."); //.이 있는 위치의 인덱스 가져오기
        String extension = originalFileName.substring(extensionIndex); //. 이후의 확장자 가져오는것

        // 파일의 새로운 이름 지정 //여러 사람들이 이미지를 올리면 그때 마다 파일 이름이 여러개일것. 이거 설정

    }
    
}
