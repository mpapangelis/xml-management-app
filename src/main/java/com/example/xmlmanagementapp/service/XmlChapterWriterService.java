package com.example.xmlmanagementapp.service;

import com.example.xmlmanagementapp.model.Chapter;
import java.io.IOException;
import java.util.List;
import javax.xml.stream.XMLStreamException;


public interface XmlChapterWriterService {
    void writeChaptersToXml(List<Chapter> chapters, String outputFilePath) throws XMLStreamException, IOException;
}
