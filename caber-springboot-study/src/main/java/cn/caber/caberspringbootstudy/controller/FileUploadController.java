package cn.caber.caberspringbootstudy.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@RestController
@RequestMapping("/file")
public class FileUploadController {

    @Value("${file.trace}")
    private String fileTrace;

    @RequestMapping(value = "/upload",method = RequestMethod.POST,consumes= MediaType.MULTIPART_FORM_DATA_VALUE)
    public String fileUpload(@RequestParam("file") MultipartFile file) throws IOException {
        File file1 = new File(fileTrace + file.getOriginalFilename());
        file1.createNewFile();
        FileOutputStream fos = new FileOutputStream(file1);
        fos.write(file.getBytes());
        fos.close();
        return "ok";

    }

    @RequestMapping(value = "/read",method = RequestMethod.POST,consumes= MediaType.MULTIPART_FORM_DATA_VALUE)
    public String fileRead(@RequestParam("file") MultipartFile file) throws IOException {

        InputStream inputStream = file.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        StringBuffer stringBuffer = new StringBuffer();

        String line = null;
        while ((line=bufferedReader.readLine())!=null){
            stringBuffer.append(line);
        }
        String text = stringBuffer.toString();

        return text;

    }
}
