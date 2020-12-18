import domein.Reader;
import domein.FileReader;
import domein.ZipReader;
import domein.EncryptedReader;

public class Startup {

	
	
	public static void main(String[] args) {
		
		// Zip file "tekst.txt"
		Reader zip = new ZipReader(new FileReader("tekst.txt"));
		System.out.println(zip.read());
		
		// Encrypt file
		Reader enc = new EncryptedReader(new FileReader("tekst.txt"));
		System.out.println(enc.read());
		
		// Encrypt zip file
		Reader encZip = new EncryptedReader(new ZipReader(new FileReader("tekst.txt")));
		System.out.println(encZip.read());
		
		// Encrypt file, zip file and encrypt the zip file
		Reader encZipEnc = new EncryptedReader(new ZipReader(new EncryptedReader(new FileReader("tekst.txt"))));
		System.out.println(encZipEnc.read());
	}
}
