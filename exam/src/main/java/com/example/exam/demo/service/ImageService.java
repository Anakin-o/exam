package com.example.exam.demo.service;

import com.example.exam.demo.model.RequestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.awt.*;

public class ImageService {
    @Autowired
    private RestTemplate restTemplate;

    private static String url = "chemdrawdirect.perkinelmer.cloud/rest/generateImage";

    public Image getImage(RequestModel requestModel) {
        return restTemplate.postForObject(url, requestModel, Image.class);
    }
}
