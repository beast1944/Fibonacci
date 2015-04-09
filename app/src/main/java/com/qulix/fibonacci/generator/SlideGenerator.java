package com.qulix.fibonacci.generator;

import java.math.BigInteger;

public class SlideGenerator implements FibonacciGenerator {

    private int mCurrentIndex = 1;

    private BigInteger mPrev = BigInteger.ZERO;
    private BigInteger mCurrent = BigInteger.ONE;
    private BigInteger mNext = BigInteger.ONE;

    public BigInteger fibonacciForIndex(final long requiredIndex) {

        while (requiredIndex != mCurrentIndex) {
            if (requiredIndex > mCurrentIndex) {
                moveForward();
            } else {
                moveBackward();
            }
        }

        return mCurrent;
    }

    private void moveForward() {
        mPrev = mCurrent;
        mCurrent = mNext;
        mNext = mPrev.add(mCurrent);
        mCurrentIndex++;
    }

    private void moveBackward() {
        mNext = mCurrent;
        mCurrent = mPrev;
        mPrev = mNext.subtract(mCurrent);
        mCurrentIndex--;
    }
}
