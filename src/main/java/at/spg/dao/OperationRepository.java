package at.spg.dao;

import java.util.List;
import at.spg.model.Operation;

public interface OperationRepository {
	
    public List<Operation> findAllOperatione();
    public List<Operation> findOperationeByDocId(long id);
    public List<Operation> findOperationeByPatientId(long id);
    public List<Operation> findOperationeByPatientIdOrDocId(long id);
    
}