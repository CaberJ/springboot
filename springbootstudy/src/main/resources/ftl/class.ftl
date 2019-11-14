package cn.caber.springbootstudy.bean;
import org.springframework.stereotype.Component;

@Component
public class ${name} {
    private String name;

    public ${name}() {
    }

    public ${name}(String name) {
    this.name = name;
    }

    public String getName() {
    return name;
    }

    public void setName(String name) {
    this.name = name;
    }

}
