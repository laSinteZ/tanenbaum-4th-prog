package Tanenbaum;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by George on 05.05.2016.
 */
public class DinningPhilosophers {
    private static int PHILOSOPHERS_NUMBER =5;

    public static void main(String[] args) {
        Philosopher [] philosophers = new Philosopher[PHILOSOPHERS_NUMBER];
        Monitor monitor = new Monitor(PHILOSOPHERS_NUMBER);
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        for (int i=0;i<PHILOSOPHERS_NUMBER;i++){
            philosophers[i] = new Philosopher(i,monitor);
            executor.execute(philosophers[i]);
        }
        executor.shutdown();
    }
}

class Philosopher implements Runnable{

    private Random random = new Random();

    private  int id;

    private Monitor monitor;

    public Philosopher(int id, Monitor monitor){
        this.id = id;
        this.monitor = monitor;
    }
    @Override
    public void run() {
        while (true){
            try {
                think();
                monitor.pickUpChopsticks(id);
                eat();
                monitor.releaseChopsticks(id);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    private void think() throws InterruptedException{
        System.out.println("Philosopher "+ id + " is thinking");
        Thread.sleep(random.nextInt(10));
    }

    private void eat() throws InterruptedException{
        Thread.sleep(random.nextInt(10));
    }
}

class Monitor{
    private enum State{
        Hungry,
        Thinking,
        Eating
    };
    private State[] philosophersState;

    public Monitor(int numOfPhilosophers){
        philosophersState = new State[numOfPhilosophers];
        for (int i=0; i< numOfPhilosophers;i++)
            philosophersState[i] = State.Eating;
    }

    public synchronized void pickUpChopsticks(int philosopherId) throws InterruptedException{
        philosophersState[philosopherId] = State.Hungry;
        while (neighbourIsEating(philosopherId)){
            wait();
        }
        philosophersState[philosopherId] = State.Eating;
        System.out.println("Philosopher " + philosopherId + " is eating");
    }

    private boolean neighbourIsEating(int philosopherId){
        if(philosophersState[(philosopherId+1)%philosophersState.length]
                ==State.Eating)
            return true;
        if(philosophersState[(philosopherId+philosophersState.length-1)%philosophersState.length]
                == State.Eating)
            return true;
        return false;
    }

    public synchronized void releaseChopsticks(int philosopherID){
        philosophersState[philosopherID] = State.Thinking;
        notifyAll();
    }
}
