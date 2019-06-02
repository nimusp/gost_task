package inc.myself;

import org.junit.Test;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TaskListTest {

    @Test
    public void hundredTest_twoCount() {
        String result = FirstTask.processHundred();
        long twoCount = Arrays.stream(result.split(" "))
                .filter(word -> word.equals("Two"))
                .count();

        assertEquals(43, twoCount);
    }

    @Test
    public void hundredTest_sevenCount() {
        String result = FirstTask.processHundred();
        long sevenCount = Arrays.stream(result.split(" "))
                .filter(word -> word.equals("Seven"))
                .count();

        assertEquals(7, sevenCount);
    }

    @Test
    public void hundredTest_twoSevenCount() {
        String result = FirstTask.processHundred();
        long twoSevenCount = Arrays.stream(result.split(" "))
                .filter(word -> word.equals("TwoSeven"))
                .count();

        assertEquals(7, twoSevenCount);
    }

    @Test
    public void calculationTest_same() {
        BigInteger result = SecondTask.calculate(BigInteger.valueOf(2), BigInteger.valueOf(2));
        assertEquals(BigInteger.ZERO, result);
    }

    @Test
    public void calculationTest_smallNumbers() {
        BigInteger result = SecondTask.calculate(BigInteger.valueOf(5), BigInteger.valueOf(2));
        assertEquals(BigInteger.valueOf(10), result);
    }

    @Test
    public void calculationTest_bigNumbers() {
        BigInteger result = SecondTask.calculate(BigInteger.valueOf(1000), BigInteger.valueOf(42));
        assertEquals(new BigInteger("297242911333923795640059429176065863139989673213703918037987737481286092000"), result);
    }

    @Test
    public void parseTextTest() {
        Map<String, Long> wordToCountMap = ThirdTask.getWordToCountMap("Lorem ipsum dolor sit amet, consectetur" +
                " adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua." +
                " Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo" +
                " consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat" +
                " nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia" +
                " deserunt mollit anim id est laborum.");

        assertNull(wordToCountMap.get("test"));
        assertEquals(1L, wordToCountMap.get("lorem").longValue());
        assertEquals(2L, wordToCountMap.get("dolor").longValue());
        assertEquals(3L, wordToCountMap.get("in").longValue());
    }
}