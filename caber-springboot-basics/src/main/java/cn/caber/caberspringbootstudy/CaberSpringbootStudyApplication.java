package cn.caber.caberspringbootstudy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.List;
import java.util.Map;

@SpringBootApplication
//@EnableScheduling  //使定时任务注解@Scheduled生效，可单独给@Scheduled写配置类
//@MapperScan("cn.caber.caberspringbootstudy.dao")//或者在mapper类上加@Mapper注解
public class CaberSpringbootStudyApplication /*implements ApplicationRunner */{

	/*@Value("${name}")
	private String name;*/



	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(CaberSpringbootStudyApplication.class, args);
		JdbcTemplate jdbcTemplate = run.getBean(JdbcTemplate.class);
//		jdbcTemplate.execute("INSERT INTO `caber`.`person` (`id`, `name`, `age`, `address`) VALUES ('3', 'zhangsan', 12, 'xian')");
//		List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from  caber.person");
//		System.out.println(maps);
	}


}
