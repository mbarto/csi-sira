/*
 * Created on 8 nov 2016 ( Time 16:16:32 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package it.csi.sira.backend.metadata.integration.dao;

import it.csi.sira.backend.metadata.integration.dto.SipraMtdRCategSottocateg;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;




/**
 * SipraMtdRCategSottocateg DAO interface
 * 
 * @author Telosys Tools
 */
public interface SipraMtdRCategSottocategDAO {

	//----------------------------------------------------------------------
	/**
	 * Finds a bean by its primary key 
	 * @param idCategoria
	 * @param idSottocategoria
	 * @return the bean found or null if not found 
	 */
	public SipraMtdRCategSottocateg findByPK(Integer idCategoria, Integer idSottocategoria);

	public List<SipraMtdRCategSottocateg> findAll();
	
	public List<SipraMtdRCategSottocateg> findByCriteria(java.util.Map<String, Object> params);
	public List<SipraMtdRCategSottocateg> findByCriteria(MapSqlParameterSource params);
	
	public <V> List<V> findByGenericCriteria(String query, RowMapper<V>  rowMapper, Map<String, Object> params);
	public <V> List<V> findByGenericCriteria(String query, RowMapper<V>  rowMapper, MapSqlParameterSource params);
	public List<SipraMtdRCategSottocateg> findByGenericCriteria(String query, MapSqlParameterSource params);
	
	public void insert(SipraMtdRCategSottocateg bean);

	public void update(SipraMtdRCategSottocateg bean);
	
	public void update(String sql, Map<String, Object> param);

	public int deleteByPK(Integer idCategoria, Integer idSottocategoria);
	
	public int delete(String query, Map<String, Object> params);
	public int delete(String query, MapSqlParameterSource params);

	public boolean exist(Map<String, Object> params);

    public RowMapper<SipraMtdRCategSottocateg> getRowMapper();
}