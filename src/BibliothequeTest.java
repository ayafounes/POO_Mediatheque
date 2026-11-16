
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
    @Test
    void testRapportService() {

        java.util.List<Document> docs = new java.util.ArrayList<>();

        docs.add(new Livre("Java", "Tom"));
        docs.add(new Livre("Python", "Ali"));

        FormatRapport format = new FormatCsv();
        SortieRapport sortie = new SortieFichier("rapport.csv");
        NotificateurRapport notification = new NotificationConsole();

        RapportService service =
                new RapportService(format, sortie, notification);

        service.genererRapport(docs);
    }
    @Test
    void testDIP() {

        FormatRapport fauxFormat = new FormatRapport() {
            public String generer(java.util.List<Document> docs) {
                return "Rapport de test";
            }
        };

        SortieRapport fausseSortie = new SortieRapport() {
            public void ecrire(String contenu) {
                System.out.println("Contenu recu : " + contenu);
            }
        };

        NotificateurRapport notification = new NotificationConsole();

        RapportService service =
                new RapportService(fauxFormat, fausseSortie, notification);

        service.genererRapport(new java.util.ArrayList<Document>());
    }

    @Test
    void testDureePersonnalisee() {
        ConfigurationMediatheque c =
                new ConfigurationMediatheque(7, 5);

        System.out.println("Duree : " + c.getDureeEmprunt());
    }

    @Test
    void testDureeParDefaut() {
        ConfigurationMediatheque c =
                new ConfigurationMediatheque(21, 5);

        System.out.println("Duree : " + c.getDureeEmprunt());
    }
    @Test
    void testEmpruntManagerAvecConfiguration() {

        Catalogue<Document> c = new Catalogue<>();
        c.ajouter(new Livre("Java", "Tom"));

        ConfigurationMediatheque config =
                new ConfigurationMediatheque(7, 5);

        EmpruntManager m = new EmpruntManager(c, config);

        try {
            m.emprunter("Java");
        }
        catch (MediathequeException e) {
            System.out.println(e.getMessage());
        }
    }
    @Test
    void testImporteurCsv() {

        java.util.List<String> lignes = new java.util.ArrayList<>();

        lignes.add("livre;Java;Tom");
        lignes.add("dvd;Inception;Christopher Nolan");
        lignes.add("revue;Science;12");

        Importeur importeur = new ImporteurCsv();

        java.util.List<Document> documents =
                importeur.importer(lignes);

        for (Document d : documents) {
            System.out.println(d.descriptionCourte());
        }
    }
    @Test
    void testImporteurLivreAudio() {

        java.util.List<String> lignes = new java.util.ArrayList<>();

        lignes.add("Java;Tom");
        lignes.add("Python;Ali");

        Importeur importeur = new ImporteurLignesLivresAudio();

        java.util.List<Document> documents =
                importeur.importer(lignes);

        for (Document d : documents) {
            System.out.println(d.descriptionCourte());
        }
    }
    @Test
    void testBuilder() {
        Livre l = new Livre.Builder("Java", 2020)
                .auteur("Tom")
                .nbPages(350)
                .isbn("123456")
                .editeur("Eyrolles")
                .langue("FR")
                .build();

        System.out.println(l.descriptionCourte());
        System.out.println("Annee : " + l.getAnnee());
        System.out.println("Pages : " + l.getNbPages());
        System.out.println("ISBN : " + l.getIsbn());
    }
    @Test
    void testBuilderInvalide() {

        assertThrows(IllegalStateException.class, () -> {
            new Livre.Builder("Java", 1400)
                    .nbPages(0)
                    .build();
        });
    }
    @Test
    void testAbstractFactory() {

        Catalogue<Document> catalogue = new Catalogue<>();

        catalogue.ajouter(new Livre("Java", "Tom"));
        catalogue.ajouter(new Dvd("Inception", "Nolan"));
        catalogue.ajouter(new Revue("Science", 12));

        ExportCatalogue csv =
                new ExportCatalogue(new FabriqueCsv());

        System.out.println("EXPORT CSV :");
        System.out.println(csv.exporter(catalogue));

        ExportCatalogue html =
                new ExportCatalogue(new FabriqueHtml());

        System.out.println("EXPORT HTML :");
        System.out.println(html.exporter(catalogue));
    }
}
