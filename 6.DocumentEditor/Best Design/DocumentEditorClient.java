
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


interface DocumentElement{
    public abstract String render();
}

class TextElement implements DocumentElement{

    private String text;

    public TextElement(String text){
        this.text = text;
    }

    @Override
    public String render(){
        return this.text;
    }
}

class ImageElement implements DocumentElement{

    private String image;

    public ImageElement(String image){
        this.image = image;
    }

    @Override
    public String render(){
        return this.image;
    }

}
class NewLineElement implements DocumentElement{
    
    private String newLine;

      @Override
    public String render(){
        return "\n";
    }

}

class TabSpaceElement implements  DocumentElement{
    private String tabSpace;

    @Override
    public String render(){
        return "\t";
    }
}



class Document{
    List<DocumentElement> documents;


    public Document(){
        this.documents = new ArrayList<>();
    }

    public void addELement(DocumentElement ele){
        documents.add(ele);
    }

    public List<DocumentElement> getDocuments(){
        return this.documents;
    }

 
}

class DocumentRender{
    List<DocumentElement> documents;
    public DocumentRender(Document document){
        this.documents = document.getDocuments();
    }

       public String render(){
        String res = "";
        StringBuilder sb = new StringBuilder();
        for(DocumentElement doc : this.documents){
        
            sb.append(doc.render());

            res =  sb.toString();
        }
        return res;
    }
}

interface Persistence{
    void save(String data);
}

class DbPersistence implements  Persistence{

    @Override
    public void save(String data){
        System.out.println("Saving in Db");
    }

}

class FilePeristence implements  Persistence{

    @Override
    public void save(String data){
        try {
              FileWriter writer = new FileWriter("output.txt");
              writer.append(data);
              writer.close();
              System.out.println("File persisted");

        } catch (IOException eO) {
            System.out.println("Error in saving a file");
        }
    }

}

class DocumentEditor{
    
    //has a storage and has a Document

    private Document document;
    private Persistence storage;
    private DocumentRender documentRender;
    private String renderedDocument = "";

    public DocumentEditor(Document document , Persistence storage , DocumentRender documentRender){
        this.document = document;
        this.storage = storage;
        this.documentRender = documentRender;
    }

    public void addText(String text){
        document.addELement(new TextElement(text));
    }

    public void addImage(String image){
        document.addELement(new ImageElement(image));
    }

    public void addTab(){
        document.addELement(new TabSpaceElement());
    }

    public void newLine(){
        document.addELement(new NewLineElement());
    }

    public String renderDocument(){
        if(this.renderedDocument.isEmpty()){
            this.renderedDocument = this.documentRender.render();
        }
        return this.renderedDocument;
    }

    public void save(){
        this.storage.save(this.renderedDocument);
    }



}

public class DocumentEditorClient{

    public static void main(String[] args) {
        Document doc = new Document();
        Persistence storage = new FilePeristence();
        DocumentRender docRender = new DocumentRender(doc);
        DocumentEditor editor = new DocumentEditor(doc,storage,docRender);

        editor.addText("Hello world");
        editor.addImage("capture.png");
        editor.addTab();
        editor.newLine();   
        System.err.println(editor.renderDocument());
        editor.save();
        

    }
    
 
}

