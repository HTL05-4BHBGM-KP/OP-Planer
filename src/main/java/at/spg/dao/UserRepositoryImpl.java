package at.spg.dao;

import at.spg.mapper.UserMapper;
import at.spg.model.User;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
 
@Repository
@Transactional
public class UserRepositoryImpl extends JdbcDaoSupport implements UserRepository {

	@Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRepositoryImpl(DataSource dataSource) {
        this.setDataSource(dataSource);
    }

	@Override
    public User findUserById(Long id) {
        String sql = UserMapper.SELECT_SQL + " WHERE u_id = ?";
        Object[] params = new Object[] { id };
        UserMapper mapper = new UserMapper();
        try {
            User user = jdbcTemplate.queryForObject(sql, params, mapper);
            return user;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

	@Override
	public User findUserByName(String name) {

        String sql = UserMapper.SELECT_SQL + " WHERE u_kuerzel = ? "; 
        Object[] params = new Object[] { name };
        UserMapper mapper = new UserMapper();
        try {
            User user = jdbcTemplate.queryForObject(sql, params, mapper);
            return user;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
	}
   
}
