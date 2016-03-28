package main;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class XMLUtil {

	public static Document abrirXml(String caminhoArquivo){
		Document doc = null;
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder;
			builder = factory.newDocumentBuilder();
			doc = builder.parse(new File(caminhoArquivo));
			doc.getDocumentElement().normalize();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return doc;
		
	}
	
	public static Node getElementByTag(Document doc, String tag){
		return doc.getElementsByTagName(tag).item(0);
	}
	
	public static String getElementContentByTag(Element el, String tag){
		return el.getElementsByTagName(tag).item(0).getTextContent();
	}
	
}
