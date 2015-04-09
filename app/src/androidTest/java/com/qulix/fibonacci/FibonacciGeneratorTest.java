package com.qulix.fibonacci;

import android.test.InstrumentationTestCase;

import com.qulix.fibonacci.generator.FibonacciGenerator;
import com.qulix.fibonacci.generator.MatrixFibonacciGenerator;

import java.math.BigInteger;

public class FibonacciGeneratorTest extends InstrumentationTestCase {

    private FibonacciGenerator mFibonacciGenerator;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mFibonacciGenerator = new MatrixFibonacciGenerator();
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

    public void testTensFibonacci() {
        final BigInteger tens = BigInteger.valueOf(55);
        final BigInteger calculatedFibonacci = mFibonacciGenerator.fibonacciForIndex(10);
        assertEquals(tens, calculatedFibonacci);
    }

    public void testThousandFibonacci() {
        final BigInteger thousand = new BigInteger("43466557686937456435688527675040625802564660517371780402481729089536555417949051890403879840079255169295922593080322634775209689623239873322471161642996440906533187938298969649928516003704476137795166849228875");
        final BigInteger calculatedFibonacci = mFibonacciGenerator.fibonacciForIndex(1000);
        assertEquals(thousand, calculatedFibonacci);
    }

}
