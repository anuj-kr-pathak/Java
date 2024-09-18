package org.example;

public class ThreadMain {
    public static void main(String[] args) {

        SharedResource sharedResource = new SharedResource(3);

        Thread producerThread =  new Thread(()->{
            try{
                Thread.sleep(2000);
            }catch (Exception ex){

            }
            sharedResource.addItem();
            sharedResource.addItem();
            sharedResource.addItem();
            sharedResource.addItem();
        });

        Thread consumerThread = new Thread(()->{
            sharedResource.consumeThread();
            sharedResource.consumeThread();
            sharedResource.consumeThread();
        });

        producerThread.start();
        consumerThread.start();

    }
}