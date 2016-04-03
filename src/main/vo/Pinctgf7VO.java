package main.vo;

import main.base.BaseCTG;
import main.interfaces.CTG;

/**
 * Classe gerada através do plugin CTG2XML 
 * @since 26/03/2016 - 17:08:08 
 * @author BeanGenerator
 **/ 
public class Pinctgf7VO extends BaseCTG implements java.io.Serializable, Cloneable, CTG {

    private final static long serialVersionUID = Pinctgf7VO.class.getName().hashCode();
    private java.lang.Long codCliSeg;
    private java.lang.Long codUsuarSeg;
    private java.lang.Long codProdutoSeg;
    private java.lang.String tipoNivelSeg;
    private java.lang.Long codVisaoSeg;
    private java.lang.String integrTransacao;
    private java.lang.Long numeroOpcao;
    private java.lang.String dataOperacao;
    private java.lang.String horaOperacao;
    private java.lang.String controleTransacao;
    private java.lang.String fase;
    private java.lang.String flagRetorno;
    private java.lang.Long numRegSistArg;
    private java.lang.String flagNumRegSist;
    private java.lang.Long numPvEvArg;
    private java.lang.String flagNumPvEv;
    private java.lang.Long anoBaseArg;
    private java.util.List anosEscolhaG;
    private java.lang.Long proxPosItemPagto;
    private java.lang.String flagOrigFunc;
    private java.lang.Long numCpf;
    private java.lang.String codVerifCpf;
    private java.lang.String numRg;
    private java.lang.String digRg;
    private java.lang.String nomeAbrev;
    private java.lang.Long codUaPvEv;
    private java.lang.String codIndSeq;
    private java.lang.String codUcdSetor;
    private java.lang.Long codUcdSubset;
    private java.lang.String codOrgao;
    private java.lang.Long codUnidOrcam;
    private java.lang.Long codUnidDesp;
    private java.lang.Long codUnidAdmFreq;
    private java.lang.String codCatServ;
    private java.lang.Long codCargFunc;
    private java.util.List grupoPadraoVcto;
    private java.lang.Long indItensPagto;
    private java.util.List grupoItensPagto4;
    private java.lang.String flagBotaoImpri;
    private java.lang.String flagBotaoExpor;
    private java.lang.String nomeCargFunc;
    private java.lang.Long dataInicProv;
    private java.lang.Long dataFimProv;
    private java.lang.String codInterrExerc;
    private java.lang.Long tipoInterrExerc;
    private java.lang.String denominacaoInterr;
    private java.lang.String filler3;
    private java.lang.String filler4;
    private java.lang.String programa;
    private java.lang.Long seqErro;
    private java.lang.String descrErro;

    
    public Pinctgf7VO(String codTrans, Long codUsuar, String nomeOper, String chaveSec, Long opcao, Long tipo,
			Long tamAreaCtg, String portaMainframe, String tcpCliente, Long tamAreaPgm, Long codRetorno,
			String mensRetorno) {
		super(codTrans, codUsuar, nomeOper, chaveSec, opcao, tipo, tamAreaCtg, portaMainframe, tcpCliente, tamAreaPgm,
				codRetorno, mensRetorno);

    }
    
    public Pinctgf7VO(){};

	public java.lang.Long getCodCliSeg(){
        return codCliSeg;
    }

    public java.lang.Long getCodUsuarSeg(){
        return codUsuarSeg;
    }

    public java.lang.Long getCodProdutoSeg(){
        return codProdutoSeg;
    }

    public java.lang.String getTipoNivelSeg(){
        return tipoNivelSeg;
    }

    public java.lang.Long getCodVisaoSeg(){
        return codVisaoSeg;
    }

    public java.lang.String getIntegrTransacao(){
        return integrTransacao;
    }

    public java.lang.Long getNumeroOpcao(){
        return numeroOpcao;
    }

    public java.lang.String getDataOperacao(){
        return dataOperacao;
    }

    public java.lang.String getHoraOperacao(){
        return horaOperacao;
    }

    public java.lang.String getControleTransacao(){
        return controleTransacao;
    }

    public java.lang.String getFase(){
        return fase;
    }

    public java.lang.String getFlagRetorno(){
        return flagRetorno;
    }

    public java.lang.Long getNumRegSistArg(){
        return numRegSistArg;
    }

    public java.lang.String getFlagNumRegSist(){
        return flagNumRegSist;
    }

    public java.lang.Long getNumPvEvArg(){
        return numPvEvArg;
    }

    public java.lang.String getFlagNumPvEv(){
        return flagNumPvEv;
    }

    public java.lang.Long getAnoBaseArg(){
        return anoBaseArg;
    }

    public java.util.List getAnosEscolhaG(){
        return anosEscolhaG;
    }

    public java.lang.Long getProxPosItemPagto(){
        return proxPosItemPagto;
    }

