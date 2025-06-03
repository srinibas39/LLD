
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


class DocumentEditor{
    private List<String> documents;

    private String renderedDocuemnt;

    public DocumentEditor(){
        this.documents = new ArrayList<>();
        this.renderedDocuemnt = "";
    }

    public void addText(String text){
        documents.add(text);
    }

    public void addImage(String imagePath){
        documents.add(imagePath);
    }

    public void saveToFile(){
        try {
            FileWriter writer = new FileWriter("document.txt");
            writer.write(this.renderedDocuemnt);
            writer.close();
            System.out.println("Docuemnt save to docuemnt.tx");
        } catch (IOException e) {
            System.out.println("Unable to optn file for writing");
        }
    }

    public String renderedDocuemnt(){
       if(renderedDocuemnt.isEmpty()){
         //trhn add
         StringBuilder str = new StringBuilder();
          for(String doc : documents){
            if(doc.length() > 4 && (doc.endsWith("jpg") || doc.endsWith("png"))){
                str.append("Image: ").append(doc).append("\n");
            }
            else{
                //text
                str.append(doc).append("\n");
            }
          }
          this.renderedDocuemnt =  str.toString();
       }
       return this.renderedDocuemnt;
    }
}

public class DocumentEditorClient {
    public static void main(String[] args) {
        DocumentEditor doc = new DocumentEditor();
        doc.addText("Hello world");
        doc.addImage("capture.png");
        doc.addText("Bye world");
        doc.renderedDocuemnt();
        doc.saveToFile();
    }
}