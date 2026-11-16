public class ImporteurCsv extends Importeur {

    @Override
    protected Document creerDocument(String ligne) {

        String[] c = ligne.split(";");

        switch (c[0].trim()) {

            case "livre":
                return new Livre(c[1].trim(), c[2].trim());

            case "dvd":
                return new Dvd(c[1].trim(), c[2].trim());

            case "revue":
                return new Revue(
                        c[1].trim(),
                        Integer.parseInt(c[2].trim())
                );

            default:
                throw new IllegalArgumentException(
                        "Type inconnu : " + c[0]);
        }
    }
}