    public java.lang.String getFlagOrigFunc(){
        return flagOrigFunc;
    }

    public java.lang.Long getNumCpf(){
        return numCpf;
    }

    public java.lang.String getCodVerifCpf(){
        return codVerifCpf;
    }

    public java.lang.String getNumRg(){
        return numRg;
    }

    public java.lang.String getDigRg(){
        return digRg;
    }

    public java.lang.String getNomeAbrev(){
        return nomeAbrev;
    }

    public java.lang.Long getCodUaPvEv(){
        return codUaPvEv;
    }

    public java.lang.String getCodIndSeq(){
        return codIndSeq;
    }

    public java.lang.String getCodUcdSetor(){
        return codUcdSetor;
    }

    public java.lang.Long getCodUcdSubset(){
        return codUcdSubset;
    }

    public java.lang.String getCodOrgao(){
        return codOrgao;
    }

    public java.lang.Long getCodUnidOrcam(){
        return codUnidOrcam;
    }

    public java.lang.Long getCodUnidDesp(){
        return codUnidDesp;
    }

    public java.lang.Long getCodUnidAdmFreq(){
        return codUnidAdmFreq;
    }

    public java.lang.String getCodCatServ(){
        return codCatServ;
    }

    public java.lang.Long getCodCargFunc(){
        return codCargFunc;
    }

    public java.util.List getGrupoPadraoVcto(){
        return grupoPadraoVcto;
    }

    public java.lang.Long getIndItensPagto(){
        return indItensPagto;
    }

    public java.util.List getGrupoItensPagto4(){
        return grupoItensPagto4;
    }

    public java.lang.String getFlagBotaoImpri(){
        return flagBotaoImpri;
    }

    public java.lang.String getFlagBotaoExpor(){
        return flagBotaoExpor;
    }

    public java.lang.String getNomeCargFunc(){
        return nomeCargFunc;
    }

    public java.lang.Long getDataInicProv(){
        return dataInicProv;
    }

    public java.lang.Long getDataFimProv(){
        return dataFimProv;
    }

    public java.lang.String getCodInterrExerc(){
        return codInterrExerc;
    }

    public java.lang.Long getTipoInterrExerc(){
        return tipoInterrExerc;
    }

    public java.lang.String getDenominacaoInterr(){
        return denominacaoInterr;
    }

    public java.lang.String getFiller3(){
        return filler3;
    }

    public java.lang.String getFiller4(){
        return filler4;
    }

    public java.lang.String getPrograma(){
        return programa;
    }

    public java.lang.Long getSeqErro(){
        return seqErro;
    }

    public java.lang.String getDescrErro(){
        return descrErro;
    }

    public void setCodCliSeg(java.lang.Long codCliSeg){
        this.codCliSeg = codCliSeg;
    }

    public void setCodUsuarSeg(java.lang.Long codUsuarSeg){
        this.codUsuarSeg = codUsuarSeg;
    }

    public void setCodProdutoSeg(java.lang.Long codProdutoSeg){
        this.codProdutoSeg = codProdutoSeg;
    }

    public void setTipoNivelSeg(java.lang.String tipoNivelSeg){
        this.tipoNivelSeg = tipoNivelSeg;
    }

    public void setCodVisaoSeg(java.lang.Long codVisaoSeg){
        this.codVisaoSeg = codVisaoSeg;
    }

    public void setIntegrTransacao(java.lang.String integrTransacao){
        this.integrTransacao = integrTransacao;
    }

    public void setNumeroOpcao(java.lang.Long numeroOpcao){
        this.numeroOpcao = numeroOpcao;
    }

    public void setDataOperacao(java.lang.String dataOperacao){
        this.dataOperacao = dataOperacao;
    }

    public void setHoraOperacao(java.lang.String horaOperacao){
        this.horaOperacao = horaOperacao;
    }

    public void setControleTransacao(java.lang.String controleTransacao){
        this.controleTransacao = controleTransacao;
    }

    public void setFase(java.lang.String fase){
        this.fase = fase;
    }

    public void setFlagRetorno(java.lang.String flagRetorno){
        this.flagRetorno = flagRetorno;
    }

    public void setNumRegSistArg(java.lang.Long numRegSistArg){
        this.numRegSistArg = numRegSistArg;
    }

    public void setFlagNumRegSist(java.lang.String flagNumRegSist){
        this.flagNumRegSist = flagNumRegSist;
    }

    public void setNumPvEvArg(java.lang.Long numPvEvArg){
        this.numPvEvArg = numPvEvArg;
    }

    public void setFlagNumPvEv(java.lang.String flagNumPvEv){
        this.flagNumPvEv = flagNumPvEv;
    }

    public void setAnoBaseArg(java.lang.Long anoBaseArg){
        this.anoBaseArg = anoBaseArg;
    }

