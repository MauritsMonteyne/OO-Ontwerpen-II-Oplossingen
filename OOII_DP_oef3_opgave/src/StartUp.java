
import domein.Bediende;
import domein.Manager;
import domein.Werknemer;

public class StartUp {

    public static void main(String... args) {
//        Werknemer werknemerJan = new Bediende("Wolfs", "Jan", "3/5/1980", 2000.00);
    	Werknemer werknemerJan = new Werknemer("Wolfs", "Jan", "3/5/1980");
    	werknemerJan.setStatuut(new Bediende(2000.00));

        System.out.println(werknemerJan.geefJaarInkomst());
        
        // promotie: 
//        werknemerJan = new Manager("Wolfs", "Jan", "3/5/1980", 3000.00, 500.50);
        werknemerJan.setStatuut(new Manager(3000.00, 500.50));
        System.out.println(werknemerJan.geefJaarInkomst());
    }
}
