import javax.sound.midi.Soundbank;
import java.lang.ref.PhantomReference;
import java.util.Random;

public class PiEstimator {

//    //number of iterations the algorithm, a larger number here should result in a more accurate estimate
//    public static int numberOfDarts = 100_000_000;
//    public static void main(String[] args) {
//        //how many darts lie within the quarter circle region
//        int within = 0;
//        Random r = new Random();
//        for(int i = 0; i< numberOfDarts; i++){
//            //get x and y coordinates for the darts
//            double x = r.nextDouble();
//            double y = r.nextDouble();
//            //calculate the distance from the origin (0, 0) darts with a distance less than 1 are within the
//            //quarter circle so add these to within
//            double dist = Math.sqrt((x*x) + (y*y)); // Pythagoras theorem
//            if(dist < 1)
//                within++;
//        }
//
//        //estimate pi by getting proportion of darts in the quarter circle and multiplying by 4.
//        double estimate = (double)within/numberOfDarts *4;
//        System.out.println(estimate);
//    }

    public static void main(String[] args) throws InterruptedException {
        float totDarts = 1_000_000_000; // One Billion (9 zeros)

        TotalWithin thread1 = new TotalWithin((int) (totDarts/4), "Thread 1");
        TotalWithin thread2 = new TotalWithin((int) (totDarts/4), "Thread 2");
        TotalWithin thread3 = new TotalWithin((int) (totDarts/4), "Thread 3");
        TotalWithin thread4 = new TotalWithin((int) (totDarts/4), "Thread 4");

        // Start running thr individual threads
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        // For thread synchronization, will wait until,  remains in a waiting state until the referenced thread dies
        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();

        System.out.println(thread1.getWithin() + thread2.getWithin() + thread3.getWithin() + thread4.getWithin());

        int sum = thread1.getWithin() + thread2.getWithin() + thread3.getWithin() + thread4.getWithin();

        double estimates = (double) sum/totDarts * 4;
        System.out.println(estimates);
    }
}

// Will be used for multiple threads to simulate a scenario for each thread
class TotalWithin extends Thread {

    int numberOFDarts;
    String name; // To keep the thread names
    int within; // Stores num of darts that hit in quarter circle

    public TotalWithin(int numberOFDarts, String name)
    {
        this.numberOFDarts = numberOFDarts;
        this.name = name;
        System.out.println("Thread " + name + " starting...");
    }

    // Calculates num that hits quarter circle
    public void run()
    {
        Random r = new Random();
        for (int i = 0; i < numberOFDarts; i++)
        {
            double x = r.nextDouble();
            double y = r.nextDouble();
            double dist = Math.sqrt((x * x) + (y * y));
            if (dist < 1)
            {
                within++;
            }
        }

        System.out.println("Thread " + name + " x " + within); // getter for within
    }

    // Setter to access property in pie class
    public int getWithin() {
        return within;
    }
}

// All the calculation is copied and pasted from the single threaded implementation

