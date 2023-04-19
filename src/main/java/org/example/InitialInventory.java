package org.example;

public class InitialInventory {

    public void InitialAdding() {
        CellPhone iPhone = new CellPhone("iPhone", "13", 50000);
        Stok.add(iPhone);
        CellPhone Honor = new CellPhone("Honor", "newModel", 20000);
        Stok.add(Honor);

    }


}
