package tests;

/**
 * Classe gerada através do plugin CTG2XML 
 * @since 26/03/2016 - 17:08:08 
 * @author BeanGenerator
 **/ 
public class AnosEscolhaGVO implements java.io.Serializable, Cloneable {

    private final static long serialVersionUID = AnosEscolhaGVO.class.getName().hashCode();
    private java.lang.Long anosEscolha;

    public java.lang.Long getAnosEscolha(){
        return anosEscolha;
    }

    public void setAnosEscolha(java.lang.Long anosEscolha){
        this.anosEscolha = anosEscolha;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }
}
