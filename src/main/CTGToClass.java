package main;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class CTGToClass {

	private Document doc;
	private StringBuilder sb;
	private int posicao;
	private String classeNome;
	
	public CTGToClass(Document doc, String ctg, String classeNome){
		this.doc = doc;
		this.sb = new StringBuilder(ctg);
		this.posicao = 100;
		this.classeNome = classeNome;
	}
	
	
	public Object execute() throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException{
		Object vo = ClassUtil.instanciaObjeto(this.classeNome);
		
		NodeList params = XMLUtil.getElementByTag(doc, "parameters").getChildNodes();
		this.gerarParametros(params, 0, sb, vo);
		
		return vo;
	}
	
	
	public void gerarParametros(NodeList params, int initIndex, StringBuilder sb, Object vo) throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		for(int i = initIndex; i < params.getLength(); i++){
			Node node = params.item(i);
			if(node.getNodeType() == Node.ELEMENT_NODE){
				Element el = (Element)node;
				
				if(el.getTagName().equals("param")){
					
					String tamanho = XMLUtil.getElementContentByTag(el, "size");
					String classe = XMLUtil.getElementContentByTag(el, "class");
					String prop = XMLUtil.getElementContentByTag(el, "property");
					String decimal = XMLUtil.getElementContentByTag(el, "decimal");
					
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
					
					Integer repetitions = Integer.parseInt(XMLUtil.getElementContentByTag(el, "repetitions"));
					//Integer tamanho = Integer.parseInt(el.getElementsByTagName("size").item(0).getTextContent());
					String classe = XMLUtil.getElementContentByTag(el, "class");
					String prop = XMLUtil.getElementContentByTag(el, "property");
					String voLoop = XMLUtil.getElementContentByTag(el, "vo");
					
					prop = "set" + prop.substring(0, 1).toUpperCase() + prop.substring(1);
					List lista = new ArrayList();
						
					for(int j = 0; j < repetitions; j ++){
						Object obj = Main.instanciaObjeto(voLoop);
						this.gerarParametros(el.getChildNodes(),10,sb,obj);
						lista.add(obj);
					}
					ClassUtil.invocarMetodo(prop, vo, lista);
				}
			}
		}
	}
	
}
