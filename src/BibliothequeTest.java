import org.junit.jupiter.api.Test;

public class BibliothequeTest {

    @Test
    void testEmpruntNormal() throws DocumentIndisponibleException  {
        Livre l = new Livre("A1", "Tom");
        l.emprunter();

        System.out.println("Emprunt effectué correctement");
    }

    @Test
    void testDoubleEmprunt ()throws  DocumentIndisponibleException {
        Livre l = new Livre("a2", "Tom");


        try {
            l.emprunter();
            l.emprunter();
            System.out.println("Erreur : le double emprunt a été accepté");
        }
        catch ( DocumentIndisponibleException  e) {
            System.out.println("Exception détectée : "+e.getMessage());
        }
    }
}