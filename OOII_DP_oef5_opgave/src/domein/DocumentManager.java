package domein;

public class DocumentManager {

    public void print(String filePath) {
    	
//        if (filePath.endsWith(".xls")) {
//            Spreadsheet spreadsheet = new Spreadsheet(filePath);
//            spreadsheet.print();
//        } else {
//            Presentation presentation = new Presentation(filePath);
//            presentation.print();
//        }
        
        DocumentFactory.createDocument(filePath).print();
    }

    public void preview(String filePath) {
//        if (filePath.endsWith(".xls")) {
//            Spreadsheet spreadsheet = new Spreadsheet(filePath);
//            spreadsheet.preview();
//        } else {
//            Presentation presentation = new Presentation(filePath);
//            presentation.preview();
//        }
    	DocumentFactory.createDocument(filePath).preview();
    }
}
