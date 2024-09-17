package com.example.xmlmanagementapp.model;

import jakarta.xml.bind.annotation.XmlElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Line {
    
    @XmlElement(name="content")
    private String content;
}
