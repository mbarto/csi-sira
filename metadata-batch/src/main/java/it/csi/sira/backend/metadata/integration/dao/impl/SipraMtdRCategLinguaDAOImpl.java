/*
 * Created on 8 nov 2016 ( Time 16:16:32 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package it.csi.sira.backend.metadata.integration.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import it.csi.sira.backend.metadata.integration.dto.SipraMtdRCategLingua;
import it.csi.sira.backend.metadata.integration.dao.SipraMtdRCategLinguaDAO;
import it.csi.sira.backend.metadata.utils.GenericDAO;
import org.springframework.jdbc.core.RowMapper;

/**
 * SipraMtdRCategLingua DAO implementation 
 * 
 * @author Telosys Tools
 *
 */
public class SipraMtdRCategLinguaDAOImpl extends GenericDAO<SipraMtdRCategLingua> implements SipraMtdRCategLinguaDAO {
	//----------------------------------------------------------------------
	/**
	 * DAO constructor
	 */
	public SipraMtdRCategLinguaDAOImpl() {
		super();
	}

	private final static String QUERY_PRIMARY_KEY = 
		"select * from sipra_mtd_r_categ_lingua where id_categoria = :id_categoria and id_lingua = :id_lingua";
	
	private final static String QUERY_INSERT = 
		"insert into sipra_mtd_r_categ_lingua(id_categoria,id_lingua,des_categoria,des_alias,fl_alias) values(:id_categoria,:id_lingua,:des_categoria,:des_alias,:fl_alias)";

	private final static String QUERY_UPDATE = 
		"update sipra_mtd_r_categ_lingua set des_categoria = :des_categoria, des_alias = :des_alias, fl_alias = :fl_alias  where id_categoria = :id_categoria and id_lingua = :id_lingua";

	private final static String QUERY_DELETE = 
		"delete from sipra_mtd_r_categ_lingua where  id_categoria = :id_categoria and id_lingua = :id_lingua";

	private final static String SQL_COUNT_ALL = 
		"select count(*) from sipra_mtd_r_categ_lingua";
	
	@Override
	public String getPrimaryKeySelect() {
		return QUERY_PRIMARY_KEY;		
	}
	
	@Override
	public String getTableName(){
		return "sipra_mtd_r_categ_lingua";
	}

	@Override
	public String getSqlSelect() {
		return "select * from sipra_mtd_r_categ_lingua";
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

	public SipraMtdRCategLingua findByPK(Integer idCategoria, Integer idLingua) {
		java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
		map.put("id_categoria", idCategoria);
		map.put("id_lingua", idLingua);
		return super.findByPK(map);		
	}

	public int deleteByPK(Integer idCategoria, Integer idLingua) {
		java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
		map.put("id_categoria", idCategoria);
		map.put("id_lingua", idLingua);
		return super.delete(getSqlDelete(), map);		
	}

	@Override
	public java.util.Map<String, Object> getValuesForInsert(SipraMtdRCategLingua sipraMtdRCategLingua) {
		java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
		map.put("id_categoria", sipraMtdRCategLingua.getIdCategoria());
		map.put("id_lingua", sipraMtdRCategLingua.getIdLingua());
		map.put("des_categoria", sipraMtdRCategLingua.getDesCategoria());
		map.put("des_alias", sipraMtdRCategLingua.getDesAlias());
		map.put("fl_alias", sipraMtdRCategLingua.getFlAlias());
		return map;
	}

	@Override
	public java.util.Map<String, Object> getValuesForUpdate(SipraMtdRCategLingua sipraMtdRCategLingua) {
		java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
		map.put("des_categoria", sipraMtdRCategLingua.getDesCategoria());
		map.put("des_alias", sipraMtdRCategLingua.getDesAlias());
		map.put("fl_alias", sipraMtdRCategLingua.getFlAlias());
		map.put("id_categoria", sipraMtdRCategLingua.getIdCategoria());
		map.put("id_lingua", sipraMtdRCategLingua.getIdLingua());
		return map;
	}

	public java.util.Map<String, Object> getValuesForPrimaryKey(SipraMtdRCategLingua sipraMtdRCategLingua) {
		java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
		map.put("id_categoria", sipraMtdRCategLingua.getIdCategoria());
		map.put("id_lingua", sipraMtdRCategLingua.getIdLingua());
		return map;
	}

	@Override
	public java.util.Map<String, Object> getValuesForDelete(SipraMtdRCategLingua sipraMtdRCategLingua) {
		java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
		map.put("id_categoria", sipraMtdRCategLingua.getIdCategoria());
		map.put("id_lingua", sipraMtdRCategLingua.getIdLingua());
		return map;
	}

	@Override
	public RowMapper<SipraMtdRCategLingua> getRowMapper()  {
		//--- RowMapper to populate a new bean instance
		//return new SipraMtdRCategLinguaRowMapper( new SipraMtdRCategLingua() ) ;

       return new SipraMtdRCategLinguaRowMapper() ;
	}

	//----------------------------------------------------------------------
	/**
	 * Populates the given bean with the data retrieved from the given ResultSet
	 * @param rs
	 * @param sipraMtdRCategLingua
	 * @throws SQLException
	 */
	private static void populateBean(ResultSet rs, SipraMtdRCategLingua sipraMtdRCategLingua) throws SQLException {

		//--- Set data from ResultSet to Bean attributes
		sipraMtdRCategLingua.setIdCategoria(rs.getInt("id_categoria")); // java.lang.Integer
		if ( rs.wasNull() ) { sipraMtdRCategLingua.setIdCategoria(null); }; // not primitive number => keep null value if any
		sipraMtdRCategLingua.setIdLingua(rs.getInt("id_lingua")); // java.lang.Integer
		if ( rs.wasNull() ) { sipraMtdRCategLingua.setIdLingua(null); }; // not primitive number => keep null value if any
		sipraMtdRCategLingua.setDesCategoria(rs.getString("des_categoria")); // java.lang.String
		sipraMtdRCategLingua.setDesAlias(rs.getString("des_alias")); // java.lang.String
		sipraMtdRCategLingua.setFlAlias(rs.getString("fl_alias")); // java.lang.String
	}


	/**
	 * Specific inner class for 'RowMapper' implementation
	 */
	public static class SipraMtdRCategLinguaRowMapper implements RowMapper<SipraMtdRCategLingua> {
	
		public SipraMtdRCategLinguaRowMapper() {
			
		}
		
		public SipraMtdRCategLingua mapRow(ResultSet rs, int rowNum) throws SQLException {
			SipraMtdRCategLingua bean = new SipraMtdRCategLingua();
			populateBean(rs, bean);
			return bean;
		}
	}
}
