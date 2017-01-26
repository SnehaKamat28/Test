package DOS;
class RunnableInterfaceThread implements Runnable {
    public void run() {
        try {
            for(int i=0;i<5;i++) {
                System.out.print("\nThread executing for "+i+" sec");
                Thread.sleep(1000);
                
            }
        }
        catch(InterruptedException e){}
    }
}
public class InterfaceThread {
    public static void main(String[] args) {
        Thread t = new Thread(new RunnableInterfaceThread(),"");
        t.start();
    }
}
