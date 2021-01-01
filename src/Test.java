import jdk.swing.interop.SwingInterOpUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.WeakHashMap;

public class Test {

    public static void main(String[] args) {
        String[] words;
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader("SeatList")))) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                words = line.split("\t|\\s");

                for(String word:words){
                    System.out.println(word);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}