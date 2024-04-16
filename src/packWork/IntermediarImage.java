//Pachetul curent
package packWork;

//Importuri de functii
import java.io.IOException;

public class IntermediarImage extends Imagine {
	
	//Clasa menita sa implementeze Thread. Aici se face producerul care primeste poze 
	//si o trimite mai departe la consumner in AplicaTrasformare
	
	public IntermediarImage(String path) throws IOException {
		super(path);
	}

	@Override
	public void exportImagine() throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void executeTransform() throws IOException {
		// TODO Auto-generated method stub
		
	}

}
