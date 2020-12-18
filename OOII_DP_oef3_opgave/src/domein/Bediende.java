package domein;

public class Bediende implements Statuut {
    
    private double maandwedde;

//    public Bediende(String voornaam, String familienaam, String geboorteDatum, double maandwedde) {
//        super(voornaam, familienaam, geboorteDatum);
//        this.maandwedde = maandwedde;
//    }
    
    public Bediende(double maandwedde) {
        this.maandwedde = maandwedde;
    }
    
    @Override
    public double geefJaarInkomst() {
        return maandwedde*12;
    }

    
    
    
}
