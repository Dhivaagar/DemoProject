package pratice;

public class UserName {
    public static void main(String[] args) {
        String str = ("Hey test autostorage,");
        String[] names = str.split(" ");
        String firstName = names[1];
        String lastName = names[2].substring(0, names[2].length() - 1);
        System.out.println(firstName + " " + lastName);
    }
}
