package vkucheruk.firstLesson;

public class Task2 {
    public static void main(String[] args) {


        Man man = new Man ();
        Woman woman = new Woman();

        woman.husband = man;
        man.wife = woman;


    }

    public static class Man{
        Woman wife;
    }

    public static class Woman {
        Man husband;
    }
}
