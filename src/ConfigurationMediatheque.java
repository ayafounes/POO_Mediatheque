public class ConfigurationMediatheque {

    private int dureeEmprunt;
    private int maxEmprunts;

    public ConfigurationMediatheque(int duree, int max) {
        this.dureeEmprunt = duree;
        this.maxEmprunts = max;
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