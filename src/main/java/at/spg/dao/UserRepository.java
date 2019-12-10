package at.spg.dao;

import at.spg.model.User;

public interface UserRepository {
	
    public User findUserById(Long u_id);
    public User findUserByName(String name);
}
