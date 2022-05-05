package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class LogsProcessor {
    private String date;
    private final String FILE = "C://Users//Asus//Desktop//kohonen-oct//logs.txt";

    public LogsProcessor() {
    }

    public LogsProcessor(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFILE() {
        return FILE;
    }
    public  int getLogsByDateCount (String str)throws IOException {
        LocalDateTime start = LocalDateTime.now();

        System.out.println(str + "-" + start + " started");

        int count = (int) Files.lines(Paths.get("C://Users//Asus//Desktop//kohonen-oct//logs.txt"))
                .filter(line -> line.contains(str))
                .filter(line -> line.contains("ERROR"))
                .count();

        System.out.println(str + "-" + LocalDateTime.now().toString() +" finished" + " " +
                ChronoUnit.MILLIS.between(start,LocalDateTime.now()));
        return count;
    }
}
