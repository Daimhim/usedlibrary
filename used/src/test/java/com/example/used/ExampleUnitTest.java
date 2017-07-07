package com.example.used;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
        listList = new ArrayList<>();
        List<String> list = null;
        for (int i = 0; i < 5; i++) {
            list = new ArrayList<>();
            for (int j = 0; j < 4; j++) {
                if (i != 0 && i != 2) {
                    list.add(i + ":" + j);
                }else if (i == 0 && j > 2){
                    list.add(i + ":" + j);
                }else if (i == 2 && j < 3){
                    list.add(i + ":" + j);
                }
//                /*else if (i == 0 && j == 0){
//                    list.add(0,i + ":" + j);
//                }else if (i == 0 && j == 1){
//                    list.add(1,i + ":" + j);
//                }*/
            }
            listList.add(list);
        }
        for (int i = 0; i < getCon(); i++) {
            System.out.println(find(i)+":"+findType(i)+":"+i);
        }
//        for (int i = 0; i < listList.size(); i++) {
//            for (int j = 0; j < listList.get(i).size(); j++) {
//                System.out.println(i+":"+j);
//            }
//        }
        System.out.println(listList.toString());
        System.out.println(getCon());
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