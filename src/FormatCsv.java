import java.util.List;

public class FormatCsv implements FormatRapport {

    @Override
    public String generer(List<Document> documents) {
        String contenu = "";

        for (Document d : documents) {
            contenu += d.getTitre() + "\n";
        }

        return contenu;
    }
}