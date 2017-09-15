package com.ex;

import com.ex.Dao.Userdao;
import com.ex.Dao.itemDao;
import com.ex.Dao.listsDao;
import com.ex.Dao.store_FrontDao;
import com.ex.Objects.Item;
import com.ex.Objects.Lists;
import com.ex.Objects.Store_Front;
import com.ex.Objects.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@SpringBootApplication(exclude = org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration.class)
public class DemoApplication {




    public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
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
