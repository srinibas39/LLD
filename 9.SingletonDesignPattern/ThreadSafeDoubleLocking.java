

public class ThreadSafeDoubleLocking{

//     Without volatile, one thread might see a partially constructed object due to instruction reordering.

// volatile ensures visibility and ordering — the write to instance is seen by all threads after construction is complete.

    private static volatile ThreadSafeDoubleLocking instance;

    public ThreadSafeDoubleLocking(){
        System.out.println("Thread Safe double locking");
    }

    public static ThreadSafeDoubleLocking getInstance(){
        if(instance == null){ // first check lock is present
            synchronized(ThreadSafeDoubleLocking.class){
                if(instance == null){
                    //some thread might have parially inatilaized
                    instance = new ThreadSafeDoubleLocking();
                }
            }

        }
        return instance;
    }

    public static void main(String[] args) {
        ThreadSafeDoubleLocking s1 = ThreadSafeDoubleLocking.getInstance();
        ThreadSafeDoubleLocking s2 = ThreadSafeDoubleLocking.getInstance();

        System.out.println(s1 == s2);
    }
}