package cn.caber.springbootstudy.load;

import org.springframework.core.io.Resource;

import java.io.*;
import java.net.URI;
import java.net.URL;

/**
 * @Description:
 * @Author: zhaikaibo
 * @Date: 2019/5/27 16:23
 */
public class StreamResource implements Resource {
    @Override
    public boolean exists() {
        return false;
    }

    @Override
    public URL getURL() throws IOException {
        return null;
    }

    @Override
    public URI getURI() throws IOException {
        return null;
    }

    @Override
    public File getFile() throws IOException {
        return null;
    }

    @Override
    public long contentLength() throws IOException {
        return 0;
    }

    @Override
    public long lastModified() throws IOException {
        return 0;
    }

    @Override
    public Resource createRelative(String s) throws IOException {
        return null;
    }

    @Override
    public String getFilename() {
        return null;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public InputStream getInputStream() throws IOException {
//        FileReader fileReader = new FileReader(new File("F:/a临时文件/beans.xml"));
        InputStream fileInputStream = new FileInputStream("F:/a临时文件/beans.xml");


        return fileInputStream;
    }
}
