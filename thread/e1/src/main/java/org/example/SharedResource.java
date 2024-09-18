package org.example;

public class SharedResource {

    boolean isItemPresent = false;

    public synchronized void addItem(){
        isItemPresent = true;
        System.out.println("Producer thread is calling notify method ");
        notifyAll();
    }

    public synchronized void consumeThread(){
        System.out.println("Consumer Thread is called .....");
        while (!isItemPresent) {
            try{
                System.out.println("Consumer thread is waiting .....");
                wait(); //will release monitor lock over here ....
            }catch (Exception exception){
                //exception occurs
            }
        }
        isItemPresent = false;
    }
}
