package domein;

public class DocumentFactory {
	
	
	public static Document createDocument(String filePath) {
        if (filePath.endsWith(".xls")) {
			return new Spreadsheet(filePath);
		}
        
        if (filePath.endsWith("ppt")) {
			return new Presentation(filePath);
		}
		return new NoDocument(filePath);
	}
}
