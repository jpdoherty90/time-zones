package com.doherty.timezones;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

@RestController
public class TimeZoneController {

    @GetMapping("/getTime")
    public String getTime(@RequestParam(required = false) String zone) {
        ZoneId zoneId = (zone == null) ? ZoneId.systemDefault() : TimeZone.getTimeZone(zone).toZoneId();
        LocalDateTime now = LocalDateTime.now(zoneId);
        return DateTimeFormatter.ofPattern("HH:mm:ss").format(now);
    }

}
