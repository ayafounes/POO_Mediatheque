import java.util.List;

public class FormatJson implements FormatRapport {

    @Override
    public String generer(List<Document> documents) {
        String contenu = "[\n";

        for (int i = 0; i < documents.size(); i++) {

            String titre = documents.get(i).getTitre();
            titre = titre.replace("\\", "\\\\")
                    .replace("\"", "\\\"")
                    .replace("\n", "\\n");

            contenu += "  {\"titre\":\"" + titre + "\"}";

            if (i < documents.size() - 1) {
                contenu += ",";
            }

            contenu += "\n";
        }

        return contenu + "]";
    }
}