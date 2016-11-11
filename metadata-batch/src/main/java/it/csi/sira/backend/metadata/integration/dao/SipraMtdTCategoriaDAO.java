/*
 * Created on 8 nov 2016 ( Time 16:16:33 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package it.csi.sira.backend.metadata.integration.dao;

import it.csi.sira.backend.metadata.integration.dto.SipraMtdTCategoria;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;




/**
 * SipraMtdTCategoria DAO interface
 * 
 * @author Telosys Tools
 */
public interface SipraMtdTCategoriaDAO {

	//----------------------------------------------------------------------
	/**
	 * Finds a bean by its primary key 
	 * @param idCategoria
	 * @return the bean found or null if not found 
	 */
	public SipraMtdTCategoria findByPK(Integer idCategoria);

	public List<SipraMtdTCategoria> findAll();
	
	public List<SipraMtdTCategoria> findByCriteria(java.util.Map<String, Object> params);
	public List<SipraMtdTCategoria> findByCriteria(MapSqlParameterSource params);
	
	public <V> List<V> findByGenericCriteria(String query, RowMapper<V>  rowMapper, Map<String, Object> params);
	public <V> List<V> findByGenericCriteria(String query, RowMapper<V>  rowMapper, MapSqlParameterSource params);
	public List<SipraMtdTCategoria> findByGenericCriteria(String query, MapSqlParameterSource params);
	
	public void insert(SipraMtdTCategoria bean);

	public void update(SipraMtdTCategoria bean);
	
	public void update(String sql, Map<String, Object> param);

	public int deleteByPK(Integer idCategoria);
	
	public int delete(String query, Map<String, Object> params);
	public int delete(String query, MapSqlParameterSource params);

	public boolean exist(Map<String, Object> params);

    public RowMapper<SipraMtdTCategoria> getRowMapper();
}
