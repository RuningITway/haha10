package com.shunlian;

import com.shunlian.entity.Location;
import com.shunlian.mapper.LocationRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication
public class Haha10Application {


    @RequestMapping("/")
    public static String index() {
        return "haha10 started";
    }

    public static void main(String[] args) {
        SpringApplication.run(Haha10Application.class, args);
    }

    @Bean
    InitializingBean saveData(LocationRepository repo) {
        return () -> {
            repo.save(new Location((long) 1, "1", 38.998064, 117.317267));
            repo.save(new Location((long) 2, "2", 38.997793, 117.317069));
            repo.save(new Location((long) 3, "3", 38.998006, 117.317101));
            repo.save(new Location((long) 4, "4", 38.997814, 117.317332));
        };
    }


}
