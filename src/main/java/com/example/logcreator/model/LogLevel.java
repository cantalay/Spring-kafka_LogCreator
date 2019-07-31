package com.example.logcreator.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum LogLevel {

    Debug,
    Info,
    Error,
    Warn,
    Fatal;

    private static final List<LogLevel> VALUES =
            Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static LogLevel randomLevel() { return VALUES.get(RANDOM.nextInt(SIZE));}


}
