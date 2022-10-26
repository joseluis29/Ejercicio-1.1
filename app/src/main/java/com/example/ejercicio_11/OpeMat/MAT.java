package com.example.ejercicio_11.OpeMat;

public class MAT {    public int value1;
    public int value2;

    public MAT(int value1, int value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public int getValue1() {
        return value1;
    }

    public void setValue1(int value1) {
        this.value1 = value1;
    }

    public int getValue2() {
        return value2;
    }

    public void setValue2(int value2) {
        this.value2 = value2;
    }

    public double suma(){
        return  getValue1() + getValue2();
    }

    public double resta(){
        return getValue1() - getValue2();
    }

    public double division(){
        return getValue1() / getValue2();
    }

    public double multiplicacion(){
        return getValue1() * getValue2();
    }
}

