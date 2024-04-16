//Pachetul curent
package packTest;

//Importuri de functii
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Utilizarea claselor din packWork
import packWork.AplicareFinala;

// Clasa principala a programului
public class MyMain {
	// Metoda principala care este apelata la executarea programului
	public static void main(String[] args) {

		// Mesajul de introducere
		{
			// Afisarea mesajului pentru utilizator
			System.out.println("Acest program aplica asupra unei imagini transformarea Logarithmic Gray Level");
			System.out.println("Introduceti calea catre imaginea asupra careia doriti sa aplicati transformarea:");
		}

		// Utilizarea try-with-resources pentru a asigura inchiderea resurselor
		try (
				// Initializarea cititorului pentru intrarea de la consola
				InputStreamReader inputStreamReader = new InputStreamReader(System.in);
				BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
				) {

			// Salvarea calei introduse de la consola si masurarea timpului de citire
			long start = System.currentTimeMillis();
			String path = bufferedReader.readLine();
			long elapsedTimeMillis = System.currentTimeMillis() - start;

			// Afisarea caii introduse si solicitarea de continuare
			System.out.println("Calea pe care ati introdus-o este: " + path);
			System.out.println("\nDoriti sa continuati?");
			System.out.println("Optiuni: \"Da\" sau \"Nu\"");

			// Salvarea optiunii introduse de la consola
			String operation = bufferedReader.readLine().trim();

			// In functie de optiunea aleasa, se realizeaza una din cele doua variante si se calculeaza timpul de executie
			switch (operation.toLowerCase()) {
			case "da":
				start = System.currentTimeMillis();

				// Se apeleaza metoda pentru executarea transformarii asupra imaginii
				new AplicareFinala(path).executeTransform();

				// Calculul timpului de executie pentru transformare si scrierea imaginii prelucrate
				long elapsedTimeMillis1 = System.currentTimeMillis() - start;

				// Afisarea timpilor de executie
				System.out.println("\nTimpul in care s-a efectuat operatia de citire imagine sursa: "
						+ elapsedTimeMillis + "ms");
				System.out.println("Timpul in care s-a efectuat transformarea si operatia de scriere a imaginii prelucrate: "
						+ elapsedTimeMillis1 + "ms");
				break;

			case "nu":
				// Daca optiunea este "nu", nu se face nimic
				break;

			default:
				// Daca optiunea nu este "da" sau "nu", se afiseaza un mesaj de optiune invalida
				System.out.println("Optiune invalida.");
			}

		} catch (IOException e) {
			// In caz de exceptie la citire, se afiseaza mesajul de eroare
			System.out.println("Eroare la citirea datelor de la consola: " + e.getMessage());
		}
	}
}
