package com.speaking_clock.restController;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.speaking_clock.timeConverter.TimeConverter;

import java.time.LocalTime;

@RestController
//@Api(tags = "Time Controller", description = "Endpoints for time conversion")
public class TimeController {

	@Autowired
    private TimeConverter timeConverter;

   
    @GetMapping("/convertTime")
    public ResponseEntity<String> convertTime() {
        LocalTime currentTime = LocalTime.now();
        int hour=currentTime.getHour();
        int minute=currentTime.getMinute();
       
        String convertedTime = timeConverter.convertTimeToWords(hour,minute);
        return ResponseEntity.ok(convertedTime);
    }


    @GetMapping("/convertUserTime/{time}")
    public ResponseEntity<String> convertUserTime(@PathVariable String time) {
    	String[] times=time.split(":");
    	int hour=Integer.parseInt(times[0]);
    	int minute=Integer.parseInt(times[1]);
        String convertedTime =timeConverter.convertTimeToWords(hour,minute);
        return ResponseEntity.ok(convertedTime);
    }

   
    @GetMapping("/handleMiddayMidnight")
    public ResponseEntity<String> handleMiddayMidnight() {
        LocalTime currentTime = LocalTime.now();
        String result = timeConverter.handleMiddayMidnight(currentTime);
        return ResponseEntity.ok(result);
    }
}
