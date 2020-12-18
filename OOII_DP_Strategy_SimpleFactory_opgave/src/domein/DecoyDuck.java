package domein;

public class DecoyDuck extends Duck {

    public DecoyDuck(QuackBehavior quackBehavior, FlyBehavior flyBehavior) {
/*
    	setQuackBehavior(new MuteQuack());
        setFlyBehavior(new FlyNoWay());
*/    	
    	super(quackBehavior, flyBehavior);    	
    	
    }
    

    @Override
    public String display() {
        return "Ik ben een lokeend";
    }

}
