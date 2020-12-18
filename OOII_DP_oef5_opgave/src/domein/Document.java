package domein;

public abstract class Document {

    public Document(String filePath) {
        loadFromFile(filePath);
    }

    public abstract void preview();

    public abstract void print();

    public abstract void loadFromFile(String filePath);
}
