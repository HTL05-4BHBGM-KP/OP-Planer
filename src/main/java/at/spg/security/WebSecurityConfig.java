package at.spg.security;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import at.spg.service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter { 

    @Autowired
	CustomAuthenticationSuccessHandler authenticationSuccessHandler;
  
    @Autowired
    CustomAuthenticationFailureHandler authenticationFailureHandler;
    
    @Autowired
    CustomLogoutSuccessHandler logoutSuccessHandler; 

    @Autowired
    UserDetailsServiceImpl userDetailsService;
        
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }    

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception { 
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());     
    }  
    
	@Override
    protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable();

		// Authentifizierung für folgende Pages nicht erforderlich
		http.authorizeRequests().antMatchers("/").permitAll();
		http.authorizeRequests().antMatchers("/login").permitAll();
		http.authorizeRequests().antMatchers("/patients").permitAll();
		http.authorizeRequests().antMatchers("/patient/**").permitAll();
		http.authorizeRequests().antMatchers("/aerzte").permitAll();
		http.authorizeRequests().antMatchers("/arzt/**").permitAll();
		http.authorizeRequests().antMatchers("/termine").permitAll();
		http.authorizeRequests().antMatchers("/termine/arzt/**").permitAll();
		http.authorizeRequests().antMatchers("/termine/patient/**").permitAll();
		http.authorizeRequests().antMatchers("/assets/**").permitAll();

		// Sonst Authentifizierung
		http.authorizeRequests().anyRequest().authenticated();

	    // Konfiguration des Logins
        http.formLogin()
          .loginProcessingUrl("/j_spring_security_check")
          .loginPage("/login")
          .defaultSuccessUrl("/home")
          .successHandler(authenticationSuccessHandler)
          .failureHandler(authenticationFailureHandler)
          .usernameParameter("kuerzel")
          .passwordParameter("password");
        
        // Konfiguration des Logout
        http.logout()
          .logoutUrl("/perform_logout")
          .logoutSuccessUrl("/")
          .invalidateHttpSession(true)
          .deleteCookies("JSESSIONID")
          .logoutSuccessHandler(logoutSuccessHandler);
        
          
	} 
}
