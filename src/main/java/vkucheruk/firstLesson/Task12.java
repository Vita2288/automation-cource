package vkucheruk.firstLesson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task12 {
    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        Task12.even = 0;
        Task12.odd = 0;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputText = reader.readLine();

        for (char charNumber: inputText.toCharArray()){
            int number = charNumber;
            if (number % 2 == 0){
                even++;
            } else {
                odd++;
            }
        }

       System.out.println("Even: " + even + " Odd: " + odd);
    }
}
