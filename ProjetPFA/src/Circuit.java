import java.util.*;
import java.util.function.Supplier;

public class Circuit {
    final int MAX_TIME;
    int time = 0;
    List<Voiture> voitures = new ArrayList<>();
    Troncon t1, t2, t3, t4, t5, t6;
    Feu f1, f2, f3, f4;
    Parking parking;

    public Circuit(int MAX_TIME) {
        this.MAX_TIME = MAX_TIME;
        init();
    }

    public static void main(String[] args) {
        Circuit circuit = new Circuit(60);

        circuit.start();
    }

    public void init() {


        t1 = new Troncon(null, false, 3);
        t2 = new Troncon(null, false, 3);
        t3 = new Troncon(null, true, 2);
        t4 = new Troncon(null, false, 2);
        t5 = new Troncon(null, true, 1);
        t6 = new Troncon(null, false, 1);

        f1 = new Feu(t3, t1, t5, false);
        f2 = new Feu(t5, t2, t3, true);
        f3 = new Feu(t2, t1, t5, false);
        f4 = new Feu(t1, t3, t2, true);

        t1.setNext(f1);
        t2.setNext(f2);
        t3.setNext(t6);
        t4.setNext(f3);
        t5.setNext(t4);
        t6.setNext(f4);

        parking = new Parking(t4, t6, 3);

        // initialiser la liste de voitures
        //instructions voitures
        Queue<String> queue1 = new LinkedList<>(Arrays.asList("left", "right", "park 10", "straight-on"));
        Instructions instructions1 = new Instructions(queue1, new Supplier<Queue<String>>() {
            @Override
            public Queue<String> get() {
                return new LinkedList<>(Arrays.asList("left", "right", "park 10", "straight-on"));
            }
        });

        Queue<String> queue2 = new LinkedList<>(Arrays.asList("right", "left", "straight-on", "left"));
        Instructions instructions2 = new Instructions(queue1, new Supplier<Queue<String>>() {
            @Override
            public Queue<String> get() {
                return new LinkedList<String>(Arrays.asList("END_OF_STREAM"));
            }
        });

        Voiture v1 = new Voiture(this, instructions1, false, parking);
        voitures.add(v1);
        Voiture v2 = new Voiture(this, instructions2, false, parking);
        voitures.add(v2);
        Voiture v3 = new Voiture(this, instructions1, false, parking);
        voitures.add(v3);
    }

    public void start() {
        while(time < MAX_TIME) {
            tick();
            time++;
        }
    }

    public void tick() {
        f1.tick(); f2.tick(); f3.tick(); f4.tick();

        for(Voiture voiture : voitures) {
            voiture.tick();
        }
    }

    public boolean tryPark() {
        if(parking.nbPlacelibre > 0) {
            parking.nbPlacelibre--;
            return true;
        }
        return false;
    }
}
