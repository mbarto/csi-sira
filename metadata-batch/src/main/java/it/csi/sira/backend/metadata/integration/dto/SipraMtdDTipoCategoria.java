/*
 * Created on 8 nov 2016 ( Time 16:16:32 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package it.csi.sira.backend.metadata.integration.dto;

import java.io.Serializable;


/**
 * Java bean for 'SipraMtdDTipoCategoria' entity
 * 
 * @author Telosys Tools
 *
 */
public class SipraMtdDTipoCategoria implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    // DB : id_tipo_categoria int4 
    private Integer idTipoCategoria;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    // DB : des_tipo_categoria varchar 
    private String desTipoCategoria;



    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setIdTipoCategoria( Integer idTipoCategoria ) {
        this.idTipoCategoria = idTipoCategoria ;
    }

    public Integer getIdTipoCategoria() {
        return this.idTipoCategoria;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    public void setDesTipoCategoria( String desTipoCategoria ) {
        this.desTipoCategoria = desTipoCategoria;
    }
    public String getDesTipoCategoria() {
        return this.desTipoCategoria;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(idTipoCategoria);
        sb.append("|");
        sb.append(desTipoCategoria);
        return sb.toString(); 
    } 


}
