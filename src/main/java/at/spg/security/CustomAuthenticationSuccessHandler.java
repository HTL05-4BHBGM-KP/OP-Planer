package at.spg.security;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
	 
  private Logger logger = LoggerFactory.getLogger(this.getClass());
  
  @Override
  public void onAuthenticationSuccess(HttpServletRequest request,
      HttpServletResponse response, Authentication authentication)
      throws IOException, ServletException {

        logger.info("Erfolgreicher Login - Benutzername: " + authentication.getName() + 
        		    ", IP Adresse: " + request.getRemoteAddr());
        
        response.setStatus(HttpServletResponse.SC_OK);      
        response.sendRedirect("/home");
    }      
  }