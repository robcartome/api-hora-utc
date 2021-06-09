package com.example.demo.controllers;

import java.time.*;
import java.time.format.*; 
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.demo.models.DateModel;
import org.springframework.http.*;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})

@RequestMapping("/api")
public class UtcController {

  @GetMapping("/")
  public String hola(){
    return "Hola Mundo";
  }

  
  @PostMapping("/utc")
  public ResponseEntity<Object> horaToUtc(@RequestBody DateModel date){
    ZoneId zonaHoraria = ZoneId.of(date.getZona());
    String strDate = date.getFecha();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    LocalDateTime localtDateAndTime = LocalDateTime.parse(strDate, formatter);
    ZonedDateTime dateAndTimeInSydney = ZonedDateTime.of(localtDateAndTime, zonaHoraria );
    ZonedDateTime utcDate = dateAndTimeInSydney.withZoneSameInstant(ZoneOffset.UTC);
     SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    String horaUtc  = dateFormat.format( Timestamp.valueOf(utcDate.format(formatter)));
    
    return new ResponseEntity<Object>(responseData(horaUtc), HttpStatus.OK);
  }

  // Estructura de respuesta
  private HashMap responseData(String horaUtc){
    HashMap<String, HashMap> mapResponse = new HashMap<>();
    HashMap<String, String> responseData = new HashMap<>();
    responseData.put("time", horaUtc);
    responseData.put("timeZone", "utc");
    mapResponse.put("response", responseData);
    return  mapResponse;
  }
}