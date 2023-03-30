package cn.caber.springbootstudy.env;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "ql")
public class TestConfig {

    private List<String> caberNames;
    private Integer caberSize;

    public List<String> getCaberNames() {
        return caberNames;
    }

    public void setCaberNames(List<String> caberNames) {
        this.caberNames = caberNames;
    }

    public Integer getCaberSize() {
        return caberSize;
    }

    public void setCaberSize(Integer caberSize) {
        this.caberSize = caberSize;
    }

    @Override
    public String toString() {
        return "TestConfig{" +
                "caberNames=" + caberNames +
                ", caberSize=" + caberSize +
                '}';
    }
}
