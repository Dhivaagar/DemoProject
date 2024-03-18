package pratice;
public class SpiralMatrixPattern {

    public static void main(String[] args) {
        int count = 0;
        int[][] arr = {{1, 2, 3, 4, 5},
                {16,17,18,19,6},
                {15,24,25,20,7},
                {14,23,22,21,8},
                {13,12,11,10,9}};


        int[] resultArr = new int[arr.length * arr[0].length];

        int rowStart = 0, rowEnd = arr.length-1;
        int colStart = 0, colEnd = arr[0].length-1;

        while (rowStart<=rowEnd && colStart<=colEnd) {

            //column right to left
            for (int i=colStart; i<=colEnd; i++) {
                resultArr[count++] = arr[rowStart][i];
            }
            rowStart++;

            //row up to down
            for (int i=rowStart; i<=rowEnd; i++) {
                resultArr[count++] = arr[i][colEnd];
            }
            colEnd--;

            //column left to right
            for (int i=colEnd; i>=colStart; i--) {
                resultArr[count++] = arr[rowEnd][i];
            }
            rowEnd--;

            //row down to up
            for (int i=rowEnd; i>=rowStart; i--) {
                resultArr[count++] = arr[i][colStart];
            }
            colStart++;
        }

        for (int j : resultArr) {
            System.out.print(j + ", ");
        }
    }
}

