//package com.example.demodemoamazons3.service;
//
//import com.amazonaws.services.s3.AmazonS3;
//import com.amazonaws.services.s3.model.PutObjectResult;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//
//@Service
//public class S3Service implements FileServiceImpl {
//
//    private String bucketName = "ebookjava5";
//
//    private final AmazonS3 s3;
//
//    public S3Service(AmazonS3 s3) {
//        this.s3 = s3;
//    }
//
//    @Override
//    public String saveFile(MultipartFile file) {
//        String originalFileName = file.getOriginalFilename();
//        try {
//            File file1 = convertMultiPartToFile(file);
//            PutObjectResult putObjectResult = s3.putObject(bucketName, originalFileName, file1);
//            return putObjectResult.getContentMd5();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Override
//    public String deleteFile(String fileName) {
//        s3.deleteObject(bucketName,fileName);
//        return "File deleted";
//    }
//    private File convertMultiPartToFile(MultipartFile file) throws IOException {
//        File confile = new File(file.getOriginalFilename());
//        FileOutputStream fos = new FileOutputStream(confile);
//        fos.write(file.getBytes());
//        fos.close();
//        return confile;
//    }
//}
