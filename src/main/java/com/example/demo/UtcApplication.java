package com.example.demo;

import java.time.*;
import java.time.format.*; 
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HolaMundo {

  @RequestMapping("/")
  public String hola(){
    return "Hola Mundo";
  }

  @RequestMapping("/utc")
  public String horaToUtc(){
    ZoneId zonaHoraria = ZoneId.of("-3");
    String str = "2021-06-07 18:31:45";
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    LocalDateTime localtDateAndTime = LocalDateTime.parse(str, formatter);
    ZonedDateTime dateAndTimeInSydney = ZonedDateTime.of(localtDateAndTime, zonaHoraria );
    // System.out.println("Current date and time in a particular timezone : " + dateAndTimeInSydney);
    ZonedDateTime utcDate = dateAndTimeInSydney.withZoneSameInstant(ZoneOffset.UTC);
    // System.out.println("Current date and time in UTC : " + utcDate);
    LocalDateTime aLDT = LocalDateTime.parse("2021-06-06T18:36:30");
     SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    String string  = dateFormat.format( Timestamp.valueOf(utcDate.format(formatter)));
    return ""+ string;
  }
}