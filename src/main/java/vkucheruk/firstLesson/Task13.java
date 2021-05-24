package vkucheruk.firstLesson;
import java.io.IOException;


public class Task13 {
    public static void main(String[] args) throws Exception {
        int[] array = initializeArray();
        int max = max(array);
        System.out.println(max);
    }

    private static int[] initializeArray()  throws IOException {
       int[]  array = new int[] {101, 75, 95, 83, 10, 100};
       return array;
    }

    public static int max(int[] array) {
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max)
                max = array[i];
        }

        return max;
    }
}
