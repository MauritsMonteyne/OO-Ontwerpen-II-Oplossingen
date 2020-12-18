package domein;

public class NoDocument extends Document {

    public NoDocument(String filePath) {
        super(filePath);
    }

	@Override
	public void preview() {
		// Preview
	}

	@Override
	public void print() {
		// Print
	}

	@Override
	public void loadFromFile(String filePath) {
		// LoadFromFile
	}
}
