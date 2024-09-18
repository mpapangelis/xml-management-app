package com.example.xmlmanagementapp;


import com.example.xmlmanagementapp.model.Book;
import com.example.xmlmanagementapp.model.Chapter;
import com.example.xmlmanagementapp.model.Statistics;
import com.example.xmlmanagementapp.service.GenerateStatisticsFromXmlService;
import com.example.xmlmanagementapp.service.GenerateStatisticsFromXmlServiceImpl;
import com.example.xmlmanagementapp.service.TxtToXmlService;
import com.example.xmlmanagementapp.service.TxtToXmlServiceImpl;
import com.example.xmlmanagementapp.service.XmlChapterReaderService;
import com.example.xmlmanagementapp.service.XmlChapterReaderServiceImpl;
import com.example.xmlmanagementapp.service.XmlChapterWriterService;
import com.example.xmlmanagementapp.service.XmlChapterWriterServiceImpl;
import com.example.xmlmanagementapp.service.XmlValidationService;
import com.example.xmlmanagementapp.service.XmlValidationServiceImpl;
import com.example.xmlmanagementapp.service.XsdGeneratorService;
import com.example.xmlmanagementapp.service.XsdGeneratorServiceImpl;
import jakarta.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.xml.stream.XMLStreamException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class XmlManagementApp {

    public static void main(String[] args) {
        
        
        TxtToXmlService txtToXmlService = new TxtToXmlServiceImpl("Marios P");
        XmlChapterReaderService xmlChapterReaderService = new XmlChapterReaderServiceImpl();
        XmlChapterWriterService xmlChapterWriterService = new XmlChapterWriterServiceImpl();
        XsdGeneratorService xsdGeneratorService = new XsdGeneratorServiceImpl();
        XmlValidationService xmlValidationService = new XmlValidationServiceImpl();
        GenerateStatisticsFromXmlService statisticsFromXmlService = new GenerateStatisticsFromXmlServiceImpl();
        
// -------------------- Example 1: Text to XML --------------------
//        try {
//            String inputFilePath = "src/main/resources/sample-lorem-ipsum-text-file.txt";
//            String outputFilePath = "src/main/resources/xml/output.xml";
//            txtToXmlService.generateXmlFromText(inputFilePath, outputFilePath);
//        } catch(Exception e) {
//            log.error("Error occurred while generating XML from text: {}", e.getMessage());
//        }

// -------------------- Example 2: Read and Write Selected Chapters --------------------
//        List<String> chapterIdsToRead = Arrays.asList("chapter-1", "chapter-2", "chapter-8");
//        
//        try {
//            String inputFilePath = "src/main/resources/xml/output.xml";
//            List<Chapter> chapters = xmlChapterReaderService.readChapters(inputFilePath, chapterIdsToRead);
//            
//            String outputFilePath = "src/main/resources/xml/selected_chapters.xml";
//            xmlChapterWriterService.writeChaptersToXml(chapters, outputFilePath);
//            
//        } catch (XMLStreamException | IOException e) {
//            log.error("Error occurred while reading or writing chapters: {}", e.getMessage());
//        }
// -------------------- Example 3: Generate XSD Schema --------------------
//        String xsdFilePath = "src/main/resources/xsd/schema.xsd";
//        try {
//            xsdGeneratorService.generateXsd(xsdFilePath);
//        } catch (IOException  e) {
//            log.error("Error occurred while generating XSD: {}", e.getMessage());
//        }

// -------------------- Example 4: Validate XML --------------------

//        String xmlFilePath = "src/main/resources/xml/output.xml";
//        String xsdFilePath = "src/main/resources/xsd/schema.xsd";
//        
//        xmlValidationService.validateXml(xmlFilePath, xsdFilePath, Book.class);
        
// -------------------- Example 5: Generate Statistics --------------------

//        String xmlFilePath = "src/main/resources/xml/selected_chapters.xml";
//        
//        try {
//            statisticsFromXmlService.generateStatistics(xmlFilePath);
//       } catch (IOException | XMLStreamException e) {
//            log.error("Error occurred while generating statistics: {}", e.getMessage());
//        }
        
    }
    
    
}
