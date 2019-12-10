package at.spg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OP_Planer {

	 private static Logger logger = LoggerFactory.getLogger(OP_Planer.class);

	 public static void main(String[] args) {
		
		 SpringApplication.run(OP_Planer.class, args);
		
		 String password = "geheim";
	     logger.info("Hash für '" + password + "': " + at.spg.utils.EncryptUtils.encrypt(password));
	}

}
