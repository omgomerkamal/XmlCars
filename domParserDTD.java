package icxml;

import java.io.IOException;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class domParserDTD {
	
	public void validateXMLFileFromDTD() throws ParserConfigurationException, IOException, SAXException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setValidating(true);
		factory.setNamespaceAware(true);
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		InputStream inputStream = classLoader.getResourceAsStream("Cars.xml");
		DocumentBuilder builder = factory.newDocumentBuilder();
		builder.setErrorHandler(new ErrorHandler() {
			public void warning(SAXParseException e) throws SAXException {
				System.out.println("WARNING : " + e.getMessage()); 
			}

			public void error(SAXParseException e) throws SAXException {
				System.out.println("ERROR : " + e.getMessage());
				throw e;
			}

			public void fatalError(SAXParseException e) throws SAXException {
				System.out.println("FATAL : " + e.getMessage());
				throw e;
			}
		});
		builder.parse(inputStream);
		System.out.println("Cars.xml is valid");
	}

	public static void main(String[] args) {
		domParserDTD domParserDTD = new domParserDTD();
		try {
			domParserDTD.validateXMLFileFromDTD();
		} catch (ParserConfigurationException | IOException | SAXException e) {
			e.printStackTrace();
		}
	}

}
