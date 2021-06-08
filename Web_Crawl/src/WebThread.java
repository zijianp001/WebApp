import java.io.*;
import java.net.URL;

public class WebThread extends Thread{
    private int lowPage;
    private int highPage;
    private String fileName;
    public WebThread(String name,int low,int high){
        this.fileName=name;
        this.lowPage=low;
        this.highPage=high;
    }


    @Override
    public void run() {
        PrintWriter p1= null;
        try {
            p1 = new PrintWriter(new FileWriter(this.fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        int i=lowPage;
        while(i<=highPage) {
            String a="http://shop.ebdoor.com/ShopList/022,"+i+".aspx";
            spiderURL(a,p1);
            i+=1;
        }
        p1.close();
    }
    public static void spiderURL(String url, PrintWriter w1){
        BufferedReader br=null;
        try{
            URL url1 = new URL(url);
            InputStream inStream = url1.openStream();
            br = new BufferedReader(new InputStreamReader(inStream,"GBK"));
            String line;
            while((line=br.readLine())!=null){
                if(line.contains("<a href=\"http://Shop.ebdoor.com/Shops/")) {
                    String[] aaa=line.split("\"");
                    w1.println(aaa[1]);
                    System.out.println(aaa[1]);
                }
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try {
                if(br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
