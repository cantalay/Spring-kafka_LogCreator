package com.example.logcreator.listener;
import java.io.*;

public class LogFileListener {

    private static Integer countLine = 0;
    private static Integer newLineCounter = 0;


    public static void count(){
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "logs/city-log.txt"));
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

    }
}
