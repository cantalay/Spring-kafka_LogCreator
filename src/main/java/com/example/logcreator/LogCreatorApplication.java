package com.example.logcreator;

import com.example.logcreator.listener.LogFileListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling// for more info: https://www.baeldung.com/spring-scheduled-tasks
public class LogCreatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(LogCreatorApplication.class, args);
    }
}
