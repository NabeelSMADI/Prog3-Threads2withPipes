package Vector;


import java.util.concurrent.ThreadLocalRandom;

public class Producer extends Thread{

    Product product ;

    public Producer (Product p){
        product = p;
    }

    public void run() {
        try {
            product.fill();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


   }



