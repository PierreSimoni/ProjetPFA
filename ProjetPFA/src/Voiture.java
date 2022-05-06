import java.util.List;

public class Voiture {
    List<String> listIntsr;
    boolean isParked;
    int nextACtion;
    Case position;

    public Voiture(List<String> listIntsr, boolean isParked, int nextACtion, Case position) {
        this.listIntsr = listIntsr;
        this.isParked = isParked;
        this.nextACtion = nextACtion;
        this.position = position;
    }
}
