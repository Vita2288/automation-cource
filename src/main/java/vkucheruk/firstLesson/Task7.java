package vkucheruk.firstLesson;

public class Task7 {
    private String name = "человек";

    public void setName(String name) {
        name = name;
    }

    public static void main(String[] args) {
        Human human = new Human();
        human.setName("Макс");
        System.out.println(human.getName());
    }


}
