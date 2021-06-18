import org.jsoup.nodes.Document;

import java.util.List;
import java.util.Map;

public class Result {

    /**
     * 爬取的网址
     */
    private String url;

    private Status status;

    /**
     * 爬取的网址对应的 DOC 结构
     */
    private Document htmlDoc;


    private Map<String, List<String>> result;

    public void setResult(Map<String, List<String>> presult) {
        this.result = presult;
    }

    public Map<String, List<String>> getResult() {
        return result;
    }

    public void setHtmlDoc(Document phtmlDoc) {
        this.htmlDoc = phtmlDoc;
    }

    public Document getHtmlDoc() {
        return htmlDoc;
    }
    public void setStatus(int code, String msg) {
        this.status = new Status(code, msg);
    }


    @Override
    public String toString() {
        if(result==null) {
            return "[";
        }
        String aaa="";
        for(Map.Entry<String, List<String>> entry : result.entrySet()){
            aaa+=entry.getValue();
        }
        return aaa;
    }

    public void setUrl(String purl) {
        this.url=purl;
    }


    static class Status {
        private int code;
        private String msg;
        public Status(int aCode, String aMsg){
            this.code=aCode;
            this.msg=aMsg;
        }

        @Override
        public String toString() {
            return "Status{" +
                    "code=" + code +
                    ", msg='" + msg + '\'' +
                    '}';
        }

        public String getMsg() {
            return msg;
        }

        public void setCode(int aCode) {
            this.code = aCode;
        }

        public int getCode() {
            return code;
        }

        public void setMsg(String aMsg) {
            this.msg = aMsg;
        }
    }
}