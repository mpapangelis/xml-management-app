package com.example.xmlmanagementapp;


import com.example.xmlmanagementapp.model.Book;
import com.example.xmlmanagementapp.model.Chapter;
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
        System.out.println("Hello World!");
        
        TxtToXmlService txtToXmlService = new TxtToXmlServiceImpl("Marios P");
        XmlChapterReaderService xmlChapterReaderService = new XmlChapterReaderServiceImpl();
        XmlChapterWriterService xmlChapterWriterService = new XmlChapterWriterServiceImpl();
        XsdGeneratorService xsdGeneratorService = new XsdGeneratorServiceImpl();
        XmlValidationService xmlValidationService = new XmlValidationServiceImpl();
        
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
//        List<String> chapterIdsToRead = Arrays.asList("chapter-1", "chapter-3", "chapter-8");
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
        String xsdFilePath = "src/main/resources/xsd/schema.xsd";
        try {
            xsdGeneratorService.generateXsd(xsdFilePath);
            System.out.println("XSD generated successfully at: " + xsdFilePath);
        } catch (IOException  e) {
            System.out.println(e.getMessage());
        }

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
        
        
    }
    
    
}
