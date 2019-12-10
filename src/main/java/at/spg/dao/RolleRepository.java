package at.spg.dao;

import java.util.List;
import at.spg.model.Rolle;

public interface RolleRepository {
	
    public Rolle findRolleById(String kuerzel);
    public List<Rolle> findAllRolles();
    
}