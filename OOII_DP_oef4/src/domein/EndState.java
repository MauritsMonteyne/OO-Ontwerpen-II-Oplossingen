package domein;

class EndState extends PrinterState {

	public EndState(Printer printer) {
		super(printer);
	}
	
	public String handle() {
		PrinterState state = new ReadyState(printer);
		printer.toState(state);
		return "Printen is beëindigd";
	}
}
