package com.example.xmlmanagementapp.service;

import com.example.xmlmanagementapp.model.Chapter;
import java.io.IOException;
import java.util.List;
import javax.xml.stream.XMLStreamException;


public interface XmlChapterReaderService {
    List<Chapter> readChapters(String xmlFilePath, List<String> chapterIds) throws XMLStreamException, IOException;
}
