package main;

import java.lang.reflect.InvocationTargetException;

import org.w3c.dom.Document;

public class CTGParser {
	
	Document doc;
	String className;
	
	
	public CTGParser(String className) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException{
		Object obj = ClassUtil.instanciaObjeto(className);
		if(obj instanceof CTG){
			this.doc = XMLUtil.abrirXml("");
			this.className = className;
		}	
		else
			throw new IllegalArgumentException();
	}
	
	public String ClassToCTG(Object obj) throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException{
		ClassToCTG parser = new ClassToCTG(doc, obj);
		return parser.execute();
	}
	
	public Object CTGToClass(String retornoCtg) throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException{
		CTGToClass parser = new CTGToClass(doc, retornoCtg, this.className);
		return parser.execute();
	}
	
}
