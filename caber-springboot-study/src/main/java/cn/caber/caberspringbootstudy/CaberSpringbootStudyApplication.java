package cn.caber.caberspringbootstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableScheduling  使定时任务注解@Scheduled生效，可单独给@Scheduled写配置类
//@MapperScan("cn.caber.caberspringbootstudy.dao")//或者在mapper类上加@Mapper注解
public class CaberSpringbootStudyApplication /*implements ApplicationRunner */{

	/*@Value("${name}")
	private String name;*/

	public static void main(String[] args) {
		SpringApplication.run(CaberSpringbootStudyApplication.class, args);


	}


}
