package main.interfaces;

import java.lang.reflect.InvocationTargetException;

import main.base.BaseCTG;

public interface XMLParser {

	String classToCTG(CTG vo);

	Object ctgToClass(String ctg) throws ClassNotFoundException, NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException;

}