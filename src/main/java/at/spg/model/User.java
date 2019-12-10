package at.spg.model;

public class User {
 
	private Long id;
	private String vorname;
    private String nachname;
    private String passwort;
    //private Rolle rolle;
    private String kuerzel;

    public User(Long id, String vorname, String nachname, String passwort, String kuerzel) {
        this.id = id;
        this.vorname = vorname;
        this.nachname = nachname;
        this.passwort = passwort;
        //this.rolle = rolle;
        this.kuerzel = kuerzel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPasswort() {
        return passwort;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }

    /*public Rolle getRolle() {
        return rolle;
    }

    public void setRolle(Rolle rolle) {
        this.rolle = rolle;
    }*/

    public String getKuerzel() {
        return kuerzel;
    }

    public void setKuerzel(String kuerzel) {
        this.kuerzel = kuerzel;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", kuerzel=" + kuerzel + ", nachname=" + nachname + ", passwort=" + passwort
                + ", vorname=" + vorname + "]";
    }


    
    
 
}
