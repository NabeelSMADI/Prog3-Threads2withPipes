package Vector;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Product {
    public List<Integer> intVector = new ArrayList<Integer>(60);
    public boolean active = true;

    public synchronized void fill() throws InterruptedException {
        while (true) {
            if (!active || intVector.size() != 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


            int random = ThreadLocalRandom.current().nextInt(0, 10 + 1);
            for (int i = 0; i <= random; i++) {
                int randomNum = ThreadLocalRandom.current().nextInt(0, 60 + 1);
                intVector.add(randomNum);
            }
            wait();

            notifyAll();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


    public synchronized void read() {
        while (true) {
            if (intVector.size() == 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            while (intVector.size() != 0) {
                drew(intVector.get(0));
                intVector.remove(0);
            }
            notifyAll();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public synchronized void drew(int in) {
        for (int i = 0; i <= in; i++) {
            System.out.print("*");
        }
        System.out.println();
    }
}
