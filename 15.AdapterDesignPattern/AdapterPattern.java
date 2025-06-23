//https://www.notion.so/Adapter-Design-Pattern-21b16c3ab0a580058f68d629b31ad55b
interface IReport{
    String getJsonData(String data);
}

 class XMLDataProvider{

    //"Alice:42"
    public String getXMLData(String data){
        int sep = data.indexOf(':');
        String name = data.substring(0, sep);
        String age = data.substring(sep+1);

        return "<user>"+
        "<name>"+name+"</name>"
        +"<age>"+age+"</age>"
        +"</user>";
    }
}

class XMLDataProviderAdapter implements IReport{

    private XMLDataProvider xmlProvider;
    public XMLDataProviderAdapter(XMLDataProvider xmlProvider){
        this.xmlProvider = xmlProvider;
    }
    @Override
    public String getJsonData(String data){
        String xml = xmlProvider.getXMLData(data);

        // 2. Naïvely parse out <name> and <id> values
        int startName = xml.indexOf("<name>") + 6;
        int endName   = xml.indexOf("</name>");
        String name   = xml.substring(startName, endName);

        int startId = xml.indexOf("<age>") + 5;
        int endId   = xml.indexOf("</age>");
        String id    = xml.substring(startId, endId);

        // 3. Build and return JSON
        return "{\"name\":\"" + name + "\", \"id\":" + id + "}";
    }
}

class Client{
    public void getReport(IReport report , String rawData){
        System.out.println("Processed JSON " + report.getJsonData(rawData));
    }
}

public class AdapterPattern{
    public static void main(String[] args) {
        XMLDataProvider xmlProv = new XMLDataProvider();

        XMLDataProviderAdapter adapter = new XMLDataProviderAdapter(xmlProv);

        String rawData = "Mitra:23";
        Client client = new Client();
        client.getReport(adapter,rawData);

    }
}