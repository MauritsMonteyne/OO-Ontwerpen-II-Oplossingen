package domein;

class StartState extends PrinterState {

	public StartState(Printer printer) {
		super(printer);
	}
	
	public String handle() {
		PrinterState state = new PrintingState(printer);
		printer.toState(state);
		return "Printen kan worden gestart\n" + state.handle();
	}

	public String cancel() {
		PrinterState state = new EndState(printer);
		printer.toState(state);
		return "Printen wordt beëindigd\n" + state.handle();
	}

}
