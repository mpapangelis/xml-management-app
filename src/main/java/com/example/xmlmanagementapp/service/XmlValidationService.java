package com.example.xmlmanagementapp.service;


public interface XmlValidationService {
    boolean validateXml(String xmlFilePath, String xsdFilePath, Class<?> xmlClass);
}
