public class ImporteurLignesLivresAudio extends Importeur {

    @Override
    protected Document creerDocument(String ligne) {

        String[] c = ligne.split(";");

        return new LivreAudio(c[0].trim(), c[1].trim());
    }
}