package domein;

public class Printer {

	private String documentToPrint;
	private PrinterState currentState;

	public Printer() {
		toState(new ReadyState(this));
	}

	public String print(String document) {
		documentToPrint = document;
		return currentState.print();
	}

	public String cancel() {
		return currentState.cancel();
	}
	
	protected void toState(PrinterState state) {
		this.currentState = state;
	}
	
	protected String getDocumentToPrint() {
		return this.documentToPrint;
	}
}
