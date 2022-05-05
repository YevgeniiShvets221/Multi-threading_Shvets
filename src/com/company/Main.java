package com.company;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Main {

    static class MyThread extends Thread{
        private final String date;

        public MyThread(String date) {
            this.date = date;
        }
        @Override
        public void run(){
            LogsProcessor processor = new LogsProcessor(date);
            try {
                processor.getLogsByDateCount(date);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) throws IOException {

        LogsProcessor processor = new LogsProcessor();

        LocalDateTime start = LocalDateTime.now();
        System.out.println("------------------------");
        processor.getLogsByDateCount("2019-10-16");
        processor.getLogsByDateCount("2019-10-17");
        processor.getLogsByDateCount("2019-10-18");
        processor.getLogsByDateCount("2019-10-19");
        processor.getLogsByDateCount("2019-10-20");
        System.out.println("------------------------");
        System.out.println(ChronoUnit.MILLIS.between(start, LocalDateTime.now()));
        System.out.println("------------------------");

        new MyThread("2019-10-16").start();
        new MyThread("2019-10-17").start();
        new MyThread("2019-10-18").start();
        new MyThread("2019-10-19").start();
        new MyThread("2019-10-20").start();

    }

}
