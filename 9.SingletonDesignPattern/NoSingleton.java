


public class NoSingleTon{
    public NoSingleTon(){
        System.out.println("Singleton constructor called");
    }
    public static void main(String[] args) {
        NoSingleTon s1 = new NoSingleTon();
        NoSingleTon s2 = new NoSingleTon();

        System.out.println(s1 == s2);
    }
}
