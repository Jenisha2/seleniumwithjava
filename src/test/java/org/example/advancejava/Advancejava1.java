package org.example.advancejava;

import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class Advancejava1 {

    @Test
    public void trycatch() {
        try {
            System.out.println("TEst1");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("There is InterruptedException");
        } catch (FileNotFoundException e2) {
            System.out.println("There is file ot found exception");
        } finally {
            System.out.println("There failed beacuse file is not available");
        }
    }
}
