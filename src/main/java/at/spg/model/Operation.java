package at.spg.model;

import java.sql.Date;
import java.time.LocalDateTime;

public class Operation {

	private String opsaal;
	private Date zeitpunkt;
	private String icd10;
	private Patient patient;	
	private User user;

	public Operation(String opsaal, Date zeitpunkt, String icd10, Patient patient, User user) {
		this.opsaal = opsaal;
		this.zeitpunkt = zeitpunkt;
		this.icd10 = icd10;
		this.patient = patient;
		this.user = user;
	}

	public Operation(Long t_id, Patient p, User us, LocalDateTime t_von, LocalDateTime t_bis, String t_anmerkung) {
	}

	public String getOpsaal() {
		return opsaal;
	}

	public void setOpsaal(String opsaal) {
		this.opsaal = opsaal;
	}

	public Date getZeitpunkt() {
		return zeitpunkt;
	}

	public void setZeitpunkt(Date zeitpunkt) {
		this.zeitpunkt = zeitpunkt;
	}

	public String getIcd10() {
		return icd10;
	}

	public void setIcd10(String icd10) {
		this.icd10 = icd10;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Operation [icd10=" + icd10 + ", opsaal=" + opsaal + ", patient=" + patient + ", user=" + user
				+ ", zeitpunkt=" + zeitpunkt + "]";
	}

	
}
