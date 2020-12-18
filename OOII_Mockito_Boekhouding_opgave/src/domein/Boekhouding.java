package domein;

import static domein.InitBoekHouding.*; 

public class Boekhouding {
  
	
	// 1. Attribuut toevoegen
	private FactuurMap factuurMap;
	
	
	// 2. Echte code toevoegen
	public Boekhouding() {
		this(new FactuurMap());
	}
	
	// 3. Constructor injectie
	public Boekhouding(FactuurMap factuurMap) {
		this.factuurMap = factuurMap;
	}
   
    public Aangifte genereerAangifte(String ondernemingsNummer) {
    	// Exceptions splitsen is puur voor de UX, kan perfect in 1 'if'
        if (ondernemingsNummer == null || ondernemingsNummer.isBlank()) {
            throw new IllegalArgumentException("Ondernemingsnummer verplicht in te vullen");
        }
        
        if (ondernemingsNummer == null || !ondernemingsNummer.matches("BE\\d{10}")) {
            throw new IllegalArgumentException("Verkeerd formaat ondernemingsnummer");
        }

        // 4. Oude code schrappen
        // FactuurMap factuurMap = new FactuurMap();

        double[] factuurOverzicht = factuurMap.geefBedragen(ondernemingsNummer);

        return new Aangifte(berekenBelastingSchaal(factuurOverzicht), factuurOverzicht);
    }

    /*Op basis van de som van alle bedragen:
    [0, 200,0[ => BELASTINGSCHAAL_0
    200,0 of hoger => BELASTINGSCHAAL_1
     */
    private double berekenBelastingSchaal(double[] factuurOverzicht) {

        double totaalBedrag = 0;
        for (double bedrag : factuurOverzicht) {
            totaalBedrag += bedrag;
        }

        if (totaalBedrag < 200.0) {
            return BELASTINGSCHAAL_0;
        }
        return BELASTINGSCHAAL_1;
    }
}
