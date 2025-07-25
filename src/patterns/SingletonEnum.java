package patterns;

// The enum values are implicitly static and final, so there's exactly one instance.
// Enum singletons are thread-safe by default.
// Normally, to preserve singleton property during serialization, you must implement readResolve() method. No need here.
// Reflection can break traditional singletons by accessing private constructors.
public enum SingletonEnum {
    INSTANCE;

    public String doSomething(){
        return "Using ENUM Instance";
    }
}

//	•	Java guarantees only one instance.
//	•	Safe from Reflection, Serialization.
//	•	Thread-safe by default.