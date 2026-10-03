import org.junit.jupiter.api.Test;

public class BibliothequeTest {

    @Test
    void testEmpruntNormal() {
        Livre l = new Livre("ABC", "Tom");
        l.emprunter();

        System.out.println("Emprunt effectué correctement");
    }

    @Test
    void testDoubleEmprunt() {
        Livre l = new Livre("ABC", "Tom");
        l.emprunter();

        try {
            l.emprunter();
            System.out.println("Erreur : le double emprunt a été accepté");
        }
        catch (IllegalStateException e) {
            System.out.println("Test réussi : double emprunt refusé");
        }
    }
}