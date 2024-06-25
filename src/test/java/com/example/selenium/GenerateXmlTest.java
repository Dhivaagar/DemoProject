package com.example.selenium;

import org.testng.annotations.Test;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class GenerateXmlTest {

    @Test
    public static void generateXML() {

        try {
            // Create DocumentBuilderFactory and DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Create Document
            Document document = builder.newDocument();

            // Create Document with DOCTYPE
            DOMImplementation domImpl = builder.getDOMImplementation();
            DocumentType doctype = domImpl.createDocumentType("suite",
                    null, "https://testng.org/testng-1.0.dtd");
            document.appendChild(doctype);

            // Create root element
            Element suite = document.getDocumentElement();
            suite.setAttribute("name", "AnalyzePageTooltipMonthIntervalTest");

            // Create test element
            Element test = document.createElement("test");
            test.setAttribute("thread-count", "1");
            test.setAttribute("name", "AnalyzePageTooltipMonthIntervalTest");
            suite.appendChild(test);

//            // Create groups element
//            Element groups = document.createElement("groups");
//            test.appendChild(groups);
//
//            // Create run element
//            Element run = document.createElement("run");
//            groups.appendChild(run);
//
//            // Create include element
//            Element include = document.createElement("include");
//            include.setAttribute("name", "reg");
//            run.appendChild(include);

            // Create classes element
            Element classes = document.createElement("classes");
            test.appendChild(classes);

            // Create class element
            Element classElement = document.createElement("class");
            classElement.setAttribute("name", "com.example.selenium.ExampleTest");
            classes.appendChild(classElement);

//            // Create methods element
//            Element methods = document.createElement("methods");
//            classElement.appendChild(methods);
//
//            // Create include element for methods
//            Element includeMethod = document.createElement("include");
//            includeMethod.setAttribute("name", "testAnalyzePageTooltipMonthInterval");
//            methods.appendChild(includeMethod);

            // Write Document to XML file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult("testng.xml");
            transformer.transform(source, result);

            System.out.println("TestNG XML file created successfully.");
        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }
}
