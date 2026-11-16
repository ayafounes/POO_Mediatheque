
public class FabriqueMarkdown implements FabriqueExport {

    @Override
    public String enTete() {
        return "| Titre | Description |\n"
                + "|-------|-------------|\n";
    }

    @Override
    public String ligne(Document d) {
        return "| " + d.getTitre() + " | "
                + d.descriptionCourte() + " |\n";
    }

    @Override
    public String pied() {
        return "";
    }
}
