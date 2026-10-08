public interface Empruntable {
    /**
     *
     * @throws DocumentIndisponibleException si le document
     *         est déjà emprunté.
     */
    void emprunter() throws DocumentIndisponibleException;

    void retourner();
}

