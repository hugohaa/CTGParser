package tests;

/**
 * Classe gerada através do plugin CTG2XML 
 * @since 26/03/2016 - 17:08:08 
 * @author BeanGenerator
 **/ 
public class GrupoItensPagto4VO implements java.io.Serializable, Cloneable {

    private final static long serialVersionUID = GrupoItensPagto4VO.class.getName().hashCode();
    private java.lang.String codVctoDescon;
    private java.lang.String tipoFolha;
    private java.lang.String codNat;
    private java.lang.String descrOperAbrev;
    private java.util.List grupoPagtoVcto;

    public java.lang.String getCodVctoDescon(){
        return codVctoDescon;
    }

    public java.lang.String getTipoFolha(){
        return tipoFolha;
    }

    public java.lang.String getCodNat(){
        return codNat;
    }

    public java.lang.String getDescrOperAbrev(){
        return descrOperAbrev;
    }

    public java.util.List getGrupoPagtoVcto(){
        return grupoPagtoVcto;
    }

    public void setCodVctoDescon(java.lang.String codVctoDescon){
        this.codVctoDescon = codVctoDescon;
    }

    public void setTipoFolha(java.lang.String tipoFolha){
        this.tipoFolha = tipoFolha;
    }

    public void setCodNat(java.lang.String codNat){
        this.codNat = codNat;
    }

    public void setDescrOperAbrev(java.lang.String descrOperAbrev){
        this.descrOperAbrev = descrOperAbrev;
    }

    public void setGrupoPagtoVcto(java.util.List grupoPagtoVcto){
        this.grupoPagtoVcto = grupoPagtoVcto;
    }
    
    public void setGrupoPagtoVcto(java.util.ArrayList grupoPagtoVcto){
        this.grupoPagtoVcto = grupoPagtoVcto;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }
}
