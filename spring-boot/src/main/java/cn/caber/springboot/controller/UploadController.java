package cn.caber.springboot.controller;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Map;

@RestController
public class UploadController {

    public static final ThreadLocal<Map<String,String>> map = new ThreadLocal<>();


    @GetMapping("/abc")
    public void upload(HttpServletResponse response) throws IOException, InvalidFormatException {
        OutputStream outputStream = null;
        /*response.addHeader("content-disposition",
                "attachment;filename=" + java.net.URLEncoder.encode("测试文件.xlsx", "utf-8"));
        response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);*/

        String fileName = "测试文件";
        response.setHeader("Content-Disposition", "attachment;filename=" +new String(fileName.getBytes(),"iso-8859-1")+".xlsx");
        response.setContentType("application/vnd.ms-excel;charset=UTF-8");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        outputStream = response.getOutputStream();

        HSSFWorkbook sheets = new HSSFWorkbook();
        Sheet sheet = sheets.createSheet("测试sheet");
        Row row = sheet.createRow(0);
        for (int i = 0; i < 20; i++) {
            Cell cell = row.createCell(i);
            cell.setCellType(CellType.STRING);
            cell.setCellValue("字段" + i);
        }
        Row row1 = sheet.createRow(1);
        for (int i = 0; i < 20; i++) {
            Cell cell = row1.createCell(i);
            cell.setCellType(CellType.STRING);
            cell.setCellValue("值" + 1);
        }

        sheets.write(outputStream);
        sheets.close();
    }
}
