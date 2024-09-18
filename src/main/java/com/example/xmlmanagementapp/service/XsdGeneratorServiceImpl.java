package com.example.xmlmanagementapp.service;

import com.example.xmlmanagementapp.model.Book;
import com.example.xmlmanagementapp.model.Chapter;
import com.example.xmlmanagementapp.model.Line;
import com.example.xmlmanagementapp.model.Paragraph;
import com.example.xmlmanagementapp.model.Statistics;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.SchemaOutputResolver;
import java.io.File;
import java.io.IOException;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class XsdGeneratorServiceImpl implements XsdGeneratorService{

    /**
     * This method generates an XSD file based on the classes provided on the JAXBContext
     * 
     * @param outputFilePath The file path where the generated XSD will be saved
     * @throws IOException 
     */
    @Override
    public void generateXsd(String outputFilePath) throws IOException {
        log.info("Starting XSD generation at: {}", outputFilePath);
        try {
            JAXBContext context = JAXBContext.newInstance(Book.class, Chapter.class, Paragraph.class, Line.class, Statistics.class);
            
            context.generateSchema(new MySchemaOutputResolver(outputFilePath));
            log.info("XSD generation completed successfully at: {}", outputFilePath);
        } catch (JAXBException e) {
            log.error("Error during XSD generation: {}", e.getMessage());
        }
    }
    
    static class MySchemaOutputResolver extends SchemaOutputResolver {
        private final String xsdFileName;
        
        public MySchemaOutputResolver(String xsdFileName) {
            this.xsdFileName = xsdFileName;
        }

        @Override
        public Result createOutput(String namespaceUri, String suggestedFileName) throws IOException {
            
            File file = new File(xsdFileName);
            
            StreamResult result = new StreamResult(file);
            result.setSystemId(file.toURI().toString());
            
            return result;
        }
        
        
    }
}
