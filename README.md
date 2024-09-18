## XML Management Application

This project is a Java application that converts text documents into XML format, generates statistics from XML files, validates XML against an XSD schema, and offers other XML management functionality such as reading, writing, and extracting specific chapters from XML files.

## Features
- **Convert text files to XML format** with a structure of book, chapters, paragraphs, and lines.
- **Generate statistics from an XML file**, including:
  - Total number of paragraphs
  - Total number of lines
  - Total number of words
  - Number of distinct words
  - Date/time of document creation
  - Application class name
- **Generate an XSD schema** based on the application's model classes.
- **Validate XML files against an XSD schema.**
- **Extract selected chapters from an XML file** into Java objects.
- **Write selected chapters** (stored as Java objects) into a new XML file.


## Technologies Used
- **Java SE 21**
- **Jakarta XML Binding (JAXB)**
- **STAX (Streaming API for XML)**
- **SLF4J** for logging
- **Maven** for project dependency management

## Project Structure

- **src/main/java/com/example/xmlmanagementapp** – Main source folder
  - **model** – Contains the model classes representing the XML structure (Book, Chapter, Paragraph, Line, Statistics).
  - **service** – Contains the service classes implementing various functionalities (e.g., converting text to XML, generating XSD, reading/writing XML).
  - **util** – Contains utility classes such as `LocalDateTimeAdapter` for handling date/time in XML.
  
- **src/main/resources** – Contains resource files like the sample text file, generated XML files, and the XSD schema.


## Steps to Run

- **Clone the repository**  
   Download the project from GitHub by running the following command:
   ```bash
   git clone https://github.com/mpapangelis/xml-management-app.git
- **Navigate to the Project Directory** 
   ```bash
   cd xml-management-app
- **Build the project using Maven**
    ```bash
   mvn clean install
- **Run the Application**
    ```bash
   mvn exec:java
