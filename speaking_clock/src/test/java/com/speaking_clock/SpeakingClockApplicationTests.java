package com.speaking_clock;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.speaking_clock.timeConverter.TimeConverter;

@SpringBootTest
class SpeakingClockApplicationTests {

    @Autowired
    private TimeConverter timeConverter;

    @Test
    void contextLoads() {
        // Ensure that the application context loads successfully
    }

    @Test
    void testConvertToWords() {
        // Write tests for your TimeService methods
        LocalTime time = LocalTime.of(14, 32); // 2:30 PM
        String result = timeConverter.convertTimeToWords(time.getHour(),time.getMinute());
        assertEquals("It's Fourteen Thirty Two", result);
    }

    @Test
    void testConvertUserInputToWords() {
        
        String result =timeConverter.convertTimeToWords(3,45);
        assertEquals("It's Three Fourty Five", result);
    }

    @Test
    void testHandleMiddayMidnight() {
        LocalTime midday = LocalTime.NOON;
        LocalTime midnight = LocalTime.MIDNIGHT;

        String resultMidday = timeConverter.handleMiddayMidnight(midday);
        String resultMidnight = timeConverter.handleMiddayMidnight(midnight);

        assertEquals("It's Midday", resultMidday);
        assertEquals("It's Midnight", resultMidnight);
    }
}
