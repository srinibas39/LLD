

public class ThreadSafeLockedSingleton{

    private static ThreadSafeLockedSingleton instance;

    public ThreadSafeLockedSingleton(){
        System.err.println("ThreadSafeLockedSingleton");
    }

    public static ThreadSafeLockedSingleton getInstance(){
        synchronized(ThreadSafeLockedSingleton.class){
            if(instance == null){
                instance = new ThreadSafeLockedSingleton();
            }
            return instance;
        }
    }
    public static void main(String[] args) {
        ThreadSafeLockedSingleton s1 = ThreadSafeLockedSingleton.getInstance();
        ThreadSafeLockedSingleton s2 = ThreadSafeLockedSingleton.getInstance();

        System.out.println(s1 == s2);
    }
}