    public void setAnosEscolhaG(java.util.List anosEscolhaG){
        this.anosEscolhaG = anosEscolhaG;
    }
    
    public void setAnosEscolhaG(java.util.ArrayList anosEscolhaG){
        this.anosEscolhaG = anosEscolhaG;
    }

    public void setProxPosItemPagto(java.lang.Long proxPosItemPagto){
        this.proxPosItemPagto = proxPosItemPagto;
    }

    public void setFlagOrigFunc(java.lang.String flagOrigFunc){
        this.flagOrigFunc = flagOrigFunc;
    }

    public void setNumCpf(java.lang.Long numCpf){
        this.numCpf = numCpf;
    }

    public void setCodVerifCpf(java.lang.String codVerifCpf){
        this.codVerifCpf = codVerifCpf;
    }

    public void setNumRg(java.lang.String numRg){
        this.numRg = numRg;
    }

    public void setDigRg(java.lang.String digRg){
        this.digRg = digRg;
    }

    public void setNomeAbrev(java.lang.String nomeAbrev){
        this.nomeAbrev = nomeAbrev;
    }

    public void setCodUaPvEv(java.lang.Long codUaPvEv){
        this.codUaPvEv = codUaPvEv;
    }

    public void setCodIndSeq(java.lang.String codIndSeq){
        this.codIndSeq = codIndSeq;
    }

    public void setCodUcdSetor(java.lang.String codUcdSetor){
        this.codUcdSetor = codUcdSetor;
    }

    public void setCodUcdSubset(java.lang.Long codUcdSubset){
        this.codUcdSubset = codUcdSubset;
    }

    public void setCodOrgao(java.lang.String codOrgao){
        this.codOrgao = codOrgao;
    }

    public void setCodUnidOrcam(java.lang.Long codUnidOrcam){
        this.codUnidOrcam = codUnidOrcam;
    }

    public void setCodUnidDesp(java.lang.Long codUnidDesp){
        this.codUnidDesp = codUnidDesp;
    }

    public void setCodUnidAdmFreq(java.lang.Long codUnidAdmFreq){
        this.codUnidAdmFreq = codUnidAdmFreq;
    }

    public void setCodCatServ(java.lang.String codCatServ){
        this.codCatServ = codCatServ;
    }

    public void setCodCargFunc(java.lang.Long codCargFunc){
        this.codCargFunc = codCargFunc;
    }

    public void setGrupoPadraoVcto(java.util.List grupoPadraoVcto){
        this.grupoPadraoVcto = grupoPadraoVcto;
    }
    
    public void setGrupoPadraoVcto(java.util.ArrayList grupoPadraoVcto){
        this.grupoPadraoVcto = grupoPadraoVcto;
    }

    public void setIndItensPagto(java.lang.Long indItensPagto){
        this.indItensPagto = indItensPagto;
    }

    public void setGrupoItensPagto4(java.util.List grupoItensPagto4){
        this.grupoItensPagto4 = grupoItensPagto4;
    }
    
    public void setGrupoItensPagto4(java.util.ArrayList grupoItensPagto4){
        this.grupoItensPagto4 = grupoItensPagto4;
    }

    public void setFlagBotaoImpri(java.lang.String flagBotaoImpri){
        this.flagBotaoImpri = flagBotaoImpri;
    }

    public void setFlagBotaoExpor(java.lang.String flagBotaoExpor){
        this.flagBotaoExpor = flagBotaoExpor;
    }

    public void setNomeCargFunc(java.lang.String nomeCargFunc){
        this.nomeCargFunc = nomeCargFunc;
    }

    public void setDataInicProv(java.lang.Long dataInicProv){
        this.dataInicProv = dataInicProv;
    }

    public void setDataFimProv(java.lang.Long dataFimProv){
        this.dataFimProv = dataFimProv;
    }

    public void setCodInterrExerc(java.lang.String codInterrExerc){
        this.codInterrExerc = codInterrExerc;
    }

    public void setTipoInterrExerc(java.lang.Long tipoInterrExerc){
        this.tipoInterrExerc = tipoInterrExerc;
    }

    public void setDenominacaoInterr(java.lang.String denominacaoInterr){
        this.denominacaoInterr = denominacaoInterr;
    }

    public void setFiller3(java.lang.String filler3){
        this.filler3 = filler3;
    }

    public void setFiller4(java.lang.String filler4){
        this.filler4 = filler4;
    }

    public void setPrograma(java.lang.String programa){
        this.programa = programa;
    }

    public void setSeqErro(java.lang.Long seqErro){
        this.seqErro = seqErro;
    }

    public void setDescrErro(java.lang.String descrErro){
        this.descrErro = descrErro;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }
    
    public String getXMLName(){
    	return "PINCTGF7.xml";
    }
}
