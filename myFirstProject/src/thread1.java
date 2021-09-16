class mythread extends Thread{
    @Override
    public void run() {
        int i=0;
        while (i<100) {
            System.out.println("Hello World");
        }
    }
}
class myRunable implements Runnable{
    @Override
    public void run() {
        int i=0;
        while (i<400) {
            System.out.println("Hello World");
            i++;
        }
    }
}
public class thread1 {
    public static void main(String[] args) {
        // mythread th1=new mythread();
        // th1.start();   
        
        myRunable hey=new myRunable();
        Thread th2=new Thread(hey);
        th2.start();
    }
}
