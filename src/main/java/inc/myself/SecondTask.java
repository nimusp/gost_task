package inc.myself;

import java.math.BigInteger;

/**
 * Написать программу,вычисляющую для любых натуральных m и r,
 * таких что r ≤ m, значение функции:
 * f(m, r) = m! / ( r! * (m - r)!)
 */
public class SecondTask {

    public static BigInteger calculate(BigInteger m, BigInteger r) {
        // m >= r
        if (m.subtract(r).equals(BigInteger.ZERO)) return BigInteger.ZERO;

        BigInteger fractionTop = calculateFactorial(m);
        BigInteger fractionBottomFirst = calculateFactorial(r);
        BigInteger fractionBottomSecond = calculateFactorial(m.subtract(r));
        BigInteger fractionBottom = fractionBottomFirst.multiply(fractionBottomSecond);

        return fractionTop.divide(fractionBottom);
    }

    private static BigInteger calculateFactorial(BigInteger number) {
        if (number.equals(BigInteger.ONE)) return BigInteger.ONE;

        BigInteger previousNumber = number.subtract(BigInteger.ONE);
        return number.multiply(calculateFactorial(previousNumber));
    }
}
