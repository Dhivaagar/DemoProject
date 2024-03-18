package pratice;

public class MatrixPattern {
    public static int max = 100;
    public static void main(String[] args) {
        int num = 5;
        printPattern(num);
    }
    public static void printPattern(int num) {
        int[][] arr = new int[max][max];
        int size = (num * 2) - 1;
        int start = 0;
        int end = size - 1;
        while (num != 0) {
            for (int i = start; i <= end; i++) {
                for (int j = start; j <= end; j++) {
                    if (i == start || i == end || j == start || j == end) {
                        arr[i][j] = num;
                    }
                }
            }
            num--;
            start++;
            end--;
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
