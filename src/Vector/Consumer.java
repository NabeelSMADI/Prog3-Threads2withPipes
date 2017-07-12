package Vector;


public class Consumer extends Thread{

    public void run() {
        try {
            read();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public  void read() throws InterruptedException {
        while (true){

            synchronized(Main.intVector){
            while(Main.intVector.size() > 0){
                drew(Main.intVector.get(0));
                Main.intVector.remove(0);
              }
            if(!Main.active){
               Main.intVector.wait();
            }
        }}

    }

    public void drew(int in) {
     for(int i= 0;i <= in ;i++){
         System.out.print("*");
     }
        System.out.println();
    }



}
