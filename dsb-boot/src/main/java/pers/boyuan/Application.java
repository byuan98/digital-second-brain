package pers.boyuan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * dsb项目启动类
 *
 * @author ZhangBoyuan
 * @date 2022-06-11
 */
@EnableCaching
@EnableFeignClients(basePackages = {"pers.boyuan.thirdparty.*"})
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
