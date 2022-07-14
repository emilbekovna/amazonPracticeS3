package com.example.demodemoamazons3.apis;

import com.example.demodemoamazons3.service.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class S3Controller {
    @Autowired
    private S3Service s3Service;

    @PostMapping("upload")
    public String upload(@RequestParam("file")MultipartFile file) {
        return s3Service.saveFile(file);
    }

    @DeleteMapping("{fileName}")
    public String deleteFile(@PathVariable("fileName") String fileName) {
        return s3Service.deleteFile(fileName);
    }


}
