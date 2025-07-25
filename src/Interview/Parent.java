package Interview;

class Parent {
    int x=10;
    static {
        System.out.println("StaticBlockParent");
    }
    public void impl(){
        System.out.println("Parent");
    }
}

class Child extends Parent{
    int x=20;
    static {
        System.out.println("StaticBlockChild");
    }
    public void impl(){
        //super.impl();
        System.out.println("Child");
    }

    public static void main(String[] args) {
        Parent p =new Child();
        p.impl();
        System.out.println(p.x);
    }
}
