package com.zzw.alpha;

import android.util.Log;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        int pairingKey = 423456;
        String mPairingKey = String.format("%6d", pairingKey).replace(" ", "0");
        System.out.println(mPairingKey);
    }

}