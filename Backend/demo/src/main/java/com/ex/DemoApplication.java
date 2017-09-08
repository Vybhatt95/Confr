package com.ex;

import com.ex.Dao.Userdao;
import com.ex.Objects.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration.class)
public class DemoApplication {

    @Autowired
    Userdao dao;

    public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

    @Bean
    public CommandLineRunner runner(){
        return args -> {
            User a = dao.findOne(1);
            System.out.println(a);
            User b = dao.findByUserName("Batman");

        };
    }


}
