package domein;
public class ZipReader extends ReaderDecorator {

	public ZipReader(Reader reader) {
		super(reader);
	}

	public String read() {
		return String.format("zip %s", reader.read());
	}
}
