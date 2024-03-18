package pratice;

public class PrintMirrorChar {
    public static void main(String[] args) {
        String input = "aUc";

        System.out.println("Original: " + input);

        StringBuilder mirrorImage = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if (currentChar>='a' && currentChar<='z') {
                char mirroredChar = (char) ('z' - (currentChar - 'a'));
                mirrorImage.append(mirroredChar);
            } else if(currentChar>='A' && currentChar<='Z') {
                char mirroredChar = (char) ('Z' - (currentChar - 'A'));
                mirrorImage.append(mirroredChar);
            } else {
                mirrorImage.append(currentChar);
            }
        }

        System.out.println("Mirror Image: " + mirrorImage);
    }
}
