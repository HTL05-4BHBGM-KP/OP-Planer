package at.spg.mapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import at.spg.model.User;
import at.spg.model.Patient;
import at.spg.model.Rolle;
import at.spg.dao.PatientRepository;
import at.spg.dao.UserRepository;
import at.spg.model.Operation;

public class OperationMapper implements RowMapper<Operation> {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PatientRepository patientRepository;
                    
    public static final String SELECT_SQL //
    = "SELECT * FROM op_operation inner join p_patient on p_svnr = op_operation_patient inner join u_user on u_id = op_operation_user inner join r_rollen on r_kuerzel = u_user_rolle";


    public Operation mapRow(ResultSet rs, int rowNum) throws SQLException {
 
        String op_saal = rs.getString("op_opsaal");
        Date op_zeitpunkt = rs.getDate("op_zeitpunkt");
        String op_icd10 = rs.getString("op_icd10");

        Long p_svnr = rs.getLong("p_svnr");
        String p_vorname = rs.getString("p_vorname");
        String p_nachname = rs.getString("p_nachname");

        Long u_id = rs.getLong("u_id");
        String u_vorname = rs.getString("u_vorname");
        String u_nachname = rs.getString("u_nachanme");
        String u_passwort = rs.getString("u_passwort");
        String u_kuerzel = rs.getString("u_kuerzel");
        String r_kuerzel = rs.getString("u_user_rolle");
        String r_bezeichnung = rs.getString("r_bezeichnung");
        
        Rolle rolle = new Rolle(r_kuerzel, r_bezeichnung);
        User us = new User(u_id, u_vorname, u_nachname, u_passwort, u_kuerzel, rolle);
        
        Patient p = new Patient(p_svnr, p_vorname, p_nachname);

		//System.out.println(new Operation(op_saal, op_zeitpunkt, op_icd10, p, us));
 
        return new Operation(op_saal, op_zeitpunkt, op_icd10, p, us);
    } 
 
}