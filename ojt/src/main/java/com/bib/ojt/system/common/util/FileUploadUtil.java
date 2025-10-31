package com.bib.ojt.system.common.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileUploadUtil {
    private static final String UPLOAD_DIR = "src/main/resources/static/upload/studentimage";
    public static void saveFile(String filename , MultipartFile file)throws IOException{
        Path uploadPath = Paths.get(UPLOAD_DIR);
        if (!Files.exists(uploadPath)) Files.createDirectories(uploadPath);
        try (InputStream inputStream = file.getInputStream()){
            Path filePath = uploadPath.resolve(filename);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        }
    }
}
/*
* package bib.com.bookstore.common.util;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
public class FileUploadUtil {
   private static final String UPLOAD_DIR = "src/main/resources/static/upload/book-images/
"; // storage path
   public static void saveFile(String filename, MultipartFile file) throws IOException {
      Path uploadPath = Paths.get(UPLOAD_DIR);
      if (!Files.exists(uploadPath)) Files.createDirectories(uploadPath); // create the folder if it does not exist
      try (InputStream inputStream = file.getInputStream()) {
         Path filePath = uploadPath.resolve(filename);
         Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
      }
   }
}*/
