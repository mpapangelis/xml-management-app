package com.example.xmlmanagementapp.service;

import com.example.xmlmanagementapp.model.Statistics;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

public class TxtToXmlServiceImpl implements TxtToXmlService {
    
    private final Statistics statistics;
    
    public TxtToXmlServiceImpl() {
        this.statistics = new Statistics();
    }

    @Override
    public void generateXmlFromText(String inputFilePath, String outputFilePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath));
                FileWriter fileWriter = new FileWriter(outputFilePath)) {
            
            XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
            XMLStreamWriter writer = outputFactory.createXMLStreamWriter(fileWriter);
            
            writer.writeStartDocument("1.0");
            writer.writeCharacters("\n");
            writer.writeStartElement("book");
            writer.writeCharacters("\n");
            
            String line;
            int lineCount = 0;
            int chapterCount = 1;
            int paragraphCount = 1;
            
            writer.writeCharacters("\t");
            writer.writeStartElement("chapter");
            writer.writeAttribute("id", "chapter-" + chapterCount);
            writer.writeCharacters("\n");
            
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue; //skip blank lines
                }
                
                statistics.incrementParagraphs();
                
                
                writer.writeCharacters("\t\t");
                writer.writeStartElement("paragraph");
                writer.writeAttribute("id", "paragraph-" + paragraphCount);
                writer.writeCharacters("\n");
                
                String[] sentences = line.split("\\.");
                for (String sentence : sentences) {
                    if (!sentence.trim().isEmpty()) {
                        statistics.incrementLines();
                        lineCount++;
                        
                        statistics.addWords(sentence.split("\\s+").length);
                        statistics.addDistinctWords(sentence);
                        
                        writer.writeCharacters("\t\t\t");
                        writer.writeStartElement("line");
                        writer.writeCharacters(sentence.trim() + ".");
                        writer.writeEndElement(); // </line>
                        writer.writeCharacters("\n");
                    }
                }
                
                writer.writeCharacters("\t\t");
                writer.writeEndElement(); // </paragraph>
                writer.writeCharacters("\n");
                paragraphCount++;
                
                
                if (lineCount % 20 == 0) {
                    writer.writeCharacters("\t");
                    writer.writeEndElement(); //</chapter>
                    writer.writeCharacters("\n");
                    
                    chapterCount++;
                    paragraphCount = 1;
                    writer.writeCharacters("\t");
                    writer.writeStartElement("chapter");
                    writer.writeAttribute("id", "chapter-" + chapterCount);
                    writer.writeCharacters("\n");
                }
            }
            
            writer.writeCharacters("\t");
            writer.writeEndElement(); //</chapter>
            writer.writeCharacters("\n");
            
            writer.writeCharacters("\t");
            writer.writeStartElement("statistics");
            writer.writeCharacters("\n");
            
            writer.writeCharacters("\t\t");
            writer.writeStartElement("totalParagraphs");
            writer.writeCharacters(String.valueOf(statistics.getTotalParagraphs()));
            writer.writeEndElement();
            writer.writeCharacters("\n");
            
            writer.writeCharacters("\t\t");
            writer.writeStartElement("totalLines");
            writer.writeCharacters(String.valueOf(statistics.getTotalLines()));
            writer.writeEndElement();
            writer.writeCharacters("\n");
            
            writer.writeCharacters("\t\t");
            writer.writeStartElement("totalWords");
            writer.writeCharacters(String.valueOf(statistics.getTotalWords()));
            writer.writeEndElement();
            writer.writeCharacters("\n");
            
            writer.writeCharacters("\t\t");
            writer.writeStartElement("distinctWords");
            writer.writeCharacters(String.valueOf(statistics.getDistinctWordsCount()));
            writer.writeEndElement();
            writer.writeCharacters("\n");
            
            writer.writeCharacters("\t\t");
            writer.writeStartElement("creationDateTime");
            writer.writeCharacters(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
            writer.writeEndElement();
            writer.writeCharacters("\n");
            
            writer.writeCharacters("\t\t");
            writer.writeStartElement("author");
            writer.writeCharacters("Author_Name");
            writer.writeEndElement();
            writer.writeCharacters("\n");
            
            writer.writeCharacters("\t\t");
            writer.writeStartElement("applicationClass");
            writer.writeCharacters(this.getClass().getName());
            writer.writeEndElement();
            writer.writeCharacters("\n");
            
            writer.writeCharacters("\t");
            writer.writeEndElement();
            writer.writeCharacters("\n");
            
            writer.writeEndElement(); //</book>
            writer.writeCharacters("\n");
            writer.writeEndDocument();
            
            writer.flush();
            writer.close();
        } catch (XMLStreamException | IOException e) {
            System.out.println(e.getMessage());
        }
        
        
        
    }
    
}
