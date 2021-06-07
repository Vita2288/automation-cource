package vkucheruk.firstLesson;

public class Task8 {
    public static void main(String[] args) {
        checkSeason(13);
        checkSeason(0);
        checkSeason(7);
        checkSeason(9);
    }

    public static void checkSeason(int month) {
        if (month < 1 || month > 12) {
            System.out.println("Wrong number of month: " + month);
            return;
        }

        switch (month) {
                case 1:
                case 2:
                case 12:
                    System.out.println("winter");
                    break;

                case 3:
                case 4:
                case 5:
                    System.out.println("spring");
                    break;

                case 6:
                case 7:
                case 8:
                    System.out.println("summer");
                    break;

                case 9:
                case 10:
                case 11:
                    System.out.println("fall");
                    break;
        }


    }
}
