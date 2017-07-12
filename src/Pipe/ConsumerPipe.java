package Pipe;


import java.io.IOException;

public class ConsumerPipe extends Thread{
    private Pipe pipe;

    public ConsumerPipe(Pipe pipe) {
        this.pipe = pipe;
    }

    public void run() {
        try {
            read();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public  void read() throws InterruptedException, IOException {
        while (true){
            if(!MainPipe.active){
                try {
                    synchronized(pipe) {
                        pipe.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                drew(pipe.get());
            }




        }

        }



    public void drew(int in) {
     for(int i= 0;i <= in ;i++){
         System.out.print("*");
     }
        System.out.println();
    }

}
