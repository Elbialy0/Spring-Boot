package com.elbialy.fileManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;

@RestController
public class FileManagerController {
    @Autowired
    private FileManagerService fileManagerService;
    @PostMapping("/upload")
    public void upload(@RequestParam("file") MultipartFile file) {
        try {
            fileManagerService.upload(file);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    @GetMapping("/download")
    public ResponseEntity<Resource> download(@RequestParam("fileName") String fileName) {
        try {
            var file = fileManagerService.getFile(fileName);
            return ResponseEntity.ok().contentLength(file.length())
                    .header("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"")
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(new InputStreamResource(Files.newInputStream(file.toPath())));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }
}
