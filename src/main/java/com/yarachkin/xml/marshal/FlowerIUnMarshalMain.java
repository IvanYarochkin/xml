package com.yarachkin.xml.marshal;

import com.yarachkin.xml.entity.Flowers;
import com.yarachkin.xml.exception.XmlParserException;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;

public class FlowerIUnMarshalMain {

    public Flowers unMarshal(String xmlPath, String xsdPath) throws XmlParserException {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Flowers.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            String schemaName = xsdPath;
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            File schemaLocation = new File(schemaName);
            Schema schema = factory.newSchema(schemaLocation);
            unmarshaller.setSchema(schema);
            Flowers flowers = (Flowers) unmarshaller.unmarshal(new File(xmlPath));
            return flowers;
        } catch (JAXBException | SAXException e) {
            throw new XmlParserException(e);
        }
    }
}
