package com.example.xmlmanagementapp;


import com.example.xmlmanagementapp.service.TxtToXmlService;
import com.example.xmlmanagementapp.service.TxtToXmlServiceImpl;


public class XmlManagementApp {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        TxtToXmlService txtToXmlService = new TxtToXmlServiceImpl();
        
        try {
            String inputFilePath = "src/main/resources/sample-lorem-ipsum-text-file.txt";
            String outputFilePath = "src/main/resources/xml/output.xml";
            txtToXmlService.generateXmlFromText(inputFilePath, outputFilePath);
            
            System.out.println("Process completed!");
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        
        
    }
    
    
}
