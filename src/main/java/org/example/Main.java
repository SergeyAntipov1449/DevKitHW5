package org.example;

//Есть пять философов (потоки), которые могут либо обедать либо размышлять.
//        Каждый философ должен пообедать три раза. Каждый прием пищи длиться 500 миллисекунд
//        После каждого приема пищи философ должен размышлять
//        Не должно возникнуть общей блокировки
//        Философы не должны есть больше одного раза подряд

import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch endMeals = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new PhilosofersDinnary(endMeals, new Philosof(String.valueOf(i))));
            thread.setDaemon(true);
            thread.start();
        }
        endMeals.await();
        System.out.println("Все пообедали");
    }
}