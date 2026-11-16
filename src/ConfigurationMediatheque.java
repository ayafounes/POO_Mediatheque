public class ConfigurationMediatheque {

    private int dureeEmprunt = 21;
    private int maxEmprunts = 5;

    private ConfigurationMediatheque() {
    }

    private static class Holder {
        private static final ConfigurationMediatheque INSTANCE =
                new ConfigurationMediatheque();
    }

    public static ConfigurationMediatheque getInstance() {
        return Holder.INSTANCE;
    }

    public int getDureeEmprunt() {
        return dureeEmprunt;
    }

    public void setDureeEmprunt(int duree) {
        dureeEmprunt = duree;
    }

    public int getMaxEmprunts() {
        return maxEmprunts;
    }
}