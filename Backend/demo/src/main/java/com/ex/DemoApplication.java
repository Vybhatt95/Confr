package com.ex;

import com.ex.Dao.Userdao;
import com.ex.Dao.itemDao;
import com.ex.Dao.store_FrontDao;
import com.ex.Objects.Item;
import com.ex.Objects.Store_Front;
import com.ex.Objects.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication(exclude = org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration.class)
public class DemoApplication {

    @Autowired
    Userdao dao;


    @Autowired
    itemDao daoitem;
    @Autowired
    store_FrontDao daostore;

    public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

    @Bean
    public CommandLineRunner runner(){
        return args -> {

            System.out.println(daostore.findOne(1));

            Item c = daoitem.findOne(1);
            System.out.println(c);
        };
    }

    //Example mapping to the root
    @Controller
    public class HomeContoller {
        @RequestMapping("/")
        public String index() {
            return "index.html";
        }
    }

}
