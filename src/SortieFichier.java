import java.io.FileWriter;
import java.io.IOException;

public class SortieFichier implements SortieRapport {

    private String chemin;

    public SortieFichier(String chemin) {
        this.chemin = chemin;
    }

    @Override
    public void ecrire(String contenu) {
        try (FileWriter f = new FileWriter(chemin)) {
            f.write(contenu);
        }
        catch (IOException e) {
            throw new RuntimeException("Erreur ecriture fichier", e);
        }
    }
}