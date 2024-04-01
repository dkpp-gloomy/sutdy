package dkpp.study.algorithm.sort;

import java.util.Arrays;

public class SortMain {

    private static final int[] arr = new int[]{5, 3, 6, 8, 9, 7, 4, 2, 1};

    public static void main(String[] args) {
        int[] result = FastSort.sort(arr);
        Arrays.stream(result).forEach(a -> System.out.print(a + " "));
        System.out.println();
    }

}
