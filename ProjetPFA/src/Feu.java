public class Feu extends Case{
    Case straightOn;
    Case left;
    Case right;
    boolean green;

    public Feu(Case straightOn, Case left, Case right, boolean green) {
        this.straightOn = straightOn;
        this.left = left;
        this.right = right;
        this.green = green;
    }

    public void tick() {
        green = !green;
    }
}
