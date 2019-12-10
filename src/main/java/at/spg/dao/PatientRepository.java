package at.spg.dao;

import java.util.List;
import at.spg.model.Patient;

public interface PatientRepository {
	
    public Patient findPatientById(long id);
    public List<Patient> findAllPatients();
    
}