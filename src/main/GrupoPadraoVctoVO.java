package main;

/**
 * Classe gerada através do plugin CTG2XML 
 * @since 26/03/2016 - 17:08:08 
 * @author BeanGenerator
 **/ 
public class GrupoPadraoVctoVO implements java.io.Serializable, Cloneable {

    private final static long serialVersionUID = GrupoPadraoVctoVO.class.getName().hashCode();
    private java.lang.Long mesPadrao;
    private java.lang.String codRegimeRetrib;
    private java.lang.String codEscVcto;
    private java.lang.String codTabVcto;
    private java.lang.String codRef;
    private java.lang.String codGrau;

    public java.lang.Long getMesPadrao(){
        return mesPadrao;
    }

    public java.lang.String getCodRegimeRetrib(){
        return codRegimeRetrib;
    }

    public java.lang.String getCodEscVcto(){
        return codEscVcto;
    }

    public java.lang.String getCodTabVcto(){
        return codTabVcto;
    }

    public java.lang.String getCodRef(){
        return codRef;
    }

    public java.lang.String getCodGrau(){
        return codGrau;
    }

    public void setMesPadrao(java.lang.Long mesPadrao){
        this.mesPadrao = mesPadrao;
    }

    public void setCodRegimeRetrib(java.lang.String codRegimeRetrib){
        this.codRegimeRetrib = codRegimeRetrib;
    }

    public void setCodEscVcto(java.lang.String codEscVcto){
        this.codEscVcto = codEscVcto;
    }

    public void setCodTabVcto(java.lang.String codTabVcto){
        this.codTabVcto = codTabVcto;
    }

    public void setCodRef(java.lang.String codRef){
        this.codRef = codRef;
    }

    public void setCodGrau(java.lang.String codGrau){
        this.codGrau = codGrau;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }
}
