package DOS;
class square extends Thread {
    public void run() {
        try {
            for(int i=0;i<5;i++) {
                System.out.println("Square "+i*i);
                Thread.sleep(1000);
            }
        } catch(InterruptedException e){}
    }
}
class cube extends Thread {
    public void run() {
        try {
            for(int i=0;i<5;i++) {
                System.out.println("Cube "+i*i*i);
                Thread.sleep(1000);
            }
        } catch(InterruptedException e){}
    }
}
public class MultiThreading {
    public static void main(String[] args) throws InterruptedException
    {
        square a = new square();
        cube b = new cube();
        a.setPriority(Thread.MIN_PRIORITY);
        b.setPriority(Thread.MAX_PRIORITY);
        a.start();
        b.start();
        try{
            Thread.sleep(2000);
            b.interrupt();
        } catch(InterruptedException e){}
    }
}