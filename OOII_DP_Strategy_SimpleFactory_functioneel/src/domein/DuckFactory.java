package domein;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import static domein.DuckSpecies.*;

public class DuckFactory {

	private final Map<DuckSpecies, Supplier<Duck>> factory = new HashMap<>();
	
	
	public DuckFactory() {
		add(REDHEAD, () -> new Duck(
				new Quack(),
				new FlyWithWings(), 
				() -> "Ik lijk op een roodkuifeend"));
		
		add(MALLARD, () -> new Duck(
				new Quack(), 
				new FlyWithWings(), 
				() -> "Ik ben een echte wilde eend"));
		
		add(RUBBER, () -> new Duck(
				new Squeak(), 
				new FlyNoWay(),
				() -> "Ik ben een badeend"));
		
		add(DECOY, () -> new Duck(
				new MuteQuack(), 
				new FlyNoWay(),
				() -> "Ik ben een lokeend"));
	}
	
	
	public final void add(DuckSpecies specie, Supplier<Duck> supplier) {
		factory.put(specie, supplier);
	}
	
    public Duck createDuck(DuckSpecies specie) {
    	
    	Supplier<Duck> supplier = factory.get(specie);
    	return supplier != null ? supplier.get() : null;
    	/*
        return switch (specie) {
            case REDHEAD ->
                 new RedheadDuck(new Quack(), new FlyWithWings());
            case MALLARD ->
                 new MallardDuck(new Quack(), new FlyWithWings());
            case RUBBER ->
                 new RubberDuck(new Squeak(), new FlyNoWay());
            case DECOY ->
                 new DecoyDuck(new MuteQuack(), new FlyNoWay());
            default ->
                 null;
        };
        */
    }
}
