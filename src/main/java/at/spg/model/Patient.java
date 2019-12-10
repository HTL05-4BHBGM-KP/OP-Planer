package at.spg.model;

public class Patient {

	private long svnr;
	private String vorname;
	private String nachname;

	public Patient(long svnr, String vorname, String nachname) {
		this.svnr = svnr;
		this.vorname = vorname;
		this.nachname = nachname;
	}

	public long getSvnr() {
		return svnr;
	}

	public void setSvnr(long svnr) {
		this.svnr = svnr;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	@Override
	public String toString() {
		return "Patient [nachname=" + nachname + ", svnr=" + svnr + ", vorname=" + vorname + "]";
	}

	
	
}
