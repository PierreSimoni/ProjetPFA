public class Case {

    Case straight;
    Case left;
    Case rigth;

    public Case(Case straight, Case left, Case rigth) {
        this.straight = straight;
        this.left = left;
        this.rigth = rigth;
    }

    public Case() {
    }

    public Case getStraight() {
        return straight;
    }

    public void setStraight(Case straight) {
        this.straight = straight;
    }

    public Case getLeft() {
        return left;
    }

    public void setLeft(Case left) {
        this.left = left;
    }

    public Case getRigth() {
        return rigth;
    }

    public void setRigth(Case rigth) {
        this.rigth = rigth;
    }
     Case getNext(){
        return null;
    }
    public int getLength() {
        return 0;
    }
}
