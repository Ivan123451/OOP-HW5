package org.example;

public class FierFighters implements Inspection{
    @Override
    public void inspectionCome() {
        System.out.println("Пришли пожарные, у вас все ОК");
    }
}
