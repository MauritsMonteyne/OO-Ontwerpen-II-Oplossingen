import domein.Printer;

public class StartUp {

	public static void main(String[] args) {

		Printer printer = new Printer();
		System.out.println(printer.print("document"));
		System.out.println(printer.print("document2"));

	}

}
