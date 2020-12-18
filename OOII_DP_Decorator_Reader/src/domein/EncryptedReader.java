package domein;

public class EncryptedReader extends ReaderDecorator {

	public EncryptedReader(Reader reader) {
		super(reader);
	}

	public String read() {
		return String.format("encrypted %s", reader.read());
	}
}
