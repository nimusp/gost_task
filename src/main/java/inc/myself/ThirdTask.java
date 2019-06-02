package inc.myself;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * На вход программе подается литературный текст.
 * Программа должна вывести список слов, встречающихся в тексте,
 * в котором для каждого слова указывается количество вхождений этого слова в текст,
 * а слова выводятся в порядке убывания частоты вхождения.
 */
public class ThirdTask {

    public static void main(String[] args) {
        Map<String, Long> wordToCountMap = getWordToCountMap("test. string, with duplicates, test");
        for (Map.Entry<String, Long> pair : wordToCountMap.entrySet()) {
            System.out.println("Word \"" + pair.getKey() + "\" appeared " + pair.getValue() + " times.");
        }
    }

    public static Map<String, Long> getWordToCountMap(String text) {
        String textWithoutPunctuation = text
                .replaceAll("\\.", "")
                .replaceAll(",", "");

        LinkedHashMap<String, Long> resultMap = Arrays.stream(textWithoutPunctuation.split(" "))
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        e -> e.getKey().toLowerCase(),
                        Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new)
                );

        for (Map.Entry<String, Long> pair : resultMap.entrySet()) {
            System.out.println("Word \"" + pair.getKey() + "\" appeared " + pair.getValue() + " times.");
        }

        return resultMap;
    }
}
