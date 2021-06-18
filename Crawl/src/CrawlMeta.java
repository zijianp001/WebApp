import java.util.HashSet;
import java.util.Set;

public class CrawlMeta {

    private String url;
    private Set<String> selectorRules;

    public CrawlMeta() {
    }


    public String getUrl() {
        return url;
    }
    public void setUrl(String purl) {
        this.url = purl;
    }
    public void setSelectorRules(Set<String> selectorRules) {
        this.selectorRules = selectorRules;
    }



    @Override
    public String toString() {
        return "CrawlMeta{" +
                "url='" + url + '\'' +
                ", selectorRules=" + selectorRules +
                '}';
    }

    //Prevent error statement if selected rules undefined
    public Set<String> getSelectorRules() {
        return selectorRules != null ? selectorRules : new HashSet<>();
    }

}