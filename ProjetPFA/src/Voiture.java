import java.util.List;
import java.util.regex.Pattern;

public class Voiture {

    static final String PARK_INSTRUCTION_REGEX = "park\\s*\\d+";
    Circuit circuit;
    Instructions instructions;
    boolean isParked;
    int nextACtion = 0;
    int timeToPark = 0;
    Case position;

    public Voiture(Circuit circuit, Instructions instructions, boolean isParked, Case position) {
        this.circuit = circuit;
        this.instructions = instructions;
        this.isParked = isParked;
        this.position = position;
    }

    public void tick() {
        if(nextACtion == 0 && !isParked) {
            if(timeToPark > 0) {
                if(tryToPark()) return;
            }

            String instruction = instructions.get();

            if (position instanceof Troncon){
                position = position.getNext();
                System.out.println("arrivé au feu");
            }else{
                switch (instruction) {
                    case "END_OF_STREAM":
                        System.out.println("Je suis arrivé");
                        break;
                    case "left":
                        System.out.println("Je prend a gauche");
                        position = position.getLeft();
                        nextACtion = position.getLength();

                        break;
                    case "right":
                        System.out.println("Je prend a droite");
                        position = position.getRigth();
                        nextACtion = position.getLength();
                        break;
                    case "straight-on":
                        System.out.println("Je prend tout droit");
                        position = position.getStraight();
                        nextACtion = position.getLength();
                        break;
                    default:
                        if(instruction.matches(PARK_INSTRUCTION_REGEX)) {
                            instruction.trim();
                            int timeToPark = Integer.valueOf(instruction.substring(5));
                            this.timeToPark += timeToPark;
                            tryToPark();
                        }
                        break;
                }
            }

        }
        else {
            if(isParked) timeToPark--;
            else nextACtion--;
        }
    }

    public boolean tryToPark() {
        if(position instanceof Troncon && ((Troncon)position).accesPaking) {
            if(circuit.tryPark()) {
                isParked = true;
                return true;
            }
        }
        return false;
    }
}
