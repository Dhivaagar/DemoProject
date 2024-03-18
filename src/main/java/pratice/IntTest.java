package pratice;

public class IntTest {
    protected static boolean num;
    public static void main(String[] args) {
        String[] str = ("10.464 kW").split(" "); //"10464"
        String i = str[0].replace(".","");
        System.out.println(i);
    }
}
