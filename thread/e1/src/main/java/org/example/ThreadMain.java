package org.example;

public class ThreadMain {
    public static void main(String[] args) {

        SharedResource sharedResource = new SharedResource();

        Thread producerThread =  new Thread(()->{
            try{
                Thread.sleep(2000);
            }catch (Exception ex){

            }
            sharedResource.addItem();
        });

        Thread consumerThread = new Thread(()->{
            sharedResource.consumeThread();
        });

        producerThread.start();
        consumerThread.start();

    }
}