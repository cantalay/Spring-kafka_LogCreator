package com.example.logcreator.controller;

import com.example.logcreator.listener.LogFileListener;
import com.example.logcreator.model.Log;
import com.example.logcreator.model.LogCity;
import com.example.logcreator.model.LogLevel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.Date;

@RestController
@RequestMapping("/")
public class CreatorController {
LogFileListener logFileListener = new LogFileListener();

    @GetMapping("/create")
    public void logToFile(Integer logCount) {


        /*try {
            //File file = new File("logs/city-log.txt");

            FileOutputStream fileOut
                    = new FileOutputStream("logs/city-log.txt", true);

            BufferedWriter bw
                    = new BufferedWriter(new OutputStreamWriter(fileOut));
            for (int i = 0; i < logCount; i++){
                *//*if (file.length() < 1024 ){ System.out.println("Küçük"); file.createNewFile();}
                else {System.out.println("Değil");}*//*
                Log log = new Log();
                log.setLogLevel(LogLevel.randomLevel());
                log.setTimestamp(new Date());
                LogCity logCiy = LogCity.randomCity();
                log.setLogCity(logCiy);
                log.setDetail("Hello-From-" + logCiy);

                bw.write(log.toString());
                bw.newLine();
            }
            bw.close();
            fileOut.close();
        } catch (IOException e){e.printStackTrace();}
        logFileListener.count();*/

    }
}
