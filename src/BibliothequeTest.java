
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BibliothequeTest {

    // Test d'un emprunt normal
    @Test
    void testEmpruntNormal() throws DocumentIndisponibleException {

        Livre l = new Livre("ABC", "Tom");

        l.emprunter();

        System.out.println("Emprunt effectué correctement");
    }

    // Test d'un double emprunt
    @Test
    void testDoubleEmprunt() throws DocumentIndisponibleException {

        Livre l = new Livre("ABC", "Tom");

        // Premier emprunt : il doit réussir
        l.emprunter();

        // Deuxième emprunt : il doit déclencher une exception
        assertThrows(
                DocumentIndisponibleException.class,
                () -> l.emprunter()
        );

        System.out.println("Test réussi : double emprunt refusé");
    }

    // Test du Design Pattern Iterator
    @Test
    void testParcoursCatalogueAvecIterator() {

        Catalogue<Document> catalogue = new Catalogue<>();

        catalogue.ajouter(new Livre("Java", "Alice"));
        catalogue.ajouter(new Dvd("Inception", "Christopher Nolan"));
        catalogue.ajouter(new Revue("Science", 12));

        int nombre = 0;

        for (Document document : catalogue) {
            System.out.println(document.descriptionCourte());
            nombre++;
        }

        assertEquals(3, nombre);
    }

    // Test de recherche dans le catalogue
    @Test
    void testRechercheApresModification() {

        Catalogue<Document> catalogue = new Catalogue<>();

        catalogue.ajouter(new Livre("Java", "Alice"));

        assertNotNull(catalogue.rechercherParTitre("Java"));
        assertNull(catalogue.rechercherParTitre("Python"));
    }
}
