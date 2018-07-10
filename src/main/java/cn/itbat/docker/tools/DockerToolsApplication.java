package cn.itbat.docker.tools;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


/**
 * 启动类
 *
 * @author log.r   (;￢＿￢)   
 * @date 2018-07-04 下午1:58
 **/
@EnableCaching
@MapperScan("cn.itbat.docker.tools.mapper")
@SpringBootApplication
public class DockerToolsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DockerToolsApplication.class, args);
    }
}
