package cn.caber.springbootstudy.util;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

/**
 * 模板解析
 *
 * @author lihuan
 * @version 1.0 2019/05/14 20:26
 */
public class FreeMarkerUtils {

    /**
     * 获取模板
     * @param fileName
     * @param map
     * @return
     */
    public static String getTemplate(String fileName, Map<String, Object> map) {
        StringWriter out = new StringWriter();
        Configuration cfg = new Configuration();
        cfg.setDefaultEncoding("UTF-8");
        cfg.setClassForTemplateLoading(FreeMarkerUtils.class, "/ftl/");
        try {
            Template temp = cfg.getTemplate(fileName);
            temp.process(map, out);
            out.flush();
        } catch (IOException e) {
            throw new RuntimeException("读取模板数据文件失败:" + e.getMessage());
        }catch (TemplateException e) {
            throw new RuntimeException("模板数据文件解析失败:" + e.getMessage());
        }finally {
            try {
                out.close();
            } catch (IOException e) {
                throw new RuntimeException("读取模板数据文件失败:" + e.getMessage());
            }
        }

        return out.getBuffer().toString();

    }

}
