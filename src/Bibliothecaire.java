public class Bibliothecaire {
    private String nom;
    private Catalogue<Document> catalogue;

    public Bibliothecaire(String nom, Catalogue<Document> catalogue) {
        this.nom = nom;
        this.catalogue = catalogue;
    }

    public void accueillir() {
        System.out.println("Bonjour, je suis " + nom);
    }

    public void ajouter(Document d) {
        catalogue.ajouter(d);
    }
}