package com.bravi.time.service;

import com.bravi.time.exception.InvalidTimeException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class TimeInWordsServiceIntegrationTest {

    private final TimeInWordsService subject = new TimeInWordsService();

    @Test
    void shouldReturnTextByHourWithSuccess(){

        Assertions.assertThat(subject.findTextByTime("10:00")).isEqualTo("ten o' clock");
        Assertions.assertThat(subject.findTextByTime("11:01")).isEqualTo("one minute past eleven");
        Assertions.assertThat(subject.findTextByTime("09:15")).isEqualTo("quarter past nine");
        Assertions.assertThat(subject.findTextByTime("07:25")).isEqualTo("twenty five minutes past seven");
        Assertions.assertThat(subject.findTextByTime("11:30")).isEqualTo("half past eleven");
        Assertions.assertThat(subject.findTextByTime("3:45")).isEqualTo("fifteen minutes to four");
        Assertions.assertThat(subject.findTextByTime("1:55")).isEqualTo("five minutes to two");

    }

    @Test
    void shouldReturnTextByHourWithInvalidTimeError(){

        org.junit.jupiter.api.Assertions.assertThrows(InvalidTimeException.class, () -> subject.findTextByTime("13:00"));


    }

    @Test
    void shouldReturnTextByHourWithInvalidInputError(){

        org.junit.jupiter.api.Assertions.assertThrows(InvalidTimeException.class, () -> subject.findTextByTime("asdasasd"));


    }

}