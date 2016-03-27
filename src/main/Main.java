package main;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Main {

	
	public static void gerarHeader(NodeList parametros) {
		for(int i = 0; i < parametros.getLength(); i++){
			Node node = parametros.item(i);
			if(node.getNodeType() == Node.ELEMENT_NODE){
				Element el = (Element)node;
				
				System.out.println("Name: " + el.getElementsByTagName("name").item(0).getTextContent());
				System.out.println("Value: " + el.getElementsByTagName("value").item(0).getTextContent());
				System.out.println("Size: " + el.getElementsByTagName("size").item(0).getTextContent());
				System.out.println("Class: " + el.getElementsByTagName("class").item(0).getTextContent());
				System.out.println("Decimal: " + el.getElementsByTagName("decimal").item(0).getTextContent());
				System.out.println("Property: " + el.getElementsByTagName("property").item(0).getTextContent());
				System.out.println("---------------------------------------------------------------------------");
			}
		}
	}
	
	public static void gerarHeader(NodeList parametros, StringBuilder sb) {
		for(int i = 0; i < parametros.getLength(); i++){
			Node node = parametros.item(i);
			if(node.getNodeType() == Node.ELEMENT_NODE){
				Element el = (Element)node;
				
				String nome = el.getElementsByTagName("name").item(0).getTextContent();
				String valor = el.getElementsByTagName("value").item(0).getTextContent();
				String tamanho = el.getElementsByTagName("size").item(0).getTextContent();
				String classe = el.getElementsByTagName("class").item(0).getTextContent();
				
				/*if(nome.equals("TAM-AREA-CTG")){
					sb.setLength(Integer.parseInt(valor));
				}*/
				
				if(classe.equals("Numeric")){
					sb.append(Main.completarEsquerda(valor, Integer.parseInt(tamanho), "0"));
				}
				else{
					sb.append(Main.completarDireita(valor, Integer.parseInt(tamanho), " "));
				}
			}
		}
	}
	
	public static void gerarParametros(NodeList params, int initIndex) {
		for(int i = initIndex; i < params.getLength(); i++){
			Node node = params.item(i);
			if(node.getNodeType() == Node.ELEMENT_NODE){
				Element el = (Element)node;
				
				if(el.getTagName().equals("vo")){
					System.out.println("VO: " + el.getTextContent());
				}
				
				else if(el.getTagName().equals("param")){
					System.out.println("Name: " + el.getElementsByTagName("name").item(0).getTextContent());
					System.out.println("Value: " + el.getElementsByTagName("value").item(0).getTextContent());
					System.out.println("Size: " + el.getElementsByTagName("size").item(0).getTextContent());
					System.out.println("Class: " + el.getElementsByTagName("class").item(0).getTextContent());
					System.out.println("Decimal: " + el.getElementsByTagName("decimal").item(0).getTextContent());
					System.out.println("Property: " + el.getElementsByTagName("property").item(0).getTextContent());
				}
				
				else if(el.getTagName().equals("loop")){
					System.out.println("repetitions: " + el.getElementsByTagName("repetitions").item(0).getTextContent());
					System.out.println("Name: " + el.getElementsByTagName("name").item(0).getTextContent());
					System.out.println("Size: " + el.getElementsByTagName("size").item(0).getTextContent());
					System.out.println("Property: " + el.getElementsByTagName("property").item(0).getTextContent());
					System.out.println("VO: " + el.getElementsByTagName("vo").item(0).getTextContent());
					System.out.println("---------------------------------------------------------------------------");
					System.out.println("---------------------------------------------------------------------------");
					Main.gerarParametros(el.getChildNodes(),10);
				}
				System.out.println("---------------------------------------------------------------------------");
			}
		}
	}
	
	
	public static void gerarParametros(NodeList params, int initIndex, StringBuilder sb, Object vo) throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		for(int i = initIndex; i < params.getLength(); i++){
			Node node = params.item(i);
			if(node.getNodeType() == Node.ELEMENT_NODE){
				Element el = (Element)node;
				
				if(el.getTagName().equals("vo")){
					System.out.println("VO: " + el.getTextContent());
				}
				
				else if(el.getTagName().equals("param")){
					
					String tamanho = el.getElementsByTagName("size").item(0).getTextContent();
					String classe = el.getElementsByTagName("class").item(0).getTextContent();
					String prop = el.getElementsByTagName("property").item(0).getTextContent();
					String decimal = el.getElementsByTagName("decimal").item(0).getTextContent();
					
					prop = "get" + prop.substring(0, 1).toUpperCase() + prop.substring(1);
					
					if(classe.equals("Numeric")){
						if(!decimal.equals("0")){
							BigDecimal retorno = (BigDecimal)invocarMetodo(prop,vo);
							if(retorno == null)
								retorno = BigDecimal.ZERO;
							String valorBD = retorno.setScale(Integer.valueOf(decimal)).toString().replace(".", "");
							sb.append(Main.completarEsquerda(valorBD,Integer.parseInt(tamanho), "0"));
						}
						else{
							String retorno = (String)invocarMetodo(prop,vo);
							sb.append(Main.completarEsquerda(retorno, Integer.parseInt(tamanho), "0"));
						}
					}
					else{
						String retorno = (String)invocarMetodo(prop,vo);
						sb.append(Main.completarDireita(retorno, Integer.parseInt(tamanho), " "));
					}
				}
				
				else if(el.getTagName().equals("loop")){
					
					Integer repetitions = Integer.parseInt(el.getElementsByTagName("repetitions").item(0).getTextContent());
					Integer tamanho = Integer.parseInt(el.getElementsByTagName("size").item(0).getTextContent());
					String classe = el.getElementsByTagName("class").item(0).getTextContent();
					String prop = el.getElementsByTagName("property").item(0).getTextContent();
					String voLoop = el.getElementsByTagName("vo").item(0).getTextContent();
					
					prop = "get" + prop.substring(0, 1).toUpperCase() + prop.substring(1);
					List lista = (List)invocarMetodo(prop,vo);
					
					if(lista == null)
						lista = (ArrayList)Main.instanciaObjeto(ArrayList.class.getName());
						
					for(int j = 0; j < repetitions; j ++){
						Object obj;
						if(j < lista.size()){
							obj = lista.get(j);
						}	
						else{
							obj = Main.instanciaObjeto(voLoop);	
						}
						Main.gerarParametros(el.getChildNodes(),10,sb,obj);
					}
				}
			}
		}
	}
	
	
	public static Object invocarMetodo(String metodo, Object obj) throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Method  method = obj.getClass().getMethod(metodo);
		return method.invoke(obj);
	}
	
	public static Object instanciaObjeto(String className) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException{
		return Class.forName(className).getConstructor().newInstance();
	}
	
	
	
	
	public static String completarEsquerda(String el, int qtd, String valor){
		if(el == null || el.equals("null"))
			el = "";
		StringBuilder sb = new StringBuilder();
		for(int i = el.length(); i < qtd; i++){
			sb.append(valor);
		}
		return sb.append(el).toString();
	}
	
	public static String completarDireita(String el, int qtd, String valor){
		if(el == null || el.equals("null"))
			el = "";
		StringBuilder sb = new StringBuilder();
		sb.append(el);
		for(int i = el.length(); i < qtd; i++){
			sb.append(valor);
		}
		return sb.toString();
	}
	
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		
		
		Pinctgf7VO pinctgf7vo = new Pinctgf7VO();
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(new File("D:/Programming/Java/CTGParser/src/"+pinctgf7vo.getXMLName()+".xml"));
		doc.getDocumentElement().normalize();	
		
		Node nodeHeader = doc.getElementsByTagName("header").item(0);
		StringBuilder sb = new StringBuilder();
		
		Pinctgf7VO vo = new Pinctgf7VO();
		
		Main.gerarHeader(nodeHeader.getChildNodes(), sb);
		
		Node nodeParams = doc.getElementsByTagName("parameters").item(0);
		NodeList params = nodeParams.getChildNodes();
		Main.gerarParametros(params, 0, sb, pinctgf7vo);
		
		System.out.println(sb.toString());
		
		
		
		
		//------------------------------------------------------------------------------------------------
		/*DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(new File("D:/Programming/Java/CTGParser/src/PINCTGF7.xml"));
		
		
		NodeList parametros = nodeHeader.getChildNodes();
		
		Main.gerarHeader(parametros);
		
		
		Node nodeParams = doc.getElementsByTagName("parameters").item(0);
		NodeList params = nodeParams.getChildNodes();
		
		Main.gerarParametros(params,0);*/
		//------------------------------------------------------------------------------------------------
		
		

	}

	

}
