package com.bravi.time.strategy;

import com.bravi.time.exception.InvalidTimeException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class TimeInWordsStrategyTest {

    @Test
    void shouldReturnTextByHourWithSuccess() {

        Assertions.assertThat(TimeInWordsStrategy.findTextByTime(10,0)).isEqualTo("ten o' clock");
        Assertions.assertThat(TimeInWordsStrategy.findTextByTime(11,1)).isEqualTo("one minute past eleven");
        Assertions.assertThat(TimeInWordsStrategy.findTextByTime(9,15)).isEqualTo("quarter past nine");
        Assertions.assertThat(TimeInWordsStrategy.findTextByTime(7,25)).isEqualTo("twenty five minutes past seven");
        Assertions.assertThat(TimeInWordsStrategy.findTextByTime(11,30)).isEqualTo("half past eleven");
        Assertions.assertThat(TimeInWordsStrategy.findTextByTime(3,45)).isEqualTo("fifteen minutes to four");
        Assertions.assertThat(TimeInWordsStrategy.findTextByTime(1,55)).isEqualTo("five minutes to two");

    }

    @Test
    void shouldReturnTextByHourWithError() {

        org.junit.jupiter.api.Assertions.assertThrows(InvalidTimeException.class, () -> TimeInWordsStrategy.findTextByTime(12,61));

    }


}