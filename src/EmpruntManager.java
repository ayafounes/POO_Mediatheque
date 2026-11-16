public class EmpruntManager {

    private Catalogue<Document> catalogue;
    private ConfigurationMediatheque config;

    public EmpruntManager(Catalogue<Document> catalogue,
                          ConfigurationMediatheque config) {
        this.catalogue = catalogue;
        this.config = config;
    }

    public void emprunter(String titre) throws MediathequeException {

        Document d = catalogue.rechercherParTitre(titre);

        if (d == null) {
            throw new DocumentIntrouvableException(
                    "Document introuvable : " + titre);
        }

        if (!(d instanceof Empruntable)) {
            throw new DocumentIndisponibleException(
                    "Document non empruntable : " + titre);
        }

        Empruntable e = (Empruntable) d;
        e.emprunter();

        System.out.println("Duree : "
                + config.getDureeEmprunt() + " jours");
    }
}