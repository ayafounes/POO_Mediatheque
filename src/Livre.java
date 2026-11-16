public class Livre extends Document implements Empruntable {

    private final String auteur;
    private final int annee;
    private final int nbPages;
    private final String isbn;
    private final String editeur;
    private final String langue;

    private boolean emprunte = false;

    // Ancien constructeur
    public Livre(String titre, String auteur) {
        super(titre);
        this.auteur = auteur;
        this.annee = 2020;
        this.nbPages = 1;
        this.isbn = null;
        this.editeur = null;
        this.langue = null;
    }

    // Constructeur du Builder
    private Livre(Builder b) {
        super(b.titre);
        this.auteur = b.auteur;
        this.annee = b.annee;
        this.nbPages = b.nbPages;
        this.isbn = b.isbn;
        this.editeur = b.editeur;
        this.langue = b.langue;
    }

    // ETAPE 3 : Constructeur de copie (Prototype)
    public Livre(Livre original) {
        super(original.getTitre());
        this.auteur = original.auteur;
        this.annee = original.annee;
        this.nbPages = original.nbPages;
        this.isbn = original.isbn;
        this.editeur = original.editeur;
        this.langue = original.langue;
        this.emprunte = original.emprunte;
    }

    // Pattern Builder
    public static class Builder {

        private final String titre;
        private final int annee;

        private String auteur;
        private int nbPages;
        private String isbn;
        private String editeur;
        private String langue;

        public Builder(String titre, int annee) {
            this.titre = titre;
            this.annee = annee;
        }

        public Builder auteur(String auteur) {
            this.auteur = auteur;
            return this;
        }

        public Builder nbPages(int nbPages) {
            this.nbPages = nbPages;
            return this;
        }

        public Builder isbn(String isbn) {
            this.isbn = isbn;
            return this;
        }

        public Builder editeur(String editeur) {
            this.editeur = editeur;
            return this;
        }

        public Builder langue(String langue) {
            this.langue = langue;
            return this;
        }

        public Livre build() {
            if (annee < 1450) {
                throw new IllegalStateException("Annee invalide");
            }

            if (nbPages <= 0) {
                throw new IllegalStateException("Nombre de pages invalide");
            }

            return new Livre(this);
        }
    }

    @Override
    public void emprunter() throws DocumentIndisponibleException {
        if (emprunte) {
            throw new DocumentIndisponibleException(
                    "Livre indisponible : " + getTitre());
        }
        emprunte = true;
    }

    @Override
    public void retourner() {
        emprunte = false;
    }

    @Override
    public String descriptionCourte() {
        return "Livre : " + getTitre() + " - " + auteur;
    }

    public String getAuteur() {
        return auteur;
    }

    public int getAnnee() {
        return annee;
    }

    public int getNbPages() {
        return nbPages;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getEditeur() {
        return editeur;
    }

    public String getLangue() {
        return langue;
    }
}