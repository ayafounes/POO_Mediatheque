public class EmpruntManager {

    private Catalogue<Document> catalogue;

    public EmpruntManager(Catalogue<Document> catalogue) {
        this.catalogue = catalogue;
    }

    public void emprunter(String titre) throws MediathequeException {

        Document d = catalogue.rechercherParTitre(titre);

        if (d == null) {
            throw new DocumentIntrouvableException(
                    "Document introuvable : " + titre
            );
        }

        if (!(d instanceof Empruntable)) {
            throw new DocumentIndisponibleException(
                    "Document non empruntable : " + titre
            );
        }

        Empruntable e = (Empruntable) d;
        e.emprunter();
    }
}