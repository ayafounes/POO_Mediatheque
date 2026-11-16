public class ExportCatalogue {

    private final FabriqueExport fabrique;

    public ExportCatalogue(FabriqueExport fabrique) {
        this.fabrique = fabrique;
    }

    public String exporter(Iterable<Document> documents) {

        StringBuilder resultat =
                new StringBuilder(fabrique.enTete());

        for (Document d : documents) {
            resultat.append(fabrique.ligne(d));
        }

        resultat.append(fabrique.pied());

        return resultat.toString();
    }
}