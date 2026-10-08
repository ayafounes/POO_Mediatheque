public abstract class MediathequeException extends Exception {

    // doit pouvoir gérer explicitement : document introuvable ou indisponible.
    public MediathequeException (String message){
        super(message);

        }
    }



