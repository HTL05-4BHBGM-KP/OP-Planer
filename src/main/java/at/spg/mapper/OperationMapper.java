package at.spg.mapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import at.spg.model.User;
import at.spg.model.Patient;
import at.spg.dao.PatientRepository;
import at.spg.dao.UserRepository;
import at.spg.model.Operation;

public class OperationMapper implements RowMapper<Operation> {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PatientRepository patientRepository;
                    
    public static final String SELECT_SQL //
    = "SELECT * FROM op_operation";


    public Operation mapRow(ResultSet rs, int rowNum) throws SQLException {
 
        String op_saal = rs.getString("op_opsaal");
        Date op_zeitpunkt = rs.getDate("op_zeitpunkt");
        String op_icd10 = rs.getString("op_icd10");
        Long op_operation_user = rs.getLong("op_operation_user");
        Long op_operation_patient = rs.getLong("op_operation_patient");
        
        Patient p = patientRepository.findPatientById(op_operation_patient);
        User us = userRepository.findUserById(op_operation_user);

		System.out.println(new Operation(op_saal, op_zeitpunkt, op_icd10, p, us));
 
        return new Operation(op_saal, op_zeitpunkt, op_icd10, p, us);
    } 
 
}