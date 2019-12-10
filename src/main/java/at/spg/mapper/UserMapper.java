package at.spg.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

//import at.spg.dao.RolleRepository;
//import at.spg.model.Rolle;
import at.spg.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
 
public class UserMapper implements RowMapper<User> {

    @Autowired
    //private RolleRepository rolerepository;
 
    public static final String SELECT_SQL //
            = "SELECT * FROM u_user";

    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
 
        Long u_id = rs.getLong("u_id");
        String u_vorname = rs.getString("u_vorname");
        String u_nachname = rs.getString("u_nachanme");
        String u_passwort = rs.getString("u_passwort");
        String u_kuerzel = rs.getString("u_kuerzel");
        //String r_id = rs.getString("u_user_rolle");
        
        //Rolle rolle = rolerepository.findRolleById(r_id);

 
        return new User(u_id, u_vorname, u_nachname, u_passwort, u_kuerzel);
    } 
    
}