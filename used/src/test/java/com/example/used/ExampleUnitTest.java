package com.example.used;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    List<List<String>> listList = null;
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }
    private int findType(int pos){
        int size = 0;
        for (int i = 0; i < listList.size(); i++) {
            size += listList.get(i).size();
            if (size > pos){
                return i;
            }else if (size==pos){
                return ++i;
            }
        }
        return 0;
    }
    private int find(int pos){
        int size = 0;
        int arraySize = 0;
        for (int i = 0; i < listList.size() ; i++) {
            arraySize = listList.get(i).size();
            size += arraySize;
            if (size > pos){
                return pos - (size - arraySize);
            }else if (size == pos){
                return pos - size;
            }
        }
        return 0;
    }
//    private int getContent(int pos){
//        int size = listList.get(pos).size();
//        return size == 0?1: size;
//    }
    private int getCon(){
        int size = 0;
        for (int i = 0; i < listList.size(); i++) {
            size += listList.get(i).size();
        }
        return size;
    }
}