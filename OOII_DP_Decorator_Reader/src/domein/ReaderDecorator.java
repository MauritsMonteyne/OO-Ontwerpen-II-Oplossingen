package domein;

public abstract class ReaderDecorator implements Reader {

	protected final Reader reader;
	
	/* OF private final Reader reader;
	 * protected Reader getReader() {
	 * 	return reader;
	 * }
	 * */
	
	public ReaderDecorator(Reader reader) {
		this.reader = reader;
	}
}
