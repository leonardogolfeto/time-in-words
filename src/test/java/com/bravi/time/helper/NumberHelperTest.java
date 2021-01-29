package com.bravi.time.helper;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.bravi.time.helper.NumberHelper.textByNumber;


class NumberHelperTest {

    @Test
    void shouldReturnTextByNumber(){

        Assertions.assertThat(textByNumber(10)).isEqualTo("ten");

    }

}