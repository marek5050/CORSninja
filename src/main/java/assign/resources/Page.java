package assign.resources;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "page")
public class Page {

    @XmlElement
    public String url;

    @XmlElement
    public String method;

    @XmlElement
    public String status;

    @XmlElement
    public String body;



    public Page(){
        url="";
        status="";
        body="";
        method="";
    }

    public Page(String _url,String _method){
        this.url = _url;
        this.method = _method;
    }

    public Page(String url, String status, String body){
        this.url=url;
        this.status=status;
        this.body=body;
    }

    public void processRequest(){
        try {
            Connection request = Jsoup.connect(url).followRedirects(true);
            Document doc= new Document(url);


            if("GET".equalsIgnoreCase(method)){
                doc = request.get();
            }else if("POST".equalsIgnoreCase(method)) {
                doc = request.post();
            }else{
                throw new Exception("Invalid request method");
            }

            body = doc.html();
            status= "200";

        }catch(Exception e){

            e.printStackTrace();
            status = "400";
        }

    }
}
