package com.sitgem.test.springcrud.models.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    public String saveStatic(MultipartFile file);
}
