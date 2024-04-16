//Pachetul curent
package packWork;

//Importuri de functii
import java.io.IOException;

// Transfer path-ul intre clase si afisez mesajul de incepere a procesului
public class AplicareFinala extends AplicaTransformare {

    // Constructor care apeleaza constructorul superclasei (AplicaTransformare) cu calea data
    public AplicareFinala(String path) throws IOException {
        super(path);
    }

    // Bloc static executat la încarcarea clasei
    static {
        System.out.println("A inceput procesul!");
    }

    // O metoda numita 'function' cu un numar variabil de argumente
    public void function(String str, int... var) {
        System.out.println("Sirul de afisat este: " + str);
        System.out.println("\n având argumentele: " + var.length);

        // Afisarea indicilor argumentelor variabile
        for (int i = 0; i < var.length; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}