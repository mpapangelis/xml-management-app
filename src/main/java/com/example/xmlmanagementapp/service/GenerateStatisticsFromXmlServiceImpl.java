package com.example.xmlmanagementapp.service;

import com.example.xmlmanagementapp.model.Statistics;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class GenerateStatisticsFromXmlServiceImpl implements GenerateStatisticsFromXmlService{

    @Override
    public Statistics generateStatistics(String xmlFilePath) throws IOException, XMLStreamException {
        Statistics statistics = new Statistics();
        
        XMLInputFactory factory = XMLInputFactory.newInstance();
        FileInputStream inputStream = new FileInputStream(xmlFilePath);
        XMLEventReader eventReader = factory.createXMLEventReader(inputStream);
        
        String currentElement = "";
        
        while (eventReader.hasNext()) {
            XMLEvent event = eventReader.nextEvent();
            
            if (event.isStartElement()){
                StartElement startElement = event.asStartElement();
                currentElement = startElement.getName().getLocalPart();
                
                if ("paragraph".equals(currentElement)) {
                    statistics.incrementParagraphs();
                }
                
            }
            
            if (event.isCharacters() && "line".equals(currentElement)) {
                Characters characters = event.asCharacters();
                String content = characters.getData().trim();
                
                if (!content.isEmpty()) {
                    String[] words = content.split("\\s+");
                    statistics.addWords(words.length);
                    statistics.addDistinctWords(content); 
                    statistics.incrementLines();
                }
            }
        }
        
        statistics.setCreationDateTime(LocalDateTime.now());
        statistics.setAuthor("Unknown");
        statistics.setApplicationClassName(this.getClass().getName());
        
        eventReader.close();
        inputStream.close();
        
        return statistics;
        
    }
    
}
