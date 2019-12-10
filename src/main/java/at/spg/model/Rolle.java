package at.spg.model;

public class Rolle {

	private String kuerzel;
	private String bezeichnung;

	public Rolle(String kuerzel, String bezeichnung) {
		this.kuerzel = kuerzel;
		this.bezeichnung = bezeichnung;
	}

	public String getKuerzel() {
		return kuerzel;
	}

	public void setKuerzel(String kuerzel) {
		this.kuerzel = kuerzel;
	}

	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	@Override
	public String toString() {
		return "Rolle [bezeichnung=" + bezeichnung + ", kuerzel=" + kuerzel + "]";
	}
	
}
