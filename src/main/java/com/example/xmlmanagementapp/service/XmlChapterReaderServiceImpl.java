package com.example.xmlmanagementapp.service;

import com.example.xmlmanagementapp.model.Chapter;
import com.example.xmlmanagementapp.model.Line;
import com.example.xmlmanagementapp.model.Paragraph;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;


public class XmlChapterReaderServiceImpl implements XmlChapterReaderService{

    @Override
    public List<Chapter> readChapters(String xmlFilePath, List<String> chapterIds) throws XMLStreamException, IOException {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        FileInputStream inputStream = new FileInputStream(xmlFilePath);
        XMLEventReader eventReader = factory.createXMLEventReader(inputStream);
        
        List<Chapter> chapters = new ArrayList<>();
        Chapter currentChapter = null;
        Paragraph currentParagraph = null;
        List<Line> lines = null;
        
        String currentElement = "";
        String chapterId = "";
        boolean isChosenChapter = false;
        
        while (eventReader.hasNext()) {
            XMLEvent event = eventReader.nextEvent();
            
            if (event.isStartElement()) {
                StartElement startElement = event.asStartElement();
                currentElement = startElement.getName().getLocalPart();
                
                if ("chapter".equals(currentElement)){
                    chapterId = startElement.getAttributeByName(javax.xml.namespace.QName.valueOf("id")).getValue();
                    
                    if (chapterIds.contains(chapterId)) {
                        currentChapter = new Chapter();
                        currentChapter.setId(chapterId);
                        currentChapter.setParagraphs(new ArrayList<>());
                        isChosenChapter = true;
                    } else {
                        isChosenChapter = false;
                    }
                }
                
                if ("paragraph".equals(currentElement) && isChosenChapter) {
                    currentParagraph = new Paragraph();
                    currentParagraph.setId(startElement.getAttributeByName(javax.xml.namespace.QName.valueOf("id")).getValue());
                    lines = new ArrayList<>();
                    currentParagraph.setLines(lines);
                }
            }
            
            if (event.isCharacters() && isChosenChapter && currentParagraph != null && "line".equals(currentElement)) {
                Characters characters = event.asCharacters();
                String content = characters.getData().trim();
                
                if (!content.isEmpty()) {
                    Line line = new Line(content);
                    lines.add(line);
                }
            }
            
            if (event.isEndElement()) {
                String endElement = event.asEndElement().getName().getLocalPart();
                
                if ("paragraph".equals(endElement) && isChosenChapter) {
                    currentChapter.getParagraphs().add(currentParagraph);
                }
                
                if ("chapter".equals(endElement) && isChosenChapter) {
                    chapters.add(currentChapter);
                    isChosenChapter = false;
                }
            }
        }
        
        eventReader.close();
        inputStream.close();
        
        return chapters;
    }
    
}
