package com.example.demodemoamazons3.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.UUID;

@AllArgsConstructor
@Service
@Slf4j
public class AWSS3Service implements FileService {


    private final AmazonS3 awsS3Client;

    @Override
    public String uploadFile(MultipartFile file) {

        String filenameExtension = StringUtils.getFilenameExtension(file.getOriginalFilename());

        String key = UUID.randomUUID().toString() + "." + filenameExtension;

        ObjectMetadata metaData = new ObjectMetadata();
        metaData.setContentLength(file.getSize());
        metaData.setContentType(file.getContentType());

        try {
            awsS3Client.putObject("ebookjava5", key, file.getInputStream(), metaData);
            log.info("upload the file");
        } catch (IOException e) {
            log.error("an exception occured while uploading the file");
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "An exception occured while uploading the file");
        }

        awsS3Client.setObjectAcl("ebookjava5", key, CannedAccessControlList.PublicRead);

        return awsS3Client.getResourceUrl("ebookjava5", key);
    }

    @Override
    public String deleteFile(String file) {
        String[] fileName = file.split("/");
        awsS3Client.deleteObject("ebookjava5", fileName[fileName.length - 1]);
        log.info("File deleted");
        return "Deleted File: " + file;
    }

    @Override
    public byte[] downloadFile(String file) {
        S3Object object = awsS3Client.getObject("ebookjava5", file);
        S3ObjectInputStream objectContent = object.getObjectContent();
        try {
            return IOUtils.toByteArray(objectContent);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }}
