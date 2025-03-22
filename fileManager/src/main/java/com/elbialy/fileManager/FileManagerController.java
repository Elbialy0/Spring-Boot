package com.elbialy.fileManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileManagerController {
    @Autowired
    private FileManagerService fileManagerService;
    @PostMapping("/upload")
    public void upload(@RequestParam MultipartFile file) {
        try {
            fileManagerService.upload(file);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
