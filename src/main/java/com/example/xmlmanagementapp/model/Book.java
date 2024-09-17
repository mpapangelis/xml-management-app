package com.example.xmlmanagementapp.model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@XmlRootElement(name="book")
public class Book {
    
    @XmlElement(name="chapter")
    private List<Chapter> chapters;
    
    @XmlElement(name="statistics")
    private Statistics statistics;
}
