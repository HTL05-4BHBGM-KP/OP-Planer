package at.spg.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import at.spg.mapper.RolleMapper;
import at.spg.model.Rolle;

@Repository
public class RolleRepositoryImpl implements RolleRepository {

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Override
	public Rolle findRolleById(String kuerzel) {
	    String sql = RolleMapper.SELECT_SQL + " WHERE r_kuerzel = ? "; 
	    Object[] params = new Object[] { kuerzel };
	    RolleMapper mapper = new RolleMapper();
	    try {
	        Rolle rolle = jdbcTemplate.queryForObject(sql, params, mapper);
	        return rolle;
	    } catch (EmptyResultDataAccessException e) {
	        return null;
	    }
	}

	@Override
	public List<Rolle> findAllRolles() {
		String sql = RolleMapper.SELECT_SQL;
		List<Rolle> rollen = jdbcTemplate.query(sql, new RolleMapper());	
		return rollen;
	}

}