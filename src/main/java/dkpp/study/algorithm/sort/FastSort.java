package dkpp.study.algorithm.sort;

public class FastSort {
    public static int[] sort(int[] arr) {
        fastSort(arr, 0, arr.length - 1);
        return arr;
    }

    private static void fastSort(int[] arr, int low, int high) {
        /**
         * i             用于循环的low+1<->high
         * temp          用于交换
         * tempIndex     用于标记从low算，第几个位置属于中值的位置
         */
        if (low < high) {
            int tempIndex = low;
            for (int i = low + 1; i <= high; i++)
                if (arr[i] < arr[low]) {
                    tempIndex++;
                    int temp = arr[tempIndex];
                    arr[tempIndex] = arr[i];
                    arr[i] = temp;
                }
            int temp = arr[low];
            arr[low] = arr[tempIndex];
            arr[tempIndex] = temp;
            fastSort(arr, low, tempIndex - 1);
            fastSort(arr, tempIndex + 1, high);
        }
    }


    private static void fastSort1(int[] arr, int low, int high) {
        // 如果low=high，即数组中只剩一个元素时，直接返回
        if (low >= high) {
            return;
        }
        // 设置最左边的元素为基准值
        int key = arr[low];
        //数组中比key小的放在左边，比key大的放在右边
        int i = low;
        int j = high;
        while (i < j) {
            //j向左移动，直到碰到比key小的数
            while (arr[j] >= key && i < j) {
                j--;
            }
            //i向右移动，直到碰到比key大的数
            while (arr[i] <= key && i < j) {
                i++;
            }
            //i和j指向的元素交换
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        arr[low] = arr[i];
        arr[i] = key;
        fastSort1(arr, low, i - 1);
        fastSort1(arr, i + 1, high);
    }
}
