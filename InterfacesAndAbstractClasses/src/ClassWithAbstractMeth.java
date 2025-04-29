public abstract class ClassWithAbstractMeth {
    //static and abstract do not go together
    //public abstract static int absMeth1(String s);

    //private ad abstract do not go together
    //private abstract String absMeth2();

    public abstract String absMeth3(int num);
    protected abstract boolean absMeth4(String str);
    abstract float absMeth5(int num, String str);

    public static void main(String[] args) {
        System.out.println("This is a class with abstract methods");
    }
}
