//package com.example.demodemoamazons3.apis;
//
//import com.example.demodemoamazons3.service.S3Service;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//@RestController
//@RequestMapping("/file")
//@RequiredArgsConstructor
//public class S3Controller {
//
//
//    @Autowired
//    private  S3Service s3Service;
//
//    @PostMapping("/upload")
//    public ResponseEntity <String>upload(@RequestParam(value = "file")MultipartFile file) {
//        return new ResponseEntity<>(s3Service.saveFile(file), HttpStatus.OK);
//    }
//
//    @DeleteMapping("/{fileName}")
//    public ResponseEntity <String> deleteFile(@PathVariable("fileName") String fileName) {
//        return new ResponseEntity<>(s3Service.deleteFile(fileName),HttpStatus.OK);
//    }
//}
