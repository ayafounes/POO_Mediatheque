public class NotificationConsole implements NotificateurRapport {

    @Override
    public void notifier(String message) {
        System.out.println(message);
    }
}