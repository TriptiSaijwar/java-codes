package com.company.commonJava;

import java.util.ArrayList;

public class ArrayListPassAsParam {

    public void passingArrayList() {
        ArrayList<Integer> array = new ArrayList<>();
        array.add(1);
        array.add(2);
        System.out.println(array);
        capturingArray(array);
        System.out.println(array);
    }

    private void capturingArray(ArrayList<Integer> array) {
        array.add(4);
        array.set(1,5);
        System.out.println(array);
    }

    public class Test2
    {
        public void main(String args[])
        {
            ArrayListPassAsParam arrayListPassAsParam = new ArrayListPassAsParam();
            arrayListPassAsParam.passingArrayList();
        }
    }
}
