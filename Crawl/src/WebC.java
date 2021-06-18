import java.io.*;

/**
 * java实现爬虫
 */
public class WebC {
    public static void main(String[] args) throws IOException {
        String f1="C:\\Users\\18359\\Desktop\\collections10.txt";
        String f2="C:\\Users\\18359\\Desktop\\collections20.txt";
        String f3="C:\\Users\\18359\\Desktop\\collections30.txt";
        String f4="C:\\Users\\18359\\Desktop\\collections40.txt";
        String f5="C:\\Users\\18359\\Desktop\\collections50.txt";
        WebThread t1=new WebThread(f1,1,600);
        WebThread t2=new WebThread(f2,601,1200);
        WebThread t3=new WebThread(f3,1201,1800);
        WebThread t4=new WebThread(f4,1801,2400);
        WebThread t5=new WebThread(f5,2401,3067);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
