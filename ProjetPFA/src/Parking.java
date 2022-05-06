public class Parking extends Case {
    Case straightOrRight;
    Case left;
    int nbPlacelibre;

    public Parking(Case straightOrRight, Case left, int nbPlacelibre) {
        this.straightOrRight = straightOrRight;
        this.left = left;
        this.nbPlacelibre = nbPlacelibre;
    }
}
