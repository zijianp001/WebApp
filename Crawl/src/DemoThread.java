import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class DemoThread extends Thread{
    private String StorePath;
    private String SourcePath;
    public DemoThread(String storePath,String sourcePath){
        this.StorePath=storePath;
        this.SourcePath=sourcePath;
    }

    @Override
    public void run() {
        try {
            this.CrawlPage();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void CrawlPage() throws IOException {
        BufferedReader in=null;
        BufferedWriter out=null;
        try {
            in = new BufferedReader(new FileReader(SourcePath));
            out = new BufferedWriter(new FileWriter(StorePath));
            String beta;
            while ((beta = in.readLine()) != null) {
                System.out.println(beta);
                Set<String> selectRule = new HashSet<>();
                selectRule.clear();
                selectRule.add("td[align=center][bgcolor=#FFFFFF]");
                selectRule.add("span[id=ctl00_pagebottom_Label_CompanyInfo]");
                CrawlMeta crawlMeta = new CrawlMeta();
                crawlMeta.setUrl(beta); // set website to crawl
                crawlMeta.setSelectorRules(selectRule); // set content class
                SimpleCrawlJob job = new SimpleCrawlJob();
                job.setCrawlMeta(crawlMeta);
                job.doFetchPage();
                Result result = job.getCrawlResult();
                System.out.println(result.toString());
                out.write(beta + " " + result.toString() + "\r\n");
            }
            out.close();
            in.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                if(out != null) {
                    out.close();
                }
                if(in !=null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String args[]) {
        String s1="C:\\Users\\18359\\Desktop\\collections10.txt";
        String s2="C:\\Users\\18359\\Desktop\\collections20.txt";
        String s3="C:\\Users\\18359\\Desktop\\collections30.txt";
        String s4="C:\\Users\\18359\\Desktop\\collections40.txt";
        String s5="C:\\Users\\18359\\Desktop\\collections50.txt";
        String d1="C:\\Users\\18359\\Desktop\\d1.txt";
        String d2="C:\\Users\\18359\\Desktop\\d2.txt";
        String d3="C:\\Users\\18359\\Desktop\\d3.txt";
        String d4="C:\\Users\\18359\\Desktop\\d4.txt";
        String d5="C:\\Users\\18359\\Desktop\\d5.txt";
        DemoThread th1=new DemoThread(d1,s1);
        DemoThread th2=new DemoThread(d2,s2);
        DemoThread th3=new DemoThread(d3,s3);
        DemoThread th4=new DemoThread(d4,s4);
        DemoThread th5=new DemoThread(d5,s5);
        th1.start();
        th2.start();
        th3.start();
        th4.start();
        th5.start();
    }
}
