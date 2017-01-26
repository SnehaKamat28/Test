package DOS;
class ThreadClassThread extends Thread {
    public void run() {
        try {
            for(int i=0;i<3;i++) {
                System.out.print("\nThread executing for "+i+" sec");
                Thread.sleep(1000);
            }
        }
        catch(InterruptedException e){}
    }
}
public class ClassThread {
    public static void main(String[] args) {
        Thread t = new Thread(new ThreadClassThread(),"");
        t.start();
    }
}
