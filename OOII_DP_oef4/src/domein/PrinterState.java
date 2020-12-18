package domein;

abstract class PrinterState {

	protected final Printer printer;
	
	public PrinterState(Printer printer) {
		this.printer = printer;
	}

	public String handle() {
		return "Can't handle operation";
	}

	public String print() {
		return "Can't print document";
	}

	public String cancel() {
		return "Can't cancel operation";
	}
}
