package com.qulix.fibonacci;

import android.test.InstrumentationTestCase;

import com.qulix.fibonacci.generator.FibonacciGenerator;
import com.qulix.fibonacci.generator.SlideGenerator;

import java.math.BigInteger;

public class SlideGeneratorTest extends InstrumentationTestCase {

    public static final BigInteger FIB_THOUSAND = new BigInteger("43466557686937456435688527675040625802564660517371780402481729089536555417949051890403879840079255169295922593080322634775209689623239873322471161642996440906533187938298969649928516003704476137795166849228875");
    public static final BigInteger FIB_THOUSAND_AND_1 = new BigInteger("70330367711422815821835254877183549770181269836358732742604905087154537118196933579742249494562611733487750449241765991088186363265450223647106012053374121273867339111198139373125598767690091902245245323403501");
    private FibonacciGenerator mFibonacciGenerator;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mFibonacciGenerator = new SlideGenerator();
    }

    public void testZeroFibonacci() {
        final BigInteger zeroFibonacci = BigInteger.ZERO;
        final BigInteger calculatedFibonacci = mFibonacciGenerator.fibonacciForIndex(0);
        assertEquals(zeroFibonacci, calculatedFibonacci);
    }

    public void testFirstFibonacci() {
        final BigInteger one = BigInteger.ONE;
        final BigInteger calculatedFibonacci = mFibonacciGenerator.fibonacciForIndex(1);
        assertEquals(one, calculatedFibonacci);
    }

    public void testSlideToSecondFibonacci() {
        final BigInteger second = BigInteger.ONE;
        long index = 0;
        mFibonacciGenerator.fibonacciForIndex(index++);
        mFibonacciGenerator.fibonacciForIndex(index++);
        BigInteger calculatedFibonacci = mFibonacciGenerator.fibonacciForIndex(index);
        assertEquals(second, calculatedFibonacci);
    }

    public void testSlideToThirdFibonacci() {
        final BigInteger third = BigInteger.valueOf(2);
        long index = 0;
        mFibonacciGenerator.fibonacciForIndex(index++);
        mFibonacciGenerator.fibonacciForIndex(index++);
        mFibonacciGenerator.fibonacciForIndex(index++);
        BigInteger calculatedFibonacci = mFibonacciGenerator.fibonacciForIndex(index);
        assertEquals(third, calculatedFibonacci);
    }

    public void testForwardSlideStartedFromThousand() {
        BigInteger calculatedThousand = thousand_fib();
        BigInteger calculatedThousand_and_1 = thousandAnd1Fib();
        assertEquals(FIB_THOUSAND, calculatedThousand);
        assertEquals(FIB_THOUSAND_AND_1, calculatedThousand_and_1);
    }

    public void testBackwardSlideStartedFromThousandAnd1() {
        BigInteger calculatedThousand_and_1 = thousandAnd1Fib();
        BigInteger calculatedThousand = thousand_fib();
        assertEquals(FIB_THOUSAND, calculatedThousand);
        assertEquals(FIB_THOUSAND_AND_1, calculatedThousand_and_1);
    }

    private BigInteger thousand_fib() {
        return mFibonacciGenerator.fibonacciForIndex(1000);
    }

    private BigInteger thousandAnd1Fib() {
        return mFibonacciGenerator.fibonacciForIndex(1001);
    }
}
