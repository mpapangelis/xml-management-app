package com.example.xmlmanagementapp.model;

import com.example.xmlmanagementapp.util.LocalDateTimeAdapter;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlTransient;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Statistics {
    
    @XmlElement(name="totalParagraphs")
    private int totalParagraphs;
    
    @XmlElement(name="totalLines")
    private int totalLines;
    
    @XmlElement(name="totalWords")
    private int totalWords;
    
    @XmlTransient
    private Set<String> distinctWords = new HashSet<>();
    
    @XmlElement(name="creationDateTime")
    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    private LocalDateTime creationDateTime;
    
    @XmlElement(name="author")
    private String author;
    
    @XmlElement(name="applicationClassName")
    private String applicationClassName;
    
    public void incrementParagraphs() {
        this.totalParagraphs++;
    }
    
    public void incrementLines() {
        this.totalLines++;
    }
    
    public void addWords(int wordCount) {
        this.totalWords += wordCount;
    }
    
    public void addDistinctWords(String lineContent) {
        if (lineContent != null) {
            String[] words = lineContent.toLowerCase().split("\\s+");
            for (String word : words) {
                distinctWords.add(word);
            }
        }
    }
    
    @XmlElement(name="distinctWords")
    public int getDistinctWordsCount() {
        return distinctWords.size();
    }
    
    
}
