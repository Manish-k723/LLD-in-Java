package Others;

public class multiThreading implements Runnable{

    public synchronized void task1(){
        try{
            System.out.println("task1");
            Thread.sleep(10000);
            System.out.println("task1 woke up");
        }catch(InterruptedException e){

        }
    }
    public void task2(){
        System.out.println("task2");
        synchronized (this) {
            System.out.println("task2 unlocked");
        }
    }

    public void task3(){
        System.out.println("task3");
    }

    @Override
    public void run() {

    }
}
