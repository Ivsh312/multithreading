/*
 * class parking simulator 
 */
package parking;

import static java.lang.Thread.sleep;


public class Place {
    private int id;

    public Place(int id) {
        this.id = id;
    }
    
    public int getId(){
        return this.id;
    }
    
    public void statesCar() throws InterruptedException{
        try{
        sleep(1000);    
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        
    }
}
