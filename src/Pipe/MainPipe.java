package Pipe;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainPipe {
    public static List<Integer> intVector = new ArrayList<Integer>(60);
    public static boolean active=true;

    public static void main(String[] args) throws IOException {
        Pipe pipe = new Pipe();
        ProducerPipe p = new ProducerPipe(pipe);
        ConsumerPipe c = new ConsumerPipe(pipe);
        p.start();
        c.start();




        while (true){
            Scanner keyboard = new Scanner(System.in);
            String input = keyboard.nextLine();
            if(input != null) {
                if(active){
                   active = false;
                }else{
                    active = true;
                    synchronized(pipe){
                        pipe.notifyAll();
                    }

                }


            }
        }
    }
}
