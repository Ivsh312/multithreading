/*
 * class client
 * gets a parking space, if busy waiting for a certain time, if busy and then it leaves
 */
package parking;


public class Car extends Thread {

    private int idCar;
    private Park park;

    public Car(Park park, int idCar) {
        this.park = park;
        this.idCar = idCar;
    }
    //gets a parking space, if busy waiting for a certain time, if busy and then it leaves
    public void run() {
        Place place = null;
        try {
            place = park.getPlace(1000);
            if(place != null)
            {
                System.out.println("Car #" + this.getIdCar() + "  placed #" + place.getId());
                place.statesCar();
            }
        } catch (ResourсeException e) {
            System.out.println("car #" + this.getIdCar() + " lost ->"
                    + e.getMessage());
        } catch (InterruptedException ex) {
            System.out.println("sleep truble #" + this.getIdCar());
        } finally {
            if (place != null) {
                System.out.println("Car #" + this.getIdCar() + " : "
                        + place.getId() + " car out");
                park.returnResource(place);
            }
        }
    }

    public int getIdCar() {
        return idCar;
    }

    public void setId(int Id) {
        this.idCar = idCar;
    }
    
}
