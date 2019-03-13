package cn.caber.caberspringbootstudy.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@RestController
@RequestMapping("/file")
public class FileUploadController {

    @Value("${file.trace}")
    private String fileTrace;

    @RequestMapping(value = "/upload",method = RequestMethod.POST,consumes= MediaType.MULTIPART_FORM_DATA_VALUE)
    public String fileUpload(@RequestParam("fiel")MultipartFile file) throws IOException {
        File file1 = new File(fileTrace + file.getOriginalFilename());
        file1.createNewFile();
        FileOutputStream fos = new FileOutputStream(file1);
        fos.write(file.getBytes());
        fos.close();
        return "ok";

    }
}
