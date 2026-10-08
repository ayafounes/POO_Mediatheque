public class Livre extends Document implements Empruntable {

    private String auteur;
    private boolean emprunte = false;

    public Livre(String titre, String auteur) {
        super(titre);
        this.auteur = auteur;
    }

    @Override
    public String descriptionCourte() {
        return "Livre : " + titre + ", auteur : " + auteur;
    }

    @Override
    public void emprunter() throws DocumentIndisponibleException {

        // Vérifie si le livre est déjà emprunté.
        if (emprunte) {

            throw new DocumentIndisponibleException(
                    "Le livre '" + getTitre() + "' est déjà emprunté."
            );
        }

        emprunte = true;
    }

    @Override
    public void retourner() {
        emprunte = false;
    }
}