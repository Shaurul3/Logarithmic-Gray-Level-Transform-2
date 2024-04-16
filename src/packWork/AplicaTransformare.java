//Pachetul curent
package packWork;

//Importuri de functii
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.ImageIO;

//Aplicam transformarea
public class AplicaTransformare extends Imagine implements Transformare {

	//Imaginea noua
	private BufferedImage imagineTransformata;
	//Informatia de la tastatura
	private Scanner scanner;

	//Mesajul ce se afiseaza la rularea clasei
	{
		System.out.println("Incepe transformarea!");
	}

	// Constructor care apeleaza constructorul superclasei (Imagine) cu calea data
	public AplicaTransformare(String path) throws IOException {
		super(path);
	}

	// Implementarea metodei exportImagine din interfata Transformare
	@Override
	public void exportImagine() throws IOException {
		scanner = new Scanner(System.in);

		// Input de la utilizator pentru numele fisierului de export
		System.out.println("Introduceti numele fisierului pentru export:");

		if (scanner.hasNextLine()) {  // Verifica daca mai exista inca o linie libera
			String numeFisier = scanner.nextLine();

			// Concatenarea numelui de fisier introdus cu extensia specifica BMP
			String caleFisier = numeFisier.endsWith(".bmp") ? numeFisier : numeFisier + ".bmp";

			// Exportarea imaginii transformate cu numele specificat
			ImageIO.write(imagineTransformata, "bmp", new File(caleFisier));

			System.out.println("Imagine exportata cu succes in " + caleFisier);
		} else {
			System.out.println("Nu s-a introdus niciun nume de fisier pentru export.");
		}
	}

	// Implementarea metodei aplicaTransformare din interfata Transformare
	@Override
	public void aplicaTransformare() {
		imagineTransformata = new BufferedImage(bufferedImage.getWidth(), bufferedImage.getHeight(), BufferedImage.TYPE_INT_RGB);

		for (int i = 0; i < bufferedImage.getHeight(); i++) { //Deplasarea pe inaltime
			for (int j = 0; j < bufferedImage.getWidth(); j++) { //deplasarea pe lungime
				Color cOriginal = new Color(bufferedImage.getRGB(j, i)); //Selectarea culorii de la pixelul j,i

				// Aplicarea transformarii logaritmice pe fiecare canal de culoare
				int red = (int) (255 * Math.log(1 + cOriginal.getRed()) / Math.log(256)); // Culoarea rosie
				int green = (int) (255 * Math.log(1 + cOriginal.getGreen()) / Math.log(256)); // Culoarea verde
				int blue = (int) (255 * Math.log(1 + cOriginal.getBlue()) / Math.log(256)); // Culoarea albastru

				// Asigurarea ca valorile raman in intervalul 0-255
				red = Math.min(255, Math.max(0, red)); // Culoarea rosie
				green = Math.min(255, Math.max(0, green)); // Culoarea verde
				blue = Math.min(255, Math.max(0, blue)); // Culoarea albastru

				Color cNou = new Color(red, green, blue); // Noua culoarea la pixelul j,i
				imagineTransformata.setRGB(j, i, cNou.getRGB()); // Punem noua culoarea in poza
			}
		}
	}

	// Implementarea metodei executeTransform din interfata Transformare
	@Override
	public void executeTransform() throws IOException {
		aplicaTransformare(); // Executam transformarea pozei
		exportImagine(); // Exportam poza
		System.out.println("Proces finalizat!");
	}

	// Getter pentru imaginea transformata
	public BufferedImage getImagineTransformata() {
		return imagineTransformata;
	}

	// Setter pentru imaginea transformata
	public void setImagineTransformata(BufferedImage imagineTransformata) {
		this.imagineTransformata = imagineTransformata;
	}
}
