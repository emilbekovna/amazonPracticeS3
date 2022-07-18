package com.example.demodemoamazons3.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;

import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class S3Config {
    @Value("${accessKey}")
    private String accessKey;

    @Value("${accesssecret}")
    private String secret;

    private String region = "eu-central-1";

    @Bean
    public AmazonS3 s3() {
        AWSCredentials credentials = new BasicAWSCredentials(accessKey,secret);

        return AmazonS3ClientBuilder.standard().
                withRegion(region)
                .withCredentials(new AWSStaticCredentialsProvider(credentials)).build();
    }


}
