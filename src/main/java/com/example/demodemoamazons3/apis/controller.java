package com.example.demodemoamazons3.apis;

import com.example.demodemoamazons3.service.AWSS3Service;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

public class controller {

    @RestController
    @AllArgsConstructor
    @RequestMapping("api/files")
    @CrossOrigin(origins = "*", maxAge = 3600)
    public class AWSS3ClientApi {
        private AWSS3Service awsS3Service;

        @Operation(summary = "Upload file", description = "This endpoint for upload file to s3")
        @PostMapping("/upload")
        public ResponseEntity<Map<String, String>> uploadFile(@RequestParam("file") MultipartFile file) {
            String publicURL = awsS3Service.uploadFile(file);
            Map<String, String> response = new HashMap<>();
            response.put("URL", publicURL);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }

        @Operation(summary = "Delete the file ",
                description = "Delete file in s3")
        @DeleteMapping("/delete")
        public String deleteFile(@RequestParam String file) {
            return awsS3Service.deleteFile(file);
        }
    }

}
