package com.example.xmlmanagementapp.util;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class LocalDateTimeAdapter extends XmlAdapter<String, LocalDateTime>{

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
    
    @Override
    public LocalDateTime unmarshal(String vt) throws Exception {
        return LocalDateTime.parse(vt, FORMATTER);
    }

    @Override
    public String marshal(LocalDateTime bt) throws Exception {
        return bt.format(FORMATTER);
    }
    
}
