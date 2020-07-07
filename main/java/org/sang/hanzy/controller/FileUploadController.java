package org.sang.hanzy.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
@RestController
public class FileUploadController {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

    @PostMapping("/upload")
    public String upload(MultipartFile uploadFile, HttpServletRequest request) {
        String realPath = request.getSession().getServletContext().getRealPath("/uploadFile/");
        String format = sdf.format(new Date());
        File file = new File(realPath + format);
        if (!file.isDirectory()) {
            file.mkdirs();
        }
        String ordName = uploadFile.getOriginalFilename();
        String newName = UUID.randomUUID().toString() + ordName.substring(ordName.lastIndexOf("."), ordName.length());
        try {
            uploadFile.transferTo(new File(file,newName));
            String filePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/uploadFile/" + format + newName;
            return filePath;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "上传失败";
    }
}
