package org.fyh.controller;

import org.fyh.pojo.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class FileUploadController {
    @PostMapping("/upload")
    public Result<String> upload(MultipartFile file) throws IOException {
        String orignalFilename = file.getOriginalFilename();
        String filename = UUID.randomUUID().toString()+orignalFilename.substring(orignalFilename.lastIndexOf("."));
        file.transferTo(new File("D:\\ACM\\PetManager\\images"+orignalFilename));
        return Result.success("文件地址");
    }
}
