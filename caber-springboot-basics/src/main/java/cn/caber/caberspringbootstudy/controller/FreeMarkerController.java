package cn.caber.caberspringbootstudy.controller;

import cn.caber.caberspringbootstudy.component.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/ftl")
public class FreeMarkerController {

    @Autowired
    private Student student;

    @RequestMapping(value = "/index")
    public String index(ModelMap map){
        map.addAttribute("name",student.getName());
        return "freemarker/index";
    }

    @RequestMapping(value = "/indexmv")
    public ModelAndView indexmv(ModelAndView mv){
        mv.addObject("name",student.getName());
        mv.setViewName("freemarker/index");
        return mv;
    }


}
