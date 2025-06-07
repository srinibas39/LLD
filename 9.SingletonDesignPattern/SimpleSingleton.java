
public class SimpleSingleton{

    private static SimpleSingleton instance = null;

    public SimpleSingleton(){
        System.out.println("Simple singleton constructor called");
    }

    private static SimpleSingleton getInstance(){
        if(instance == null){
            instance = new SimpleSingleton();
        }
        return instance;
    }

    public static void main(String[] args) {
        SimpleSingleton s1 = SimpleSingleton.getInstance();
        SimpleSingleton s2 = SimpleSingleton.getInstance();

        System.out.println(s1 == s2);
    }
}