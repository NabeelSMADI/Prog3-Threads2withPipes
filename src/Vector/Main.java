package Vector;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<Integer> intVector = new ArrayList<Integer>(60);
    public static boolean active=true;

    public static void main(String[] args) throws InterruptedException {
        Producer p = new Producer();
        Consumer c = new Consumer();
        p.start();
        c.start();




        while (true){
            Scanner keyboard = new Scanner(System.in);
            String input = keyboard.nextLine();
            if(input != null) {

                if(active){
                    System.out.println("off");
                    active = false;
                    }else{
                    System.out.println("on");
                    active = true;
                    synchronized(intVector){
                        intVector.notifyAll();
                    }

                   }


            }
        }

        }





        }




