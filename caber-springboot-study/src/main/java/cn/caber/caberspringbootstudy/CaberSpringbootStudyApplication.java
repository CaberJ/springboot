package cn.caber.caberspringbootstudy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan("cn.caber.caberspringbootstudy.dao")//或者在mapper类上加@Mapper注解
public class CaberSpringbootStudyApplication /*implements ApplicationRunner */{

	/*@Value("${name}")
	private String name;*/

	public static void main(String[] args) {
		SpringApplication.run(CaberSpringbootStudyApplication.class, args);
	}


}
