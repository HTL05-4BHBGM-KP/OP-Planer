package at.spg.controller;

import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import at.spg.dao.OperationRepository;
import at.spg.dao.PatientRepository;
import at.spg.dao.RolleRepository;
import at.spg.dao.UserRepository;
import at.spg.model.Rolle;
import at.spg.model.Patient;
import at.spg.model.Operation;
import at.spg.model.User;

@Controller
public class MainController {

	@Autowired
	private PatientRepository patientRepository;

	@Autowired
	private RolleRepository rolleRepository;

	@Autowired
	private OperationRepository operationRepository;

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/")
    public String index() {
		return "index";
    }
	
	@GetMapping("/login")
    public String login() {
		return "login";
	}
	

	@GetMapping("/patient/{id}")
    public String patient(Model model, @PathVariable(value = "id", required = true) Long id) {
	    Patient patient = patientRepository.findPatientById(id);
	    model.addAttribute("pat", patient);    
		return "patient";
    }	

	@GetMapping("/rolle/{id}")
    public String doctor(Model model, @PathVariable(value = "id", required = true) String id) {
	    Rolle rolle = rolleRepository.findRolleById(id);
	    model.addAttribute("rol", rolle);    
		return "rolle";
    }		
	
	@GetMapping("/patients")
	public String patients(Model model) {
		List<Patient> list = patientRepository.findAllPatients();
	    model.addAttribute("pats", list);  
		return "patients";
	}

	@GetMapping("/rollen")
	public String doctors(Model model) {
	    List<Rolle> list = rolleRepository.findAllRolles();
	    model.addAttribute("rol", list);  
		return "rollen";
	}	

	@GetMapping("/operationen")
	public String termine(Model model) {
	    List<Operation> operationen = operationRepository.findAllOperatione();
	    model.addAttribute("operationen", operationen);  
		return "operationen";
	}	

	@GetMapping("/meine_operationen")
	public String meine_termine(Model model, Principal principal) {
        String userName = principal.getName(); 
        User user = userRepository.findUserByName(userName);
        Long id = Long.valueOf(user.getKuerzel());
	    List<Operation> operationen = operationRepository.findOperationeByPatientIdOrDocId(id);
        model.addAttribute("user", user);    
	    model.addAttribute("termine", operationen);  
		return "meine_operationen";
	}	

	@GetMapping("/termine/arzt/{id}")
	public String termine_arzt(Model model, @PathVariable(value = "id", required = true) Long id) {
		User user = userRepository.findUserById(id);
	    List<Operation> operationen = operationRepository.findOperationeByDocId(id);
	    model.addAttribute("arzt", user);  
	    model.addAttribute("ter", operationen);  
		return "arzt_termine";
	}	

	@GetMapping("/termine/patient/{id}")
	public String termine_patient(Model model, @PathVariable(value = "id", required = true) Long id) {
		Patient patient = patientRepository.findPatientById(id);
		List<Operation> operationen = operationRepository.findOperationeByPatientId(id);
		System.out.println("----- Operation ------");
		System.out.println(operationen);
	    model.addAttribute("pat", patient);  
	    model.addAttribute("ter", operationen);  
		return "patient_termine";
	}	

	@GetMapping("/admin")
    public String admin() {
		return "admin";
    }

	@GetMapping("/home")
    public String home(Model model, Principal principal) {
        //String userName = principal.getName(); 
        //User user = userRepository.findUserByName(userName);
        //model.addAttribute("user", user);    
		return "home";
    }

}