package com.example.xmlmanagementapp.model;

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
    
    private int totalParagraphs;
    private int totalLines;
    private int totalWords;
    private Set<String> distinctWords = new HashSet<>();
    
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
        String[] words = lineContent.toLowerCase().split("\\s+");
        for (String word : words) {
            distinctWords.add(word);
        }
    }
    
    public int getDistinctWordsCount() {
        return distinctWords.size();
    }
    
    
}
