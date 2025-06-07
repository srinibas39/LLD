

public class ThreadSafeEagerSingleton{

    private static ThreadSafeEagerSingleton instance = new ThreadSafeEagerSingleton();

    public ThreadSafeEagerSingleton(){
        System.out.println("ThreadSafeEagerSingleton");
    }

    public static ThreadSafeEagerSingleton getInstance(){
        return instance;
    }
    public static void main(String[] args) {
        
        ThreadSafeEagerSingleton s1 = ThreadSafeEagerSingleton.getInstance();
        ThreadSafeEagerSingleton s2 = ThreadSafeEagerSingleton.getInstance();

        System.out.println(s1 == s2);
    }
}

//This is not preferred in production , In large or complex applications, the singleton might never be used — but it's still created at startup.

// If the constructor of the singleton is resource-heavy (e.g., opens DB connection, reads configs), it wastes memory and time unnecessarily.
//It is okay for small application