package main.base;

import main.interfaces.CTG;

public abstract class BaseCTG {

	private String codTrans;
	private Long codUsuar;
	private String nomeOper;
	private String chaveSec;
	private Long opcao;
	private Long tipo;
	private Long tamAreaCtg;
	private String portaMainframe;
	private String tcpCliente;
	private String filler1;
	private Long tamAreaPgm;
	private String filler2;
	private Long codRetorno;
	private String mensRetorno;
	
	
	public BaseCTG(String codTrans, Long codUsuar, String nomeOper, String chaveSec, Long opcao, Long tipo,
			Long tamAreaCtg, String portaMainframe, String tcpCliente, Long tamAreaPgm, Long codRetorno,
			String mensRetorno) {
		super();
		this.codTrans = codTrans;
		this.codUsuar = codUsuar;
		this.nomeOper = nomeOper;
		this.chaveSec = chaveSec;
		this.opcao = opcao;
		this.tipo = tipo;
		this.tamAreaCtg = tamAreaCtg;
		this.portaMainframe = portaMainframe;
		this.tcpCliente = tcpCliente;
		this.tamAreaPgm = tamAreaPgm;
		this.codRetorno = codRetorno;
		this.mensRetorno = mensRetorno;
	}
	
	public BaseCTG(){}


	public abstract String getXMLName();


	public String getCodTrans() {
		return codTrans;
	}


	public void setCodTrans(String codTrans) {
		this.codTrans = codTrans;
	}


	public Long getCodUsuar() {
		return codUsuar;
	}


	public void setCodUsuar(Long codUsuar) {
		this.codUsuar = codUsuar;
	}


	public String getNomeOper() {
		return nomeOper;
	}


	public void setNomeOper(String nomeOper) {
		this.nomeOper = nomeOper;
	}


	public String getChaveSec() {
		return chaveSec;
	}


	public void setChaveSec(String chaveSec) {
		this.chaveSec = chaveSec;
	}


	public Long getOpcao() {
		return opcao;
	}


	public void setOpcao(Long opcao) {
		this.opcao = opcao;
	}


	public Long getTipo() {
		return tipo;
	}


	public void setTipo(Long tipo) {
		this.tipo = tipo;
	}


	public Long getTamAreaCtg() {
		return tamAreaCtg;
	}


	public void setTamAreaCtg(Long tamAreaCtg) {
		this.tamAreaCtg = tamAreaCtg;
	}


	public String getPortaMainframe() {
		return portaMainframe;
	}


	public void setPortaMainframe(String portaMainframe) {
		this.portaMainframe = portaMainframe;
	}


	public String getTcpCliente() {
		return tcpCliente;
	}


	public void setTcpCliente(String tcpCliente) {
		this.tcpCliente = tcpCliente;
	}


	public String getFiller1() {
		return filler1;
	}


	public void setFiller1(String filler1) {
		this.filler1 = filler1;
	}


	public Long getTamAreaPgm() {
		return tamAreaPgm;
	}


	public void setTamAreaPgm(Long tamAreaPgm) {
		this.tamAreaPgm = tamAreaPgm;
	}


	public String getFiller2() {
		return filler2;
	}


	public void setFiller2(String filler2) {
		this.filler2 = filler2;
	}


	public Long getCodRetorno() {
		return codRetorno;
	}


	public void setCodRetorno(Long codRetorno) {
		this.codRetorno = codRetorno;
	}


	public String getMensRetorno() {
		return mensRetorno;
	}


	public void setMensRetorno(String mensRetorno) {
		this.mensRetorno = mensRetorno;
	}

}
