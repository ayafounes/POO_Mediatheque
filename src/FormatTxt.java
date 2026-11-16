import java.util.List;

public class FormatTxt implements FormatRapport {

    @Override
    public String generer(List<Document> documents) {
        String contenu = "";

        for (Document d : documents) {
            contenu += "- " + d.descriptionCourte() + "\n";
        }

        return contenu;
    }
}