package Vector;


public class Consumer extends Thread{

    Product product ;

    public Consumer (Product p){
        product = p;
    }


    public void run() {
        product.read();
    }







}
