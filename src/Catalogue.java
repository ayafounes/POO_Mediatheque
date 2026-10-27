import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class Catalogue<T extends Document> implements Iterable<T> {

    private List<T> documents = new ArrayList<>();

    public void ajouter(T document) {
        documents.add(document);
    }

    public T rechercherParTitre(String titre) {

        for (T document : documents) {
            if (document.getTitre().equals(titre)) {
                return document;
            }
        }

        return null;
    }

    // SEANCE 3 : Design Pattern Iterator
    @Override
    public Iterator<T> iterator() {
        return documents.iterator();
    }

    // SEANCE 3 : Bonus Stream
    public Stream<T> stream() {
        return documents.stream();
    }

    // Methode generique des seances precedentes
    public static <T extends Comparable<T>> T max(List<T> liste) {

        T max = liste.get(0);

        for (T document : liste) {
            if (document.compareTo(max) > 0) {
                max = document;
            }
        }

        return max;
    }
}