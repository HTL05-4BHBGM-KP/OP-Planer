package at.spg.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import at.spg.mapper.OperationMapper;
import at.spg.model.Operation;

@Repository
public class OperationRepositoryImpl implements OperationRepository {

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Operation> findAllOperatione() {
		String sql = OperationMapper.SELECT_SQL;
		List<Operation> operationen = jdbcTemplate.query(sql, new OperationMapper());	
		return operationen;
	}

	@Override
	public List<Operation> findOperationeByDocId(long id) {
		String sql = OperationMapper.SELECT_SQL + " WHERE op_operation_user = " + id;
		List<Operation> operationen = jdbcTemplate.query(sql, new OperationMapper());	
		return operationen;
	}

	@Override
	public List<Operation> findOperationeByPatientId(long id) {
		String sql = OperationMapper.SELECT_SQL + " WHERE op_operation_patient = " + id;
		List<Operation> operationen = jdbcTemplate.query(sql, new OperationMapper());	
		return operationen;
	}

	@Override
	public List<Operation> findOperationeByPatientIdOrDocId(long id) {
		String sql = OperationMapper.SELECT_SQL + " WHERE (op_operation_patient = " + id + " OR op_operation_user = " + id + ")";
		List<Operation> operationen = jdbcTemplate.query(sql, new OperationMapper());	
		return operationen;
	}

}