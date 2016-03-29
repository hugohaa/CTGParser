package main;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ClassToCTG {

	private Document doc;
	private Object vo;
	
	public ClassToCTG(Document doc, Object vo){
		this.doc = doc;
		this.vo = vo;
	}
	
	
	public String execute() throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException{
		
		StringBuilder sb = new StringBuilder();
		
		//Nodelist do Header e Parametros
		NodeList header = XMLUtil.getElementByTag(doc, "header").getChildNodes();
		NodeList params = XMLUtil.getElementByTag(doc, "parameters").getChildNodes();
		
		this.gerarHeader(header, sb);
		this.gerarParametros(params, 0, sb, this.vo);
		
		return sb.toString();
		
	}
	
	
	
	private void gerarHeader(NodeList parametros, StringBuilder sb) {
		for(int i = 0; i < parametros.getLength(); i++){
			Node node = parametros.item(i);
			if(node.getNodeType() == Node.ELEMENT_NODE){
				Element el = (Element)node;
				
				String valor = XMLUtil.getElementContentByTag(el, "value");
				String tamanho = XMLUtil.getElementContentByTag(el, "size");
				String classe = XMLUtil.getElementContentByTag(el, "class");
				
				if(classe.equals("Numeric")){
					sb.append(TextUtil.completarEsquerda(valor, Integer.parseInt(tamanho), "0"));
				}
				else{
					sb.append(TextUtil.completarDireita(valor, Integer.parseInt(tamanho), " "));
				}
			}
		}
	}
	
	
	private void gerarParametros(NodeList params, int initIndex, StringBuilder sb, Object vo) throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		for(int i = initIndex; i < params.getLength(); i++){
			Node node = params.item(i);
			if(node.getNodeType() == Node.ELEMENT_NODE){
				Element el = (Element)node;
				
				if(el.getTagName().equals("vo")){
					System.out.println("VO: " + el.getTextContent());
				}
				
				else if(el.getTagName().equals("param")){
					
					String tamanho = XMLUtil.getElementContentByTag(el, "size");
					String classe = XMLUtil.getElementContentByTag(el, "class");
					String prop = XMLUtil.getElementContentByTag(el, "property");
					String decimal = XMLUtil.getElementContentByTag(el, "decimal");
					
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
					
					Integer repetitions = Integer.parseInt(XMLUtil.getElementContentByTag(el, "repetitions"));
					Integer tamanho = Integer.parseInt(XMLUtil.getElementContentByTag(el, "size"));
					String classe = XMLUtil.getElementContentByTag(el, "class");
					String prop = XMLUtil.getElementContentByTag(el, "property");
					String voLoop = XMLUtil.getElementContentByTag(el, "vo");
					
					prop = "get" + prop.substring(0, 1).toUpperCase() + prop.substring(1);
					List lista = (List)ClassUtil.invocarMetodo(prop,vo);
					
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
						this.gerarParametros(el.getChildNodes(),10,sb,obj);
					}
				}
			}
		}
	}
	
	
	
}
