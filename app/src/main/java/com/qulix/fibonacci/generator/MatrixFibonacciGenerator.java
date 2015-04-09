package com.qulix.fibonacci.generator;

import java.math.BigInteger;

public class MatrixFibonacciGenerator implements FibonacciGenerator {

    /**
     * algorithm description
     * https://ru.wikibooks.org/wiki/%D0%92%D1%8B%D1%87%D0%B8%D1%81%D0%BB%D0%B5%D0%BD%D0%B8%D0%B5_%D1%87%D0%B8%D1%81%D0%B5%D0%BB_%D0%A4%D0%B8%D0%B1%D0%BE%D0%BD%D0%B0%D1%87%D1%87%D0%B8#.D0.A0.D0.B5.D1.88.D0.B5.D0.BD.D0.B8.D0.B5_.D0.B1.D1.8B.D1.81.D1.82.D1.80.D1.8B.D0.BC_.D0.B2.D0.BE.D0.B7.D0.B2.D0.B5.D0.B4.D0.B5.D0.BD.D0.B8.D0.B5.D0.BC_.D0.BC.D0.B0.D1.82.D1.80.D0.B8.D1.86.D1.8B_.D0.B2_.D1.81.D1.82.D0.B5.D0.BF.D0.B5.D0.BD.D1.8C
     */
    public BigInteger fibonacciForIndex(long index) {
        BigInteger a = BigInteger.ONE;
        BigInteger ta;

        BigInteger b = BigInteger.ONE;
        BigInteger tb;

        BigInteger c = BigInteger.ONE;
        BigInteger rc = BigInteger.ZERO;
        BigInteger tc;

        BigInteger d = BigInteger.ZERO;
        BigInteger rd = BigInteger.ONE;

        while (index > 0) {
            if (index % 2 == 1) {    // if odd
                tc = rc;
                rc = calculate_M2x2_MulCell(a, c, rc, rd);
                rd = calculate_M2x2_MulCell(tc, rd, b, d);
            }

            ta = a;
            tb = b;
            tc = c;
            a = calculate_M2x2_MulCell(a, c, a, b);
            b = calculate_M2x2_MulCell(ta, b, b, d);
            c = calculate_M2x2_MulCell(ta, c, c, d);
            d = calculate_M2x2_MulCell(tc, d, tb, d);

            index /= 2;
        }

        return rc;
    }

    private BigInteger calculate_M2x2_MulCell(BigInteger b1j, BigInteger b2j, BigInteger ai1, BigInteger ai2) {
        return ai1.multiply(b1j).add(ai2.multiply(b2j));
    }
}
