package domein;

public class Werknemer {
    
    private final String voornaam;
    private final String familienaam;
    private final String geboorteDatum;
    private Statuut statuut;

    public Werknemer(String voornaam, String familienaam, String geboorteDatum) {
        this.voornaam = voornaam;
        this.familienaam = familienaam;
        this.geboorteDatum = geboorteDatum;
    }
    
    public void setStatuut(Statuut statuut) {
		this.statuut = statuut;
	}
    
    public double geefJaarInkomst() {
    	return statuut.geefJaarInkomst();
    }
}
