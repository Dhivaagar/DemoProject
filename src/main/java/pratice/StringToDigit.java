package pratice;

public class StringToDigit {
    public static void main(String[] args) {
        char[] ch = ("Value:  10.464 kW").toCharArray();
        StringBuilder str= new StringBuilder();
        for(char c : ch)
        {
            if(Character.isDigit(c))
                str.append(c);
        }
        System.out.println(str);
    }
}
