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
    @Test
    void testBibliothecaire() {
        Catalogue<Document> c = new Catalogue<>();

        Bibliothecaire b = new Bibliothecaire("Aya", c);

        b.accueillir();

        Livre l = new Livre("Java", "Jacques");
        b.ajouter(l);

        c.afficherTout();
    }
    @Test
    void testEmpruntManager() {
        Catalogue<Document> c = new Catalogue<>();

        c.ajouter(new Livre("Java", "Auteur"));

        EmpruntManager manager = new EmpruntManager(c);

        try {
            manager.emprunter("Java");
            manager.emprunter("Java");
        }
        catch (MediathequeException e) {
            System.out.println(e.getMessage());
        }
    }
    @Test
    void testDocumentIntrouvable() {
        Catalogue<Document> c = new Catalogue<>();
        EmpruntManager m = new EmpruntManager(c);

        try {
            m.emprunter("Java");
            System.out.println("Erreur : exception non declenchee");
        }
        catch (DocumentIntrouvableException e) {
            System.out.println("Exception detectee : " + e.getMessage());
        }
        catch (MediathequeException e) {
            System.out.println("Mauvaise exception");
        }
    }
    @Test
    void testDocumentIndisponible() {
        Catalogue<Document> c = new Catalogue<>();
        c.ajouter(new Livre("Java", "Auteur"));

        EmpruntManager m = new EmpruntManager(c);

        try {
            m.emprunter("Java");
            m.emprunter("Java");

            System.out.println("Erreur : double emprunt accepte");
        }
        catch (DocumentIndisponibleException e) {
            System.out.println("Exception detectee : " + e.getMessage());

            if (e.getMessage().contains("Java")) {
                System.out.println("Le titre est present dans le message");
            }
        }
        catch (MediathequeException e) {
            System.out.println("Autre exception : " + e.getMessage());
        }
    }
    @Test
    void testExceptionMessage() {
        DocumentIntrouvableException e =
                new DocumentIntrouvableException("Document Java introuvable");

        System.out.println(e.getMessage());
    }
}
