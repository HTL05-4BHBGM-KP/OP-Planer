package at.spg.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@Component
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {

        logger.info("Login fehlgeschlagen - Email: " + httpServletRequest.getParameter("email") +
        		    ", Passwort: " + httpServletRequest.getParameter("password") + 
        		    ", IP Adresse: " + httpServletRequest.getRemoteAddr());
   
        httpServletResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
        httpServletResponse.sendRedirect("/login?error=true");     
    }
}
