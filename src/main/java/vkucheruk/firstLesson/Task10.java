package vkucheruk.firstLesson;
public class Task10 {

    public static void main(String[] args) {
    Dog dog = new Dog();
    }

    public static class Dog {
        String name;
        int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

    }
}
