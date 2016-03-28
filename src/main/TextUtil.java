package main;

public class TextUtil {
	
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
	
}
