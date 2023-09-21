package org.example.advancejava;

public class Inheritanceexample {
    public static void main(String[] args) {
        Color color = new Color();
        color.wing();
        color.color();
        //color.shade();
    }
}

class Bird{
    protected void wing(){
        System.out.println("Have 2 wings");
    }
}

class Parrot extends Bird{

    void color(){
        System.out.println("have green color");
    }
}

class Color extends Parrot {

    void color(){
        super.color();
        System.out.println("have green color from color class");
    }

    void shade() {
        System.out.println("shade name is light green ");
    }
}
