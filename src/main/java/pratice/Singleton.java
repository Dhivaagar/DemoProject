package pratice;

public final class Singleton {
    private static Singleton single = new Singleton();
    private Singleton() {}
    public static Singleton instenceOf() {
        return single;
    }
    public static void main(String[] args){
        Singleton s1 = Singleton.instenceOf();
        Singleton s2 = Singleton.instenceOf();

        System.out.println(s1==s2);

    }
}