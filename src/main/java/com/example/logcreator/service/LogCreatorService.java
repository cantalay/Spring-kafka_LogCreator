package com.example.logcreator.service;

import com.example.logcreator.model.Log;
import com.example.logcreator.model.LogLevel;
import com.example.logcreator.model.LogCity;
import org.springframework.stereotype.Service;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class LogCreatorService {
    private static String filePath = "log/out";
    private static Integer filePathCount = 1;
    private static final int MAX_FILE_SIZE = 1024 * 1024 * 2;
    private int count = 0;

    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");


    private Log createLog() {

        Log log = new Log();
        String timestamp = formatter.format(new Date());
        log.setTimestamp(timestamp);
        log.setLogCity(LogCity.randomCity());
        log.setLogLevel(LogLevel.randomLevel());
        log.setDetail("Hello-from-" + log.getLogCity().name());
        return log;
    }

    public void writeLogToFile() {


        File fout;
        if (!checkFileSize(filePath + "_" + filePathCount + ".txt")) {
            filePathCount++;
            count = 0;
        }
        fout = new File(filePath + "_" + filePathCount + ".txt");
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(fout, true);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
            Log log = createLog();
//            System.out.println("count  ---- " + log.getCount());
//            System.out.println("level : " + log.getLevel());
//            System.out.println("detail : " + log.getDetail());
            bw.write(log.toString());
            bw.newLine();
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private boolean checkFileSize(String filePath) {
        File file = new File(filePath);
        long fileSizeInBytes = file.length();
        return fileSizeInBytes < MAX_FILE_SIZE;
    }

}
