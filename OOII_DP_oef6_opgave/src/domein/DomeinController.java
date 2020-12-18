package domein;

public class DomeinController //FACADE
{
    private ObservableString observableBedrijfId;
    private ObservableString observableStageId;

    public DomeinController() {   	
        observableStageId = new ObservableString(Soort.STAGE);
        observableBedrijfId = new ObservableString(Soort.BEDRIJF);
    }

    public String getBedrijfId() {
        return observableBedrijfId.getTheString();
    }

    public String getStageId() {
        return observableStageId.getTheString();
    }

    public void setBedrijfId(String bedrijfId) {
        observableBedrijfId.setTheString(bedrijfId);
    }

    public void setStageId(String stageId) {
        observableStageId.setTheString(stageId);
    }

	public void addObserver(Soort soort, Observer observer) {
		switch (soort) {
			case BEDRIJF -> observableBedrijfId.addObserver(observer);
			case STAGE -> observableStageId.addObserver(observer);
		}
	}
	
	public void removeObserver(Soort soort, Observer observer) {
		switch (soort) {
			case BEDRIJF -> observableBedrijfId.removeObserver(observer);
			case STAGE -> observableStageId.removeObserver(observer);
		}
	}
}
