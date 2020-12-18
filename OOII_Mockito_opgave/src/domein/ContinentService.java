package domein;

import persistentie.PersistentieController;

public class ContinentService {

	
	private static final int PER_1000_INWONERS = 1000;
	// 1. Attribuut toevoegen
	private PersistentieController persistentieController;
	
	
	// 2. Echte code toevoegen
	public ContinentService() {
		this(new PersistentieController());
	}
	
	// 3. Constructor injectie
	public ContinentService(PersistentieController persistentieController) {
		this.persistentieController = persistentieController;
	}
	

	public double geefGeboorteOverschot(String continent) {
		
		if (continent == null || continent.isBlank()) {
			throw new IllegalArgumentException("continent moet ingevuld zijn");
		}
		
		// 4. Oude code schrappen
		// PersistentieController persistentieController = new PersistentieController();
		long aantalInwoners = persistentieController.findAantalBewoners(continent);
		
		if (aantalInwoners <= 0) {
			throw new IllegalArgumentException("geen inwoners gevonden voor gegeven continent");
		}

		long aantalSterfgevallen = persistentieController.findSterfteCijfer(continent);
		long aantalGeboorten = persistentieController.findGeboortecijfers(continent);
		
		if (aantalSterfgevallen < 0 || aantalGeboorten < 0) {
			throw new IllegalArgumentException("We beschikken niet over correcte gegevens, Geboorteoverschot kan niet worden berkend");
		}

		double geboortecijfer = (double) aantalGeboorten / aantalInwoners * PER_1000_INWONERS;
		double sterftecijfer = (double) aantalSterfgevallen / aantalInwoners * PER_1000_INWONERS;

		return geboortecijfer - sterftecijfer;
	}
}
