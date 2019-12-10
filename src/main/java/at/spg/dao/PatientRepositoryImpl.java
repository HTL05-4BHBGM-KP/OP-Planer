package at.spg.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import at.spg.mapper.PatientMapper;
import at.spg.model.Patient;

@Repository
public class PatientRepositoryImpl implements PatientRepository {

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Override
	public Patient findPatientById(long id) {
	    String sql = PatientMapper.SELECT_SQL + " WHERE p_svnr = ?";
	    Object[] params = new Object[] { id };
	    PatientMapper mapper = new PatientMapper();
	    try {
			Patient patient = jdbcTemplate.queryForObject(sql, params, mapper);
			System.out.println(patient);
	        return patient;
	    } catch (EmptyResultDataAccessException e) {
	        return null;
	    }
	}

	@Override
	public List<Patient> findAllPatients() {
		String sql = PatientMapper.SELECT_SQL;
		List<Patient> patients = jdbcTemplate.query(sql, new PatientMapper());	
		return patients;
	}

}