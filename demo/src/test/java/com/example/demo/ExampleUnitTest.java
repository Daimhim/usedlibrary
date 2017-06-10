package com.example.demo;

import android.util.SparseArray;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        SparseArray<Integer> mSparseArray = new SparseArray<>();
        int num = 0;
        for (int i = 0; i < 20; i++) {
            mSparseArray.put(i, num);
            num += 20;
            num++;
        }
        mSparseArray.put(20, num);

        System.out.println(mSparseArray.indexOfValue(147));

        assertEquals(4, 2 + 2);
    }
}