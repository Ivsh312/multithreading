/*
 * this class contains parking spaces for cars
 */
package parking;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Park {

    Semaphore sem;
    private final Queue<Place> places = new LinkedList<Place>();

    public Park(int size, Queue<Place> plases) {
        this.sem = new Semaphore(size, false);
        this.places.addAll(plases);
    }
    //get a parking space, if busy then waiting 3 seconds
    public Place getPlace(long maxWaitMillis) throws ResourсeException {
        try {
            if (sem.tryAcquire(maxWaitMillis, TimeUnit.MILLISECONDS)) {
                Place res = places.poll();
                return res;
            } 
        } catch (InterruptedException e) {
            throw new ResourсeException(e);
        }
        throw new ResourсeException(":превышено время ожидания");
    }
//return place in pool
    public void returnResource(Place res) {
        places.add(res); // возвращение экземпляра в пул
        sem.release();
    }
}
