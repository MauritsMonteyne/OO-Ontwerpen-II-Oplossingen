import domein.DocumentManager;

public class StartUp {
    
        public static void main(String... args) {
        DocumentManager manager = new DocumentManager();
        manager.print("document.xls");
        manager.print("document.bestaatNiet");
    }

}
