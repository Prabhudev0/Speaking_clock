package com.speaking_clock.timeConverter;

import java.time.LocalTime;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class TimeConverter {

    private static final String[] hoursNames = {
            "", "One", "Two", "Three", "Four", "Five", "Six",
            "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve",
            "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
            "Eighteen", "Nineteen", "Twenty", "Twenty One", "Twenty Two",
            "Twenty Three"
    };

    private static final String[] minutesNames = {
            "", "Ten", "twenty", "Thirty", "Fourty", "Fifty", "Sixty"
    };

    public static String convertTimeToWords(int hours,int minutes) {
       
    	int tens = minutes / 10;
        int ones = minutes % 10;
        String timeInWords = "It's ";

        if (hours >= 0 && hours <= 23) {
            timeInWords += hoursNames[hours] + " "+ minutesNames[tens] +" "+ hoursNames[ones];
           
        } else {
            timeInWords = "Invalid time format";
        }

        return timeInWords;
    }

    public String handleMiddayMidnight(LocalTime time) {
        return (time.equals(LocalTime.NOON)) ? "It's Midday" : "It's Midnight";
    }
    

   
}
