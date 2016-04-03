package main.vo;

/**
 * Classe gerada através do plugin CTG2XML 
 * @since 26/03/2016 - 17:08:08 
 * @author BeanGenerator
 **/ 
public class GrupoPagtoVctoVO implements java.io.Serializable, Cloneable {

    private final static long serialVersionUID = GrupoPagtoVctoVO.class.getName().hashCode();
    private java.lang.Long mesFolha;
    private java.lang.Long dataInicPeriodRef;
    private java.lang.Long dataFimPeriodRef;
    private java.lang.Long dataCredito;
    private java.lang.String quantLancUnid;
    private java.lang.String tipoUnid;
    private java.math.BigDecimal valorLanc;
    private java.lang.String sinalValor;

    public java.lang.Long getMesFolha(){
        return mesFolha;
    }

    public java.lang.Long getDataInicPeriodRef(){
        return dataInicPeriodRef;
    }

    public java.lang.Long getDataFimPeriodRef(){
        return dataFimPeriodRef;
    }

    public java.lang.Long getDataCredito(){
        return dataCredito;
    }

    public java.lang.String getQuantLancUnid(){
        return quantLancUnid;
    }

    public java.lang.String getTipoUnid(){
        return tipoUnid;
    }

    public java.math.BigDecimal getValorLanc(){
        return valorLanc;
    }

    public java.lang.String getSinalValor(){
        return sinalValor;
    }

    public void setMesFolha(java.lang.Long mesFolha){
        this.mesFolha = mesFolha;
    }

    public void setDataInicPeriodRef(java.lang.Long dataInicPeriodRef){
        this.dataInicPeriodRef = dataInicPeriodRef;
    }

    public void setDataFimPeriodRef(java.lang.Long dataFimPeriodRef){
        this.dataFimPeriodRef = dataFimPeriodRef;
    }

    public void setDataCredito(java.lang.Long dataCredito){
        this.dataCredito = dataCredito;
    }

    public void setQuantLancUnid(java.lang.String quantLancUnid){
        this.quantLancUnid = quantLancUnid;
    }

    public void setTipoUnid(java.lang.String tipoUnid){
        this.tipoUnid = tipoUnid;
    }

    public void setValorLanc(java.math.BigDecimal valorLanc){
        this.valorLanc = valorLanc;
    }

    public void setSinalValor(java.lang.String sinalValor){
        this.sinalValor = sinalValor;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }
}
