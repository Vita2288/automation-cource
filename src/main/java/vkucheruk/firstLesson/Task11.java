package vkucheruk.firstLesson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task11 {
    public static int max = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String text = "The max is ";
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());


        if (a < b){
            max = b;
        } else{
            max = a;
        }

        System.out.println(text + max);
    }
}

// max = (a < b) ? b : a;
