package at.spg.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import at.spg.dao.UserRepositoryImpl;
import at.spg.model.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
 
    @Autowired
    private UserRepositoryImpl userRepository;
 
    public UserDetails loadUserByUsername(String kuerzel) throws UsernameNotFoundException {
    	
    	User user = this.userRepository.findUserByName(kuerzel);
 
        if (user == null) {
            throw new UsernameNotFoundException("User with name " +  kuerzel + " was not found in the database");
        }
 
        List<String> roleNames = new ArrayList<String>();
        roleNames.add("SOME_ROLE");
        roleNames.add("ANOTHER_ROLE");
        
        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        if (roleNames != null) {
            for (String role : roleNames) {
                GrantedAuthority authority = new SimpleGrantedAuthority(role);
                grantList.add(authority);
            }
        }
 
        UserDetails userDetails = (UserDetails) new org.springframework.security.core.userdetails.User(user.getKuerzel(),
                user.getPasswort(), grantList);
        
      
        return userDetails;
    }
 
}