package src;

public class RowSummer {
    public static int arraySum(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
            System.out.print(num + "\t");  // debug
        }
        return sum;
    }

    public static int[] rowSum(int[][] arr2D) {
        int rows = arr2D.length;
        int[] sumList = new int[rows];

        for (int i = 0; i < rows; i++) {
            sumList[i] = arraySum(arr2D[i]);
            System.out.println(sumList[i]);  // debug
        }

        return sumList;
    }

   public static boolean isDiverse(int[][] arr2D) {
       int [] sums = rowSum(arr2D);
       int sumsLength = sums.length;
       for(int i = 0; i < sumsLength - 1; i++) {
           for (int j = i + 1; j < sumsLength; j++) {
               if (sums[i] == sums[j]) {
                   return false;
               }
           }
       }
       return true;
   }

    public static void main(String[] args) {
        int[][] mat1 = {
                { 1, 3, 2, 7, 3 },                       // row 1
                { 10, 10, 4, 6, 2 },                     // row 2
                { 5, 3, 5, 9, 6 },                       // row 3
                { 7, 6, 4, 2, 1 }                        // row 4
        };
        int[][] mat2 = {
                { 1, 1, 5, 3, 4 },                       // row 1
                { 12, 7, 6, 1, 9 },                      // row 2
                { 8, 11, 10, 2, 5 },                     // row 3
                { 3, 2, 3, 0, 6 }                        // row 4
        };

        System.out.println("Mat1 Diverse: " + isDiverse(mat1));
        System.out.println();
        System.out.println("Mat2 Diverse: " + isDiverse(mat2));
    }

}
