package com.ztm.messageboard.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class ImageUtil {

    public static String add(MultipartFile image,String imagePath,String sonPath,String domainName){
        if (image.isEmpty()) {
            System.out.println("文件为空");
        }
        String fileName = image.getOriginalFilename();  // 文件名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
        fileName = UUID.randomUUID() + suffixName; // 新文件名
        File dest = new File(imagePath + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            image.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String filename = domainName +sonPath+ fileName;
        return filename;
    }
}
