package com.example.xmlmanagementapp.service;

import com.example.xmlmanagementapp.model.Chapter;
import com.example.xmlmanagementapp.model.Line;
import com.example.xmlmanagementapp.model.Paragraph;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class XmlChapterWriterServiceImpl implements XmlChapterWriterService{

    /**
     * This method writes a list of chapters to an XML file.
     * 
     * It uses STAX to generate an XML document from the provided list of Chapters.
     * Each chapter written also has all the associated paragraphs and lines contained on it.
     * The XML result has a root element fragment containing all the chapters.
     * 
     * @param chapters The list of chapter objects to be written on the XML
     * @param outputFilePath The file path where the generated XML will be saved.
     * @throws XMLStreamException
     * @throws IOException 
     */
    @Override
    public void writeChaptersToXml(List<Chapter> chapters, String outputFilePath) throws XMLStreamException, IOException {
        log.info("Starting to write chapters to XML file: {}", outputFilePath);
        XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
        try (FileWriter fileWriter = new FileWriter(outputFilePath)) {
            XMLStreamWriter writer = outputFactory.createXMLStreamWriter(fileWriter);
            
            writer.writeStartDocument("1.0");
            writer.writeCharacters("\n");
            writer.writeStartElement("fragment");
            writer.writeCharacters("\n");
            
            for (Chapter chapter : chapters) {
                writer.writeCharacters("\t");
                writer.writeStartElement("chapter");
                writer.writeAttribute("id", chapter.getId());
                writer.writeCharacters("\n");
                
                for (Paragraph paragraph : chapter.getParagraphs()) {
                    writer.writeCharacters("\t\t");
                    writer.writeStartElement("paragraph");
                    writer.writeAttribute("id", paragraph.getId());
                    writer.writeCharacters("\n");
                    
                    for (Line line : paragraph.getLines()) {
                        writer.writeCharacters("\t\t\t");
                        writer.writeStartElement("line");
                        writer.writeCharacters(line.getContent());
                        writer.writeEndElement();
                        writer.writeCharacters("\n");
                    }
                    
                    writer.writeCharacters("\t\t");
                    writer.writeEndElement();
                    writer.writeCharacters("\n");
                }
                
                writer.writeCharacters("\t");
                writer.writeEndElement();
                writer.writeCharacters("\n");
            }
            
            
            writer.writeEndElement();
            writer.writeCharacters("\n");
            writer.writeEndDocument();
            
            writer.flush();
            writer.close();
        }
        log.info("Successfully wrote chapters to XML file: {}", outputFilePath);
    }
    
}
