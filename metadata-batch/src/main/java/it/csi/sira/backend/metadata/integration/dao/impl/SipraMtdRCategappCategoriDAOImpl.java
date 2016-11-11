/*
 * Created on 8 nov 2016 ( Time 16:16:32 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package it.csi.sira.backend.metadata.integration.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import it.csi.sira.backend.metadata.integration.dto.SipraMtdRCategappCategori;
import it.csi.sira.backend.metadata.integration.dao.SipraMtdRCategappCategoriDAO;
import it.csi.sira.backend.metadata.utils.GenericDAO;
import org.springframework.jdbc.core.RowMapper;

/**
 * SipraMtdRCategappCategori DAO implementation 
 * 
 * @author Telosys Tools
 *
 */
public class SipraMtdRCategappCategoriDAOImpl extends GenericDAO<SipraMtdRCategappCategori> implements SipraMtdRCategappCategoriDAO {
	//----------------------------------------------------------------------
	/**
	 * DAO constructor
	 */
	public SipraMtdRCategappCategoriDAOImpl() {
		super();
	}

	private final static String QUERY_PRIMARY_KEY = 
		"select * from sipra_mtd_r_categapp_categori where id_categoria_appl = :id_categoria_appl and id_categoria = :id_categoria";
	
	private final static String QUERY_INSERT = 
		"insert into sipra_mtd_r_categapp_categori(id_categoria_appl,id_categoria) values(:id_categoria_appl,:id_categoria)";

	private final static String QUERY_UPDATE = 
		"update sipra_mtd_r_categapp_categori set   where id_categoria_appl = :id_categoria_appl and id_categoria = :id_categoria";

	private final static String QUERY_DELETE = 
		"delete from sipra_mtd_r_categapp_categori where  id_categoria_appl = :id_categoria_appl and id_categoria = :id_categoria";

	private final static String SQL_COUNT_ALL = 
		"select count(*) from sipra_mtd_r_categapp_categori";
	
	@Override
	public String getPrimaryKeySelect() {
		return QUERY_PRIMARY_KEY;		
	}
	
	@Override
	public String getTableName(){
		return "sipra_mtd_r_categapp_categori";
	}

	@Override
	public String getSqlSelect() {
		return "select * from sipra_mtd_r_categapp_categori";
	}

	@Override
	public String getSqlInsert() {
		return QUERY_INSERT;
	}

	@Override
	public String getSqlUpdate() {
		return QUERY_UPDATE;
	}

	@Override
	public String getSqlDelete() {
		return QUERY_DELETE;
	}

	@Override
	public String getSqlCount() {
		return SQL_COUNT_ALL;
	}

	public SipraMtdRCategappCategori findByPK(Integer idCategoriaAppl, Integer idCategoria) {
		java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
		map.put("id_categoria_appl", idCategoriaAppl);
		map.put("id_categoria", idCategoria);
		return super.findByPK(map);		
	}

	public int deleteByPK(Integer idCategoriaAppl, Integer idCategoria) {
		java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
		map.put("id_categoria_appl", idCategoriaAppl);
		map.put("id_categoria", idCategoria);
		return super.delete(getSqlDelete(), map);		
	}

	@Override
	public java.util.Map<String, Object> getValuesForInsert(SipraMtdRCategappCategori sipraMtdRCategappCategori) {
		java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
		map.put("id_categoria_appl", sipraMtdRCategappCategori.getIdCategoriaAppl());
		map.put("id_categoria", sipraMtdRCategappCategori.getIdCategoria());
		return map;
	}

	@Override
	public java.util.Map<String, Object> getValuesForUpdate(SipraMtdRCategappCategori sipraMtdRCategappCategori) {
		java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
		map.put("id_categoria_appl", sipraMtdRCategappCategori.getIdCategoriaAppl());
		map.put("id_categoria", sipraMtdRCategappCategori.getIdCategoria());
		return map;
	}

	public java.util.Map<String, Object> getValuesForPrimaryKey(SipraMtdRCategappCategori sipraMtdRCategappCategori) {
		java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
		map.put("id_categoria_appl", sipraMtdRCategappCategori.getIdCategoriaAppl());
		map.put("id_categoria", sipraMtdRCategappCategori.getIdCategoria());
		return map;
	}

	@Override
	public java.util.Map<String, Object> getValuesForDelete(SipraMtdRCategappCategori sipraMtdRCategappCategori) {
		java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
		map.put("id_categoria_appl", sipraMtdRCategappCategori.getIdCategoriaAppl());
		map.put("id_categoria", sipraMtdRCategappCategori.getIdCategoria());
		return map;
	}

	@Override
	public RowMapper<SipraMtdRCategappCategori> getRowMapper()  {
		//--- RowMapper to populate a new bean instance
		//return new SipraMtdRCategappCategoriRowMapper( new SipraMtdRCategappCategori() ) ;

       return new SipraMtdRCategappCategoriRowMapper() ;
	}

	//----------------------------------------------------------------------
	/**
	 * Populates the given bean with the data retrieved from the given ResultSet
	 * @param rs
	 * @param sipraMtdRCategappCategori
	 * @throws SQLException
	 */
	private static void populateBean(ResultSet rs, SipraMtdRCategappCategori sipraMtdRCategappCategori) throws SQLException {

		//--- Set data from ResultSet to Bean attributes
		sipraMtdRCategappCategori.setIdCategoriaAppl(rs.getInt("id_categoria_appl")); // java.lang.Integer
		if ( rs.wasNull() ) { sipraMtdRCategappCategori.setIdCategoriaAppl(null); }; // not primitive number => keep null value if any
		sipraMtdRCategappCategori.setIdCategoria(rs.getInt("id_categoria")); // java.lang.Integer
		if ( rs.wasNull() ) { sipraMtdRCategappCategori.setIdCategoria(null); }; // not primitive number => keep null value if any
	}


	/**
	 * Specific inner class for 'RowMapper' implementation
	 */
	public static class SipraMtdRCategappCategoriRowMapper implements RowMapper<SipraMtdRCategappCategori> {
	
		public SipraMtdRCategappCategoriRowMapper() {
			
		}
		
		public SipraMtdRCategappCategori mapRow(ResultSet rs, int rowNum) throws SQLException {
			SipraMtdRCategappCategori bean = new SipraMtdRCategappCategori();
			populateBean(rs, bean);
			return bean;
		}
	}
}
