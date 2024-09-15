package com.example.xmlmanagementapp;


import com.example.xmlmanagementapp.model.Chapter;
import com.example.xmlmanagementapp.service.TxtToXmlService;
import com.example.xmlmanagementapp.service.TxtToXmlServiceImpl;
import com.example.xmlmanagementapp.service.XmlChapterReaderService;
import com.example.xmlmanagementapp.service.XmlChapterReaderServiceImpl;
import com.example.xmlmanagementapp.service.XmlChapterWriterService;
import com.example.xmlmanagementapp.service.XmlChapterWriterServiceImpl;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.xml.stream.XMLStreamException;


public class XmlManagementApp {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        TxtToXmlService txtToXmlService = new TxtToXmlServiceImpl();
        XmlChapterReaderService xmlChapterReaderService = new XmlChapterReaderServiceImpl();
        XmlChapterWriterService xmlChapterWriterService = new XmlChapterWriterServiceImpl();
        
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
        List<String> chapterIdsToRead = Arrays.asList("chapter-1", "chapter-4", "chapter-5");
        
        try {
            String inputFilePath = "src/main/resources/xml/output.xml";
            List<Chapter> chapters = xmlChapterReaderService.readChapters(inputFilePath, chapterIdsToRead);
            
            String outputFilePath = "src/main/resources/xml/selected_chapters.xml";
            xmlChapterWriterService.writeChaptersToXml(chapters, outputFilePath);
            
        } catch (XMLStreamException | IOException e) {
                System.out.println(e.getMessage());
        }
        
        
    }
    
    
}
