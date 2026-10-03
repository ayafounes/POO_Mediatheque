public class Dvd extends Document {

    private String realisateur;

    public Dvd(String titre, String realisateur) {
        super(titre);
        this.realisateur = realisateur;
    }

    @Override
    public String descriptionCourte() {
        return "DVD : " + titre + ", réalisateur : " + realisateur;
    }
}