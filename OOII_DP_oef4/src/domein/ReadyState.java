package domein;

class ReadyState extends PrinterState {

	
	public ReadyState(Printer printer) {
		super(printer);
	}
	
	
	public String print() {
		PrinterState state = new StartState(printer);
		printer.toState(state);
		return "Printer is ready\n" + state.handle();
	}
}
