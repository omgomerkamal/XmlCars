package icxml;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class domParserSchema {


	private void validateXmlFileFromSchema() {
		SchemaFactory factory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
		URL schemaFileUrl = ClassLoader.getSystemClassLoader().getResource("Cars.xsd");
		File schemaFile = new File(schemaFileUrl.getFile());
		URL xmlFileUrl = ClassLoader.getSystemClassLoader().getResource("Cars.xml");
		File xmlFile = new File(xmlFileUrl.getFile());
		try {
			Schema schema = factory.newSchema(schemaFile);
			Validator validator = schema.newValidator();
			Source source = new StreamSource(xmlFile);
			validator.validate(source);
			System.out.println(xmlFile.getName() + " is valid.");
		} 
		catch (SAXException | IOException ex) {
			System.out.println(xmlFile.getName() + " is not valid.");
			System.out.println(ex.getMessage());
		}
	}
	
	public static void main(String[] args) {
		domParserSchema domParserSchema = new domParserSchema();
		domParserSchema.validateXmlFileFromSchema();
	}
}

