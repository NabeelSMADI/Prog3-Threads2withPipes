package Vector;


import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class Producer extends Thread{


    public void run() {
        while(true) {
            int random = ThreadLocalRandom.current().nextInt(0, 10 + 1);
            for (int i = 0; i <= random; i++) {
                int randomNum = ThreadLocalRandom.current().nextInt(0, 60 + 1);
                fill(randomNum);
            }

            synchronized(Main.intVector){
                 if(!Main.active){
                     try {
                         Main.intVector.wait();
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                 }
            }


            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public  void fill(int in)  {
        synchronized(Main.intVector){
            Main.intVector.add(in);
            }
        }
   }



