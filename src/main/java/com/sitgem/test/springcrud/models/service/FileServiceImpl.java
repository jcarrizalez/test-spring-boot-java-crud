package com.sitgem.test.springcrud.models.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileServiceImpl implements FileService
{
    private final String src = "src//main//resources//static//images//customers";

    @Override
    public String saveStatic(MultipartFile file) {
        String name = null;
        if(!file.isEmpty()){
            Path dirImages = Paths.get(this.src);
            String pathAbsolute = dirImages.toFile().getAbsolutePath();

            try {
                name = file.getOriginalFilename().replace(" ","");
                byte[] bytesImg = file.getBytes();
                Path pathImage = Paths.get(pathAbsolute + "//" + name);
                Files.write(pathImage, bytesImg);
            } catch (IOException e){
                System.out.println(e.getMessage());
            }
        }
        return name;
    }
}
