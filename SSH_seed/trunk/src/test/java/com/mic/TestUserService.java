/*
 * Creation : Feb 4, 2017
 */
package com.mic;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mic.service.IUserService;

public class TestUserService {
    @Test
    public void test() {
        // 通过spring.xml配置文件创建Spring的应用程序上下文环境
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring.xml");
        // 从Spring的IOC容器中获取bean对象
        IUserService userService = (IUserService) ac.getBean("userService");
        // 执行测试方法
        userService.test();
    }
}
