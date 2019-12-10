package at.spg.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import at.spg.model.Rolle;

public class RolleMapper implements RowMapper<Rolle> {
	 
    public static final String SELECT_SQL //
            = "SELECT * FROM r_rollen";


    public Rolle mapRow(ResultSet rs, int rowNum) throws SQLException {
 
        String r_kuerzel = rs.getString("r_kuerzel");
        String r_bezeichnung = rs.getString("r_bezeichnung");
 
        return new Rolle(r_kuerzel, r_bezeichnung);
    } 
	    
}
