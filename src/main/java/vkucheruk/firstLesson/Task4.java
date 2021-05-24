package vkucheruk.firstLesson;

public class Task4 {

    public static void main(String[] args) {
        System.out.println(convertToSeconds(1));
        System.out.println(convertToSeconds(2));
    }


    public static int convertToSeconds(int hour){
        hour = hour * 60 * 60;
        return  hour;
    }
}
