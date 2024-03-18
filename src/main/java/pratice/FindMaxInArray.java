package pratice;

/**
 * without using additional array and sort array
 */
public class FindMaxInArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        System.out.println(findMax(arr));
    }

    public static int findMax(int[] arr) {
        int max=0, secMax=0, maxIndex=0;
        for (int i=0; i<arr.length; i++) {
            if (arr[i]>max) {
                secMax = max;
                max=arr[i];
                maxIndex=i;
            } else if (arr[i]>secMax && secMax<max) {
                secMax=arr[i];
            }
        }
        System.out.println(max + " " + secMax);
        return max>secMax*2 ? maxIndex : -1;
    }
}
