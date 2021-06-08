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
        WebThread t1=new WebThread(f1,1,4175);
        WebThread t2=new WebThread(f2,4176,8350);
        WebThread t3=new WebThread(f3,8351,12525);
        WebThread t4=new WebThread(f4,12526,16700);
        WebThread t5=new WebThread(f5,16701,20874);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
