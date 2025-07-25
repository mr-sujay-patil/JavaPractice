package Interview;

import java.util.Collections;

public class Inheritance {
    interface A{

        //SAM
        void test();

        //default method
        default void defaultMethod() {
            System.out.println("A's default");
        }

        //static method
        static void StaticMethod() {
            System.out.println("A's static");
        }
    }
    interface B{

        //SAM
        void test();

        //default method with same name
        default void defaultMethod() {
            System.out.println("B's default");
        }

        //default method
        default void defMethod() {
            System.out.println("B's default");
        }

        //static method
        static void StaticMethod() {
            System.out.println("B's static");
        }
    }
    class Impl implements A,B{

        @Override
        public void test() {
            System.out.println("test");
        }
        //call default method using super
        @Override
        public void defaultMethod() {
            A.super.defaultMethod();
        }

        @Override
        public void defMethod() {
            Impl impl = new Impl();
            impl.defMethod();
            impl.defaultMethod();
        }

        public static void checkStatic(){
            A.StaticMethod();
            B.StaticMethod();
        }

    }

    //overloading
    class Calculator {
        int add(int a, int b) {
            return a + b;
        }

        Object add(Exception a, double b) {
            return null;
        }
        Object add(ArithmeticException a, double b) {
            return null;
        }

    }


    public static void main(String[] args) {
        Impl impl= new Inheritance().new Impl();

        //SAM from A,B
        impl.test();

        //call default method with Object reference
        impl.defaultMethod();

        //call static method with Class name
        Impl.checkStatic();

        //call static method with Interface name
        B.StaticMethod();
    }
}
