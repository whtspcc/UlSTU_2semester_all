public class BubbleSort {
    
    // сложность O(n^2)
    // имеется вложенный цикл

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            // n - i - 1, так как последние i элементов уже на своих местах
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // обмен элементами
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // если за проход не было ни одного обмена, массив отсортирован
            if (!swapped) break;
        }
    }
}
