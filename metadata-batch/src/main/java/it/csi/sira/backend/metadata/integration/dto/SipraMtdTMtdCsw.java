/*
 * Created on 18 nov 2016 ( Time 17:08:44 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package it.csi.sira.backend.metadata.integration.dto;

import java.io.Serializable;


/**
 * Java bean for 'SipraMtdTMtdCsw' entity
 * 
 * @author Telosys Tools
 *
 */
public class SipraMtdTMtdCsw implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    // DB : id_metadato int4 
    private Integer idMetadato;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    // DB : dc_identifier varchar 
    private String dcIdentifier;

    // DB : titolo varchar 
    private String titolo;

    // DB : testo_abstract varchar 
    private String testoAbstract;

    // DB : tipo_metadato varchar 
    private String tipoMetadato;

    // DB : url_metadato_calc varchar 
    private String urlMetadatoCalc;

    // DB : bound_box_crs varchar 
    private String boundBoxCrs;

    // DB : bound_box_lower_corner varchar 
    private String boundBoxLowerCorner;

    // DB : bound_box_upper_corner varchar 
    private String boundBoxUpperCorner;



    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setIdMetadato( Integer idMetadato ) {
        this.idMetadato = idMetadato ;
    }

    public Integer getIdMetadato() {
        return this.idMetadato;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    public void setDcIdentifier( String dcIdentifier ) {
        this.dcIdentifier = dcIdentifier;
    }
    public String getDcIdentifier() {
        return this.dcIdentifier;
    }

    public void setTitolo( String titolo ) {
        this.titolo = titolo;
    }
    public String getTitolo() {
        return this.titolo;
    }

    public void setTestoAbstract( String testoAbstract ) {
        this.testoAbstract = testoAbstract;
    }
    public String getTestoAbstract() {
        return this.testoAbstract;
    }

    public void setTipoMetadato( String tipoMetadato ) {
        this.tipoMetadato = tipoMetadato;
    }
    public String getTipoMetadato() {
        return this.tipoMetadato;
    }

    public void setUrlMetadatoCalc( String urlMetadatoCalc ) {
        this.urlMetadatoCalc = urlMetadatoCalc;
    }
    public String getUrlMetadatoCalc() {
        return this.urlMetadatoCalc;
    }

    public void setBoundBoxCrs( String boundBoxCrs ) {
        this.boundBoxCrs = boundBoxCrs;
    }
    public String getBoundBoxCrs() {
        return this.boundBoxCrs;
    }

    public void setBoundBoxLowerCorner( String boundBoxLowerCorner ) {
        this.boundBoxLowerCorner = boundBoxLowerCorner;
    }
    public String getBoundBoxLowerCorner() {
        return this.boundBoxLowerCorner;
    }

    public void setBoundBoxUpperCorner( String boundBoxUpperCorner ) {
        this.boundBoxUpperCorner = boundBoxUpperCorner;
    }
    public String getBoundBoxUpperCorner() {
        return this.boundBoxUpperCorner;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(idMetadato);
        sb.append("|");
        sb.append(dcIdentifier);
        sb.append("|");
        sb.append(titolo);
        sb.append("|");
        sb.append(testoAbstract);
        sb.append("|");
        sb.append(tipoMetadato);
        sb.append("|");
        sb.append(urlMetadatoCalc);
        sb.append("|");
        sb.append(boundBoxCrs);
        sb.append("|");
        sb.append(boundBoxLowerCorner);
        sb.append("|");
        sb.append(boundBoxUpperCorner);
        return sb.toString(); 
    } 


}
