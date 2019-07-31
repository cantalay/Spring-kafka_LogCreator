package com.example.logcreator.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum  LogCity {

    Tokyo,
    Istanbul,
    Beijing,
    Moscov,
    London;


    private static final List<LogCity> VALUES =
            Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static LogCity randomCity(){ return VALUES.get(RANDOM.nextInt(SIZE));}
}
