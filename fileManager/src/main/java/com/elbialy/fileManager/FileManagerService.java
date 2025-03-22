package com.elbialy.fileManager;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

@Service
public class FileManagerService {
    private static final String UPLOAD_DIR = "D:\\upload";
    public void upload(MultipartFile file) throws IOException {
        if(file == null){ // check if the file passed or not
            throw new IOException("there is a problem in upload");
        }
        var savedFile = new File(UPLOAD_DIR + File.separator + file.getOriginalFilename());
        if (!Objects.equals(savedFile.getParent(), UPLOAD_DIR)){ // security check
            throw new SecurityException("Unsafe file path");
        }

        Files.copy(file.getInputStream(),savedFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        // if the file is present it will replace it

    }
    public File getFile(String fileName) throws FileNotFoundException {
        if (null == fileName){
            throw new IllegalArgumentException("file name is null");
        }
        var file = new File(UPLOAD_DIR + File.separator + fileName);
        if(!Objects.equals(file.getParent(), UPLOAD_DIR)){
            throw new SecurityException("Unsafe file path");
        }
        if (!file.exists()){
            throw new FileNotFoundException("file not found");
        }
        return file;
    }
}
