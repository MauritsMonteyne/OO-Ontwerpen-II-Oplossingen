package domein;

class PrintingState extends PrinterState {

	public PrintingState(Printer printer) {
		super(printer);
	}
	
	public String handle() {
		PrinterState state = new EndState(printer);
		printer.toState(state);
		return "Bezig met printen: " + printer.getDocumentToPrint() + "\n" + state.handle();
	}

	public String cancel() {
		PrinterState state = new EndState(printer);
		printer.toState(state);
		return "Printen wordt beëindigd\n" + state.handle();
	}

}
