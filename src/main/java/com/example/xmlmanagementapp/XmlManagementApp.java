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


public class XmlManagementApp {

    public static void main(String[] args) {
        
        
        TxtToXmlService txtToXmlService = new TxtToXmlServiceImpl("Marios P");
        XmlChapterReaderService xmlChapterReaderService = new XmlChapterReaderServiceImpl();
        XmlChapterWriterService xmlChapterWriterService = new XmlChapterWriterServiceImpl();
        XsdGeneratorService xsdGeneratorService = new XsdGeneratorServiceImpl();
        XmlValidationService xmlValidationService = new XmlValidationServiceImpl();
        GenerateStatisticsFromXmlService statisticsFromXmlService = new GenerateStatisticsFromXmlServiceImpl();
        
//        try {
//            String inputFilePath = "src/main/resources/sample-lorem-ipsum-text-file.txt";
//            String outputFilePath = "src/main/resources/xml/output.xml";
//            txtToXmlService.generateXmlFromText(inputFilePath, outputFilePath);
//            
//            System.out.println("Process completed!");
//        } catch(Exception e) {
//            System.out.println(e.getMessage());
//        }
// -------------------------------
//        List<String> chapterIdsToRead = Arrays.asList("chapter-1", "chapter-4", "chapter-8");
//        
//        try {
//            String inputFilePath = "src/main/resources/xml/output.xml";
//            List<Chapter> chapters = xmlChapterReaderService.readChapters(inputFilePath, chapterIdsToRead);
//            
//            String outputFilePath = "src/main/resources/xml/selected_chapters.xml";
//            xmlChapterWriterService.writeChaptersToXml(chapters, outputFilePath);
//            
//        } catch (XMLStreamException | IOException e) {
//                System.out.println(e.getMessage());
//        }
// ------------------------------------------------
//        String xsdFilePath = "src/main/resources/xsd/schema.xsd";
//        try {
//            xsdGeneratorService.generateXsd(xsdFilePath);
//            System.out.println("XSD generated successfully at: " + xsdFilePath);
//        } catch (IOException  e) {
//            System.out.println(e.getMessage());
//        }

// --------------------------------------------------

//        String xmlFilePath = "src/main/resources/xml/output.xml";
//        String xsdFilePath = "src/main/resources/xsd/schema.xsd";
//        
//        boolean isValid = xmlValidationService.validateXml(xmlFilePath, xsdFilePath, Book.class);
//        
//        if (isValid) {
//            System.out.println("The xml is valid!");
//        } else {
//            System.out.println("The xml is invalid!");
//        }
// --------------------------------------------------

//        String xmlFilePath = "src/main/resources/xml/selected_chapters.xml";
//        
//        try {
//            Statistics statistics = statisticsFromXmlService.generateStatistics(xmlFilePath);
//            
//            System.out.println("Total Paragraphs: " + statistics.getTotalParagraphs());
//            System.out.println("Total Lines: " + statistics.getTotalLines());
//            System.out.println("Total Words: " + statistics.getTotalWords());
//            System.out.println("Distinct Words: " + statistics.getDistinctWordsCount());
//            System.out.println("Creation DateTime: " + statistics.getCreationDateTime());
//            System.out.println("Author: " + statistics.getAuthor());
//            System.out.println("Application Class Name: " + statistics.getApplicationClassName());
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
        
    }
    
    
}
