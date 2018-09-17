/*
 * Class generate free place and car
 * class parking simulation
 */
package parking;

import java.util.LinkedList;

/**
 *
 * @author Lenovo
 */
public class Parking {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedList<Place> list = new LinkedList<Place>() {
            {
                this.add(new Place(1));
                this.add(new Place(2));
                this.add(new Place(3));
            }
        };
        Park pool = new Park(3, list);
        for (int i = 1; i < 8; i++) {
            new Car(pool, i).start();
        }
    }

}
