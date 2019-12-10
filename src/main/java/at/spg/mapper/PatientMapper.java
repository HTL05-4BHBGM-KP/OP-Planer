package at.spg.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import at.spg.model.Patient;

public class PatientMapper implements RowMapper<Patient> {
	 
    public static final String SELECT_SQL //
            = "SELECT * FROM p_patient";


    public Patient mapRow(ResultSet rs, int rowNum) throws SQLException {
 
        Long p_svnr = rs.getLong("p_svnr");
        String p_vorname = rs.getString("p_vorname");
        String p_nachname = rs.getString("p_nachname");
 
        return new Patient(p_svnr, p_vorname, p_nachname);

    } 
	    
}
