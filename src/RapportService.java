import java.util.List;

public class RapportService {

    private FormatRapport format;
    private SortieRapport sortie;
    private NotificateurRapport notification;

    public RapportService(FormatRapport format,
                          SortieRapport sortie,
                          NotificateurRapport notification) {
        this.format = format;
        this.sortie = sortie;
        this.notification = notification;
    }

    public void genererRapport(List<Document> documents) {

        String contenu = format.generer(documents);

        sortie.ecrire(contenu);

        notification.notifier("Rapport genere");
    }
}