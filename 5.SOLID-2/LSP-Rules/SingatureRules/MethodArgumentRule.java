// Method Argument Rule : 
// Subtype method arguments can be identical or wider than the supertype
// Java enforces this by requiring the same method signature for overrides

class Parent {
    public void print(String msg) {
        System.out.println("Parent: " + msg);
    }
    public void execute(int data){
        System.out.println("executing parent"+data);
    }
}

class Child extends Parent {
    @Override
    public void print(String msg) {
        System.out.println("Child: " + msg);
    }

    @Override
    public void execute(int data){
        System.out.println("executing child"+data);
    }
}

// Client that passes a String msg as the client expects.
class Client {
    private Parent p;

    public Client(Parent p) {
        this.p = p;
    }

    public void printMsg() {
        p.print("Hello");
    }

    public void executeData(){
        p.execute(2);
    }
}

public class MethodArgumentRule {
    public static void main(String[] args) {
        Parent parent = new Parent();
        Parent child  = new Child();

        Client client = new Client(parent);
        //Client client = new Client(child);

        client.printMsg();
        client.executeData();
    }
}
