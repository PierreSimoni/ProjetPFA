public class Troncon extends Case{

    Case next;
    boolean accesPaking;
    int length;

    public Troncon(Case next, boolean accesPaking, int length) {
        this.next = next;
        this.accesPaking = accesPaking;
        this.length = length;
    }

    public Case getNext() {
        return next;
    }

    public void setNext(Case next) {
        this.next = next;
    }

    public boolean isAccesPaking() {
        return accesPaking;
    }

    public int getLength() {
        return length;
    }
}
