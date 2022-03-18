package lect4_singleton;
//this some how waste memory while creating an instance that could be unecessary to be used
class EagerInitialization {
    private static EagerInitialization INSTANCE = new EagerInitialization();
    private EagerInitialization() {}
    public static EagerInitialization getInstance() {
        return INSTANCE;
    }
}
//this could preven eager initialization, but not good for multi-threading
class LazyInitialization{
    private static LazyInitialization INSTANCE = null;
    private LazyInitialization() {}
    public static LazyInitialization getInstance() {
         if(INSTANCE==null) {
             INSTANCE= new LazyInitialization();
         }
         return INSTANCE;
    }
}
//these are safe for multi-threading
class ThreadSafeSingleton{
    private static ThreadSafeSingleton INSTANCE = null;
    private ThreadSafeSingleton(){}
    public static synchronized ThreadSafeSingleton getInstance() {
        if(INSTANCE==null){
            INSTANCE= new ThreadSafeSingleton();
        }
        return INSTANCE;
    }
}
class ThreadSafeUpgradeSingleton{
    private static ThreadSafeUpgradeSingleton INSTANCE = null;
    private ThreadSafeUpgradeSingleton(){}
    public static ThreadSafeUpgradeSingleton getInstance() {
        if(INSTANCE==null){
            synchronized(ThreadSafeUpgradeSingleton.class){
                if(INSTANCE==null){
                    INSTANCE= new ThreadSafeUpgradeSingleton();
                }
            }
        }
        return INSTANCE;
    }
}