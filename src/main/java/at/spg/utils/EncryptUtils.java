package at.spg.utils;
 
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
 
public class EncryptUtils {
 
    public static String encrypt(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
  
}

