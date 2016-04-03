package main.parser;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import main.base.BaseCTG;
import main.interfaces.CTG;
import main.interfaces.XMLParser;
import main.util.ClassUtil;
import main.util.TextUtil;

public class XMLParserDOM implements XMLParser {

	private Document doc;
	private int posicao;
	private CTG instance;
	
	
	public XMLParserDOM(CTG ctg){
		reset(ctg);
	}
	
	
	public String classToCTG(CTG vo){
		StringBuilder sb = new StringBuilder();
		try{
			NodeList header = this.doc.getElementsByTagName("header").item(0).getChildNodes();
			NodeList params = this.doc.getElementsByTagName("parameters").item(0).getChildNodes();
			
			this.gerarParametrosCtg(header, 0, sb, vo);
			this.gerarParametrosCtg(params, 0, sb, vo);
			
			return sb.toString();
		}
		
		catch(Exception ex){
			return null;
		}
	}
	
	public Object ctgToClass(String ctg) throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException{
		this.posicao = 0;
		StringBuilder sb = new StringBuilder(ctg);
		
		NodeList header = this.doc.getElementsByTagName("header").item(0).getChildNodes();
		NodeList params = doc.getElementsByTagName("parameters").item(0).getChildNodes();
		
		this.gerarParametrosClasse(header, 0, sb, this.instance);
		this.gerarParametrosClasse(params, 0, sb, this.instance);
		
		return this.instance;
	}
	
	
	private void gerarParametrosCtg(NodeList params, int initIndex, StringBuilder sb, Object vo) throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		for(int i = initIndex; i < params.getLength(); i++){
			Node node = params.item(i);
			if(node.getNodeType() == Node.ELEMENT_NODE){
				Element el = (Element)node;
				
				if(el.getTagName().equals("param")){
					
					String tamanho = el.getElementsByTagName("size").item(0).getTextContent();
					String classe = el.getElementsByTagName("class").item(0).getTextContent();
					String prop = el.getElementsByTagName("property").item(0).getTextContent();
					String decimal = el.getElementsByTagName("decimal").item(0).getTextContent();
					
					//montando o nome do método GET
					prop = "get" + prop.substring(0, 1).toUpperCase() + prop.substring(1);
					
					
					if(classe.equals("Numeric")){
						if(!decimal.equals("0")){
							BigDecimal retorno = (BigDecimal)ClassUtil.invocarMetodo(prop,vo);
							if(retorno == null)
								retorno = BigDecimal.ZERO;
							String valorBD = retorno.setScale(Integer.valueOf(decimal)).toString().replace(".", "");
							sb.append(TextUtil.completarEsquerda(valorBD,Integer.parseInt(tamanho), "0"));
						}
						else{
							Long retorno = (Long)ClassUtil.invocarMetodo(prop,vo);
							if(retorno == null)
								retorno = new Long(0);
							sb.append(TextUtil.completarEsquerda(String.valueOf(retorno), Integer.parseInt(tamanho), "0"));
						}
					}
					else{
						String retorno = (String)ClassUtil.invocarMetodo(prop,vo);
						sb.append(TextUtil.completarDireita(retorno, Integer.parseInt(tamanho), " "));
					}
				}
				
				else if(el.getTagName().equals("loop")){
					
					Integer repetitions = Integer.parseInt(el.getElementsByTagName("repetitions").item(0).getTextContent());
					Integer tamanho = Integer.parseInt(el.getElementsByTagName("size").item(0).getTextContent());
					String classe = el.getElementsByTagName("class").item(0).getTextContent();
					String prop = el.getElementsByTagName("property").item(0).getTextContent();
					String voLoop = el.getElementsByTagName("vo").item(0).getTextContent();
					
					prop = "get" + prop.substring(0, 1).toUpperCase() + prop.substring(1);
					List lista = (List)ClassUtil.invocarMetodo(prop,vo);
					
					if(lista == null)
						lista = (ArrayList)ClassUtil.instanciaObjeto(ArrayList.class.getName());
						
					for(int j = 0; j < repetitions; j ++){
						Object obj;
						if(j < lista.size()){
							obj = lista.get(j);
						}	
						else{
							obj = ClassUtil.instanciaObjeto(voLoop);	
						}
						this.gerarParametrosCtg(el.getChildNodes(),10,sb,obj);
					}
				}
				
				
				
			}
		}
	}
	
	public void gerarParametrosClasse(NodeList params, int initIndex, StringBuilder sb, Object vo) throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		for(int i = initIndex; i < params.getLength(); i++){
			Node node = params.item(i);
			if(node.getNodeType() == Node.ELEMENT_NODE){
				Element el = (Element)node;
		
				if(el.getTagName().equals("vo")){
					if(vo == null){
						String nomeClasse = el.getTextContent();
						vo = ClassUtil.instanciaObjeto(nomeClasse);
					}	
				}
				
				else if(el.getTagName().equals("param")){
					
					String tamanho = el.getElementsByTagName("size").item(0).getTextContent();
					String classe = el.getElementsByTagName("class").item(0).getTextContent();;
					String prop = el.getElementsByTagName("property").item(0).getTextContent();
					String decimal = el.getElementsByTagName("decimal").item(0).getTextContent();
					
					String valor = sb.substring(this.posicao, posicao += Integer.parseInt(tamanho));
					prop = "set" + prop.substring(0, 1).toUpperCase() + prop.substring(1);
					
					if(classe.equals("Numeric")){
						if(!decimal.equals("0")){
							BigDecimal bd = new BigDecimal(valor).setScale(Integer.parseInt(decimal));
							ClassUtil.invocarMetodo(prop, vo, bd);
						}
						else{
							ClassUtil.invocarMetodo(prop, vo, Long.parseLong(valor));
						}
					}
					else{
						ClassUtil.invocarMetodo(prop, vo, valor);
					}
				}
				
				else if(el.getTagName().equals("loop")){
					
					Integer repetitions = Integer.parseInt(el.getElementsByTagName("repetitions").item(0).getTextContent());
					String prop = el.getElementsByTagName("property").item(0).getTextContent();
					String voLoop = el.getElementsByTagName("vo").item(0).getTextContent();
					
					prop = "set" + prop.substring(0, 1).toUpperCase() + prop.substring(1);
					List lista = new ArrayList();
						
					for(int j = 0; j < repetitions; j ++){
						Object obj = ClassUtil.instanciaObjeto(voLoop);
						this.gerarParametrosClasse(el.getChildNodes(),10,sb,obj);
						lista.add(obj);
					}
					ClassUtil.invocarMetodo(prop, vo, lista);
				}
			}
		}
	}
	
	public void reset(CTG ctg)  {
		try{
			String caminho = "C:/Users/hugoa/workspace/CTGParser/src/tests/";
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder;
			builder = factory.newDocumentBuilder();
			doc = builder.parse(new File(caminho + ctg.getXMLName()));
			doc.getDocumentElement().normalize();
			instance = (CTG)ClassUtil.instanciaObjeto(ctg.getClass().getName());
		}
		catch(Exception ex){
			
		}
	}
	
	
	
}
