public class Arraysum {
    // sum of array elements excluding the current index
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int n = arr.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    sum += arr[j];
                }
            }
            result[i] = sum;
        }
        System.out.println("Resultant array: " + java.util.Arrays.toString(result));
    }
}
