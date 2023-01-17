package com.coder.trabajofinal.services;

import java.time.LocalDate;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.coder.trabajofinal.models.schemas.DateApiResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Service
public class DateApiService {

    public LocalDate getDate() throws JsonMappingException, JsonProcessingException {

        RestTemplate restTemplate = new RestTemplate();

        String url = "https://worldtimeapi.org/api/timezone/etc/UTC";
        DateApiResponse response = restTemplate.getForObject(url, DateApiResponse.class);
        LocalDate responseDate = LocalDate.parse(response.getDatetime().split("T", 2)[0]);

        return responseDate;
    }

}
