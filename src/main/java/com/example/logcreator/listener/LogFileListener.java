package com.example.logcreator.listener;
import com.example.logcreator.producer.KafkaLogProducer;
import org.apache.commons.io.monitor.FileAlterationListener;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;

@Component
public class LogFileListener {
    @Autowired
    private KafkaLogProducer kafkaLogProducer;
    private static Integer countLine = 0;
    private static Integer newLineCounter = 0;

    public LogFileListener() throws Exception{

        String dirName = "log/";
        FileAlterationObserver observer = new FileAlterationObserver(dirName);
        FileAlterationMonitor monitor = new FileAlterationMonitor(150);
        FileAlterationListener listener = new FileAlterationListener() {
            @Override
            public void onStart(FileAlterationObserver fileAlterationObserver) {

            }

            @Override
            public void onDirectoryCreate(File file) {

            }

            @Override
            public void onDirectoryChange(File file) {

            }

            @Override
            public void onDirectoryDelete(File file) {

            }

            @Override
            public void onFileCreate(File file) {

            }

            @Override
            public void onFileChange(File file) {
                System.out.println("File Changed: "+ file.getAbsolutePath());
                BufferedReader reader;
                try {
                    reader = new BufferedReader(new FileReader(
                            "log/out_1.txt"));
                    String line = reader.readLine();
                    while (line != null) {
                        countLine = countLine + 1;
                        // read next line
                        line = reader.readLine();
                        // detect new line
                        if (newLineCounter<=countLine){
                            System.out.println(line);
                            kafkaLogProducer.KafkaData(line.split("\\s+")[3],line);
                        }
                    }
                    reader.close();
                    newLineCounter = countLine;
                    countLine = 0;
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                //System.out.println(countLine);
            }

            @Override
            public void onFileDelete(File file) {

            }

            @Override
            public void onStop(FileAlterationObserver fileAlterationObserver) {

            }
        };
        observer.addListener(listener);
        monitor.addObserver(observer);
        monitor.start();
    }


    /*public static void count(){
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "log/out_1.txt"));
            String line = reader.readLine();
            while (line != null) {
                countLine = countLine + 1;
                // read next line
                line = reader.readLine();
                // detect new line
                if (newLineCounter<=countLine){
                    System.out.println(line);
                }
            }
            reader.close();
            newLineCounter = countLine;
            countLine = 0;
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(countLine);

    }*/
}
