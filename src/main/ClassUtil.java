package main;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClassUtil {

	public static Object invocarMetodo(String metodo, Object obj) throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Method  method = obj.getClass().getMethod(metodo);
		return method.invoke(obj);
	}
	
	public static Object invocarMetodo(String metodo, Object obj, Object param) throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Method  method = obj.getClass().getMethod(metodo, param.getClass());
		return method.invoke(obj, param);
	}
	
	public static Object instanciaObjeto(String className) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException{
		return Class.forName(className).getConstructor().newInstance();
	}
	
}
