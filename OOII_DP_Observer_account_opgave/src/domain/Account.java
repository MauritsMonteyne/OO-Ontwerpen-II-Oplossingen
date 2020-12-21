package domain;

import java.util.HashSet;
import java.util.Set;

public class Account implements Subject {

    // Account balance
    private double balance;

    // readonly Account name
    private String name;

    
    private Set<Observer> observers;
    
    
    // Account constructor
    public Account(String accountName, double openingDeposit) {
    	observers = new HashSet<>();
    	
        name = accountName;
        setBalance(openingDeposit);
        
    }

    // set Account balance and notify observers of change
    private void setBalance(double accountBalance) {
        balance = accountBalance;
        notifyObservers();
    }

    // get Account balance
    public double getBalance() {
        return balance;
    }

    // withdraw funds from Account
    public void withdraw(double amount) throws IllegalArgumentException {
        if (amount < 0) {
            throw new IllegalArgumentException(
                    "Cannot withdraw negative amount");
        }

        // update Account balance
        setBalance(getBalance() - amount);
    }

    // deposit funds in account
    public void deposit(double amount) throws IllegalArgumentException {
        if (amount < 0) {
            throw new IllegalArgumentException("Cannot deposit negative amount");
        }

        // update Account balance
        setBalance(getBalance() + amount);
    }

    // get Account name (readonly)
    public String getName() {
        return name;
    }

    
    
	@Override
	public void addObserver(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}
	
    private void notifyObservers() {
    	observers.forEach((observer) -> observer.update(balance));
    }
}
