package vkucheruk.firstLesson;

public class Task3 {
    public static void main(String[] args) {
        System.out.println(min(12, 33));
        System.out.println(min(-20, 0));
        System.out.println(min(-10, -20));
    }

    static int min;

    public static int min(int a, int b) {
        if (a < b) {
            min = a;
        } else
            min = b;
            return min;
        }



}


