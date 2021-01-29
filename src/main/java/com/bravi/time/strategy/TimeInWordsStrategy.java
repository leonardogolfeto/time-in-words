package com.bravi.time.strategy;

import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

import com.bravi.time.exception.InvalidTimeException;


import static com.bravi.time.helper.NumberHelper.textByNumber;

public enum TimeInWordsStrategy {

    O_CLOCK(i -> i == 0, array -> textByNumber(array[0]) + " o' clock"),
    MINUTE_PAST(i -> i == 1, array -> textByNumber(array[1]) + " minute past " + textByNumber(array[0])),
    QUARTER_PAST(i -> i == 15, array -> "quarter past " + textByNumber(array[0])),
    HALF_PAST(i -> i == 30, array -> "half past " + textByNumber(array[0])),
    MINUTES_PAST(i -> i < 30, array -> textByNumber(array[1]) + " minutes past " + textByNumber(array[0])),
    MINUTES_TO(i -> i > 30, array -> textByNumber(60 - array[1]) + " minutes to " + textByNumber(array[0] + 1)),
    QUARTER_TO(i -> i == 45, array -> "quarter to " + textByNumber(array[0] + 1));

    private final Predicate<Integer> valid;
    private final Function<Integer[], String> apply;

    TimeInWordsStrategy(Predicate<Integer> rule, Function<Integer[], String> apply) {
        this.valid = rule;
        this.apply = apply;
    }

    public static String findTextByTime(Integer hour, Integer minutes){

        AtomicReference<String> result = new AtomicReference<>();

        Integer[] time = {hour, minutes};

        Stream.of(TimeInWordsStrategy.values())
                .filter(strategy -> strategy.valid.test(minutes))
                .findAny()
                .ifPresent(strategy -> result.set(strategy.apply.apply(time)));

        return result.get();

    }


}
