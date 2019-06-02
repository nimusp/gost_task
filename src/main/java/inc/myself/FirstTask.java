package inc.myself;

import java.util.Arrays;

/**
 * Написать программу, которая выводит числа от 1 до 100,
 * но вместо чисел, кратных 2, нужно выводить строку Two,
 * вместо чисел, кратных 7 - строку Seven,
 * вместо чисел кратных, 2 и 7 - строку TwoSeven.
 */
public class FirstTask {

    public static void main(String[] args) {
        String resultString = processHundred();

        Arrays.stream(resultString.split(" "))
                .forEach(System.out::println);
    }

    public static String processHundred() {
        StringBuilder builder = new StringBuilder();

        for (int i = 1; i < 101; i++) {
            String current = String.valueOf(i);

            if (i % 2 == 0) {
                current = "Two";
            }
            if (i % 7 == 0) {
                current = "Seven";
            }
            if (i % 2 == 0 && i % 7 == 0) {
                current = "TwoSeven";
            }

            builder.append(" ")
                    .append(current);
        }
        return builder.toString();
    }
}
