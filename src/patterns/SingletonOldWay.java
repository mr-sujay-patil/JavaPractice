package patterns;

import java.lang.reflect.Constructor;

public class SingletonOldWay {

    private static SingletonOldWay SingletonOldWay;

    private SingletonOldWay() {
        if(SingletonOldWay!=null){
            throw new RuntimeException("Use getInstance");
        }
    }

    public static SingletonOldWay getInstance() {
        if (SingletonOldWay == null) { //first check
            synchronized (SingletonOldWay.class) { //second check
                if (SingletonOldWay == null) {
                    SingletonOldWay = new SingletonOldWay();
                }
            }
        }
        return SingletonOldWay;
    }
}


