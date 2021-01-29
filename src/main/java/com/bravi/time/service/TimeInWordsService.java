package com.bravi.time.service;

import com.bravi.time.exception.InvalidTimeException;
import com.bravi.time.strategy.TimeInWordsStrategy;

public class TimeInWordsService {

    public String findTextByTime(String time){

        int hour = getInteger(time, 0);
        int minutes = getInteger(time, 1);

        validate(hour, minutes);

        return TimeInWordsStrategy.findTextByTime(hour, minutes);

    }

    private void validate(int hour, int minutes) {
        if(hour > 12 || hour < 0 || minutes > 59 || minutes < 0) {
            throw new InvalidTimeException("Invalid time format, EX: 11:59");
        }
    }

    private int getInteger(String time, int arrayPosition) {

        try {
            return Integer.parseInt(time.split(":")[arrayPosition]);
        } catch (Exception ex) {
            throw new InvalidTimeException("Invalid time format, EX: 11:59");

        }

    }

}
