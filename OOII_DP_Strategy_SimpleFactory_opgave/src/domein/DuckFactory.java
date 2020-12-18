package domein;

public class DuckFactory {

    
/*
        new RedheadDuck(new Quack(), new FlyWithWings());
        

        new MallardDuck(new Quack(), new FlyWithWings());
        

        new RubberDuck(new Squeak(), new FlyNoWay());
        

        new DecoyDuck(new MuteQuack(), new FlyNoWay());
  
 */   
	
	public Duck createDuck(DuckSpecies species) {
		
		return switch (species) {
			case REDHEAD -> new RedheadDuck(new Quack(), new FlyWithWings());
			
			case MALLARD -> new MallardDuck(new Quack(), new FlyWithWings());
			
			case RUBBER -> new RubberDuck(new Squeak(), new FlyNoWay());
			
			case DECOY -> new DecoyDuck(new MuteQuack(), new FlyNoWay());
		
			default -> null;
		};
	}
        
    
}
