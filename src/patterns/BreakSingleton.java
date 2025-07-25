package patterns;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class BreakSingletonStaticInnerClass{
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<SingletonStaticInnerClass> constructor=SingletonStaticInnerClass.class.getDeclaredConstructor();
        constructor.setAccessible(true);

//        SingletonStaticInnerClass SingletonStaticInnerClassUsingReflection=constructor.newInstance();
//        SingletonStaticInnerClass SingletonStaticInnerClassLegit =SingletonStaticInnerClass.getInstance();

//        Constructor<SingletonEnum> constructorEnum=SingletonEnum.class.getDeclaredConstructor();
//        SingletonEnum singletonEnum=constructorEnum.newInstance();
        SingletonEnum singletonEnum=SingletonEnum.INSTANCE;
        String singletonEnumDoSomething=SingletonEnum.INSTANCE.doSomething();

//        System.out.println(SingletonStaticInnerClassLegit);
        System.out.println(singletonEnumDoSomething);

    }
}