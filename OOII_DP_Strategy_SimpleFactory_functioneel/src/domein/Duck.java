package domein;

public /*abstract*/ class Duck {

	
    private QuackBehavior quackBehavior;
    private FlyBehavior flyBehavior;
    private final DisplayMethod displayMethod;
    
    
    public Duck(QuackBehavior quackBehavior, FlyBehavior flyBehavior, DisplayMethod displayMethod) {
    	this.displayMethod = displayMethod;
        setQuackBehavior(quackBehavior);
        setFlyBehavior(flyBehavior);
    }
    
    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }
    
    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }
    
    public String performQuack() {
        return quackBehavior.quack();
    }
    
    public String performFly() {
        return flyBehavior.fly();
    }
    
    public String swim() {
        return ("Alle eenden drijven, ook lokeenden");
    }
    
    //public abstract String display();
    
    public String display() {
		return displayMethod.display();
	}
    
    public void ANDERE_eend_achtige_methoden() {
    }
    
}
