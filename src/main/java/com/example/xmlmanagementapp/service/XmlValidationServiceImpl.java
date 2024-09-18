package com.example.xmlmanagementapp.service;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import java.io.File;
import javax.xml.XMLConstants;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import org.xml.sax.SAXException;


public class XmlValidationServiceImpl implements XmlValidationService{

    /**
     * This method reads an XML file and validates that its structure and content
     * is conformed on the provided XSD schema file.
     * 
     * @param xmlFilePath The file path to the XML document to be validated.
     * @param xsdFilePath The file path of the XSD schema that works as the validator.
     * @param xmlClass The class type of the root element in the XML file.
     * @return Returns true if the XML is valid and false if its not.
     */
    @Override
    public boolean validateXml(String xmlFilePath, String xsdFilePath, Class<?> xmlClass) {
        System.out.println("Starting XML validation...");
        boolean isValid = false;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(xmlClass);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = schemaFactory.newSchema(new File(xsdFilePath));
            
            unmarshaller.setSchema(schema);
            
            File xmlFile = new File(xmlFilePath);
            unmarshaller.unmarshal(xmlFile);
            
            System.out.println("XML is valid.");
            isValid = true;
        } catch (JAXBException | SAXException e) {
            System.out.println("XML is not valid: " + e.getMessage());
        }
        System.out.println("XML validation completed!");
        return isValid;
    }
    
}
