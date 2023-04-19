package org.example;

public class Tax implements Inspection, Tiket {
    @Override
    public void inspectionCome() {
        System.out.println("Пришла налоговая и оштрафовала вас на 10 тр");
    }


    @Override
    public int tiketAmount() {
        int tiket = 10000;
        return tiket;

    }
}
