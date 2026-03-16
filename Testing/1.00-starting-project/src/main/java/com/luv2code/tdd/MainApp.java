package com.luv2code.tdd;

public class MainApp {

    static void main() {
        for(int i=0;i<=100;i++){
            System.out.println(i+","+FizzBuzz.compute(i));
        }
    }
}
