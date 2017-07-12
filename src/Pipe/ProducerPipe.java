package Pipe;


import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class ProducerPipe extends Thread{
    private Pipe pipe;

    public ProducerPipe(Pipe pipe) {
        this.pipe = pipe;
    }

    public void run() {
        synchronized(pipe){

        while(true) {
            int random = ThreadLocalRandom.current().nextInt(0, 10 + 1);
            for (int i = 0; i <= random; i++) {
                int randomNum = ThreadLocalRandom.current().nextInt(0, 60 + 1);
                try {
                    fill(randomNum);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


                if(!MainPipe.active){
                    try {
                        pipe.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            }

        }
    }

    public  void fill(int in) throws IOException {
           pipe.put(in);

   }
}
