package domein;

import java.util.HashSet;
import java.util.Set;

public class ObservableString implements Subject

{
    private String theString;
    private final Soort soort;
    private Set<Observer> observers;

    public ObservableString(Soort soort) {
    	observers = new HashSet<>();
    	
    	setTheString("");
        this.soort = soort;
    }

    public String getTheString() {
        return theString;
    }

    public void setTheString(String theString) {
        this.theString = theString;
        notifyObservers();
    }

	@Override
	public void addObserver(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		observers.add(observer);
	}
	
    private void notifyObservers() {
        observers.forEach((observer) -> observer.update(soort));
    }
}
