package com.ztm.messageboard.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class ImageUtil {
    /**
     * 把前端传的图片保存
     * @param  image imagePath  sonPath  domainName
     * @return String
     */
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

    /**
     * 删除图片
     * @param   imagePath  domainName
     * @return 图片删除成功返回true，否则返回false
     */
    public static Boolean deleteImage(String imagePath,String domainName) {
        Boolean flag = false;
        String sonPath = imagePath.replace(domainName,"");
        String filePath = "D://MBDataBase"+sonPath;
        System.out.println(filePath);
        File file = new File(filePath);
        // 路径为文件且不为空则进行删除
        if (file.isFile() && file.exists()) {
            file.delete();
            flag = true;
        }
        return flag;
    }
}
