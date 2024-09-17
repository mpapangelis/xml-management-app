package com.example.xmlmanagementapp.model;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Paragraph {
    
    @XmlAttribute
    private String id;
    
    @XmlElement(name="line")
    private List<Line> lines;
}
