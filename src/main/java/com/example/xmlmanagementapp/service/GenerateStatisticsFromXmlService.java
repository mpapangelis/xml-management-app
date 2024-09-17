package com.example.xmlmanagementapp.service;

import com.example.xmlmanagementapp.model.Statistics;
import java.io.IOException;
import javax.xml.stream.XMLStreamException;


public interface GenerateStatisticsFromXmlService {
    Statistics generateStatistics(String xmlFilePath) throws IOException, XMLStreamException;
}
