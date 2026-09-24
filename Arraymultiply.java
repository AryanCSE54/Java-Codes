public class Arraymultiply{
    // product of array elements excluding the current index
    public static void main(String[] args) {
        int[] arr = {1, 2, 0, 4};
        int n = arr.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int product = 1;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    product *= arr[j];
                }
            }
            result[i] = product;
        }
        System.out.println("Resultant array: " + java.util.Arrays.toString(result));
    }
}