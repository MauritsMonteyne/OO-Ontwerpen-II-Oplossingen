package oefening7;

public class Calculator {

	private Computation computation;
	
	public int compute(int x, int y) {
		return computation.compute(x, y);
	}

	public void setComputation(Computation computation) {
		this.computation = computation;
	}
}
