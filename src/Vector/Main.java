package Vector;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Product product = new Product();
        Producer p = new Producer(product);
        Consumer c = new Consumer(product);
        p.start();
        c.start();




        while (true){
            Scanner keyboard = new Scanner(System.in);
            String input = keyboard.nextLine();
            if(input != null) {

                if(product.active){
                    System.out.println("off");
                    product.active = false;
                    }else{
                    System.out.println("on");
                    product.active = true;
                    product.notifyAll();

                   }


            }
        }

        }





        }




