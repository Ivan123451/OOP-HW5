package org.example;

import java.util.ArrayList;

public class Stok {

    static ArrayList<CellPhone> listOfPhones = new ArrayList<>();



    public static void add(CellPhone localPhone){
        listOfPhones.add(localPhone);
    }

    public static void sell(CellPhone sellLocalPhone){
        listOfPhones.remove(sellLocalPhone);
    }


    @Override
    public String toString() {
        return "Stok{}";
    }
}
