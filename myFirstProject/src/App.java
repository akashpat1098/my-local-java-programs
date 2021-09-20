
 class testClass {
     static int a=5;
     int b=9;
    static void meth(){
        System.out.println("meth");
        System.out.println(a);
        // System.out.println(b);
    }
    void meth3(){
        System.out.println("meth2");
        System.out.println(a);
        System.out.println(b);
    }
    
}
public class App {
    int b=7;
    void meth2(){
        System.out.println(b);
    }

    
    public static void main(String[] args) throws Exception {
        
        
        System.out.println("Hello, World!");
        testClass t1=new testClass();
        t1.meth3();
        // t1.meth();
        testClass.meth();
        // testClass.meth();
       
}
}
