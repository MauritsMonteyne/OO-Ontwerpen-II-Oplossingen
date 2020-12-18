import domain.FileEditor;
import java.io.File;

public class StartUp {

    public static void main(String... args) {
        FileEditor file = new FileEditor(new File("opgave")); //clean

        //clean -> dirty 
        boolean uitgevoerd = file.edit();
        System.out.println("true = " + uitgevoerd);

        //dirty -> clean
        uitgevoerd = file.save();
        System.out.println("true = " + uitgevoerd);

        uitgevoerd = file.save();
        System.out.println("false = " + uitgevoerd);

        //clean -> dirty
        uitgevoerd = file.edit();
        System.out.println("true = " + uitgevoerd);

        uitgevoerd = file.edit();
        System.out.println("false = " + uitgevoerd);
        //dirty -> clean
        uitgevoerd = file.save();
        System.out.println("true = "+ uitgevoerd);
    }
}