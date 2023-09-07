package com.cyl.gropubuy.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author：Java陈序员
 * @date：2023/8/31 11:08
 * @description：后台服务主启动类
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.cyl.groupbuy.framework", "com.cyl.gropubuy.admin"})
public class AdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }
}
