package mic.springdata.jpa.test;

import mic.springdata.jpa.domain.AccountInfo;
import mic.springdata.jpa.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.PageRequest;

import java.util.List;


public class SimpleSpringJpaDemo {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-demo-cfg.xml");
        UserService userService = ctx.getBean("userService", UserService.class);
//        userService.createNewAccount("g", "ggg", 700);
        List<AccountInfo> accountInfoList= userService.findByBalanceGreaterThan(100, new PageRequest(0, 2));
        for(AccountInfo accInfoTemp:accountInfoList){
            System.out.println(accInfoTemp.toString());
        }

    }
}
