public class FabriqueCsv implements FabriqueExport {

    @Override
    public String enTete() {
        return "titre;description\n";
    }


    @Override
    public String ligne(Document d) {
        return d.getTitre() + ";" + d.descriptionCourte() + "\n";
    }

    @Override
    public String pied() {
        return "";
    }
}