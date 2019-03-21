/*
package project;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class SAXHandler extends DefaultHandler {
    void readDataFromXML(String inputFile) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        parser.parse(new File(inputFile), this);
    }

    @Override
    public void startDocument() throws SAXException {
//        super.startDocument();
        System.out.println("Start Document");
    }

    @Override
    public void endDocument() throws SAXException {
//        super.endDocument();
        System.out.println("End Document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
//        super.startElement(uri, localName, qName, attributes);
        System.out.println("Start Element:" + qName);
        if (qName == "message"){
//            Message message = new Message();
////            message.setId(qName);
//            message.getId();
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
//        super.endElement(uri, localName, qName);
        System.out.println("End Element:" + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
//        super.characters(ch, start, length);
        System.out.println("Character:" + start + length);
    }
}
*/
