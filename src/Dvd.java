public class Dvd extends Document implements Empruntable {

    private String realisateur;
    private boolean emprunte = false;

    public Dvd(String titre, String realisateur) {
        super(titre);
        this.realisateur = realisateur;
    }

    @Override
    public String descriptionCourte() {
        return "DVD : " + titre + ", réalisateur : " + realisateur;
    }

    @Override
    public void emprunter() {

        if (emprunte) {
            throw new IllegalStateException("DVD déjà emprunté");
        }

        emprunte = true;
    }

    @Override
    public void retourner() {
        emprunte = false;
    }
}