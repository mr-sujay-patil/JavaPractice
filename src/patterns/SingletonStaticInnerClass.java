package patterns;

public class SingletonStaticInnerClass {

    //private constructor
    private SingletonStaticInnerClass() {
        //to prevent creating a instance using reflections
        throw new RuntimeException("Use getInstance");
    }

    public static SingletonStaticInnerClass getInstance() {
        return Holder.INSTANCE;
    }

    // Static inner class - inner classes are not loaded until they are referenced
    private static class Holder {
        private static final SingletonStaticInnerClass INSTANCE = new SingletonStaticInnerClass();
    }
}

/*
What happens internally:
When SingletonStaticInnerClass class is loaded, the Holder class is not loaded.
Only when you call SingletonStaticInnerClass.getInstance(), Holder class gets loaded, and the INSTANCE is initialized.
This behavior ensures lazy initialization — the instance is created only when needed.
It also ensures thread-safety due to the JVM's class loading mechanism,
which guarantees that a class is loaded and initialized only once, even in multi-threaded environments.
*/
