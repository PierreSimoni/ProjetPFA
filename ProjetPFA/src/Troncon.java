public class Troncon extends Case{

    Case next;
    boolean accesPaking;
    int length;

    public Troncon(Case next, boolean accesPaking, int length) {
        this.next = next;
        this.accesPaking = accesPaking;
        this.length = length;
    }
}
