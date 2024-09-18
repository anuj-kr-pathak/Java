package org.example;

import java.util.ArrayList;
import java.util.List;

public class SharedResource {

    int size=0;
    int count=0;
    List<Integer> queue;
    SharedResource(int size){

        if(size <=0 ){
            new RuntimeException("Queue size can't be less than or equal to 0");
        }
        this.size = size;
        queue = new ArrayList<>();
    }

    boolean isItemPresent = false;

    public synchronized void addItem(){

        if(queue.size()>=size){
            //wait producer thread for consumption
            try {
                wait();
            }catch (Exception exception){
                System.out.println("Exception occurred while adding item");
            }
        }
        queue.add(0);
        System.out.println("current size of queue "+queue.size());
        System.out.println("Producer thread is calling notify method");
        notify();
    }

    public synchronized void consumeThread(){
        System.out.println("Consumer Thread is called .....");
        while (queue.size()<=0) {
            try{
                System.out.println("Consumer thread is waiting .....");
                wait(); //will release monitor lock over here ....
            }catch (Exception exception){
                //exception occurs
            }
        }
        //remove from index one
        queue.remove(0);
        System.out.println("queue size after removing element" +queue.size());
        notify();
    }
}
