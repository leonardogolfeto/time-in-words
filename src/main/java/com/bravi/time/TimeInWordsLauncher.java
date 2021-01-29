package com.bravi.time;

import com.bravi.time.service.TimeInWordsService;

public class TimeInWordsLauncher {

    public static void main(String[] args) {
        System.out.println(new TimeInWordsService().findTextByTime(args[0]));
    }
}
