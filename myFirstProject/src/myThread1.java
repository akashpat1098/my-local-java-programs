class myThread extends Thread{
     myThread(String name){
        super(name);
     }
    public void run(){
        int i=0;
        while (i<400) {
            System.out.println("I am Thread");
            System.out.printf("My name is %s\n",getName());

            i++;
        }
        
    }
}
public class myThread1 {
    public static void main(String[] args) throws Exception {
        myThread th1=new myThread("Akash");
        
        th1.start();
    }
}
