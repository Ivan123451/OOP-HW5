package org.example;

import java.util.Scanner;

public class Model {

    public void activity(){
        boolean flag = true;
        Money money = new Money();
//        money.amount = 100000;
        View view = new View();
        view.initialString();

        while (flag == true) {

            Integer num = view.display();


            switch (num) {
                case 1:
                    CellPhone localPhone = new CellPhone(null, null, 0);
                    System.out.println("Ведите параметры телефона:" +
                            "Бренд:");
                    Scanner inBrand = new Scanner(System.in);
                    String inBrand2 = inBrand.next();
                    localPhone.brand = inBrand2;

                    System.out.println("Модель:");
                    Scanner inModel = new Scanner(System.in);
                    String inModel2 = inModel.next();
                    localPhone.model = inModel2;

                    System.out.println("Цена закупки: ");
                    Scanner inPrice = new Scanner(System.in);
                    Integer inPrice2 = inPrice.nextInt();
                    localPhone.price = inPrice2;

                    if (money.amount > inPrice2) {
                        System.out.println("вы добавили на склад" + localPhone.toString());
                        money.amount = money.amount - localPhone.price;
                        System.out.println("У вас осталось " + money.amount);
                        Stok.add(localPhone);

                    }
                    else {
                        System.out.println("У вас не зватет денег(");
                    }

                    break;
                case 2:
                    System.out.println("Телефон какой марки Вы продаете:");
                    Scanner inAnsver = new Scanner(System.in);
                    String nameOfBrand = inAnsver.next();
                    System.out.println("За сколько вы его продали:");
                    Scanner inSellPrice = new Scanner(System.in);
                    Integer inSellPrice2 = inSellPrice.nextInt();

                    for (int i = 0; i < Stok.listOfPhones.size(); i++) {

                        CellPhone deletedPhone = Stok.listOfPhones.get(i);
                        if (deletedPhone.brand.equals(nameOfBrand)) {
                            Stok.sell(deletedPhone);
                            System.out.println("Вы продали " + deletedPhone);
                        }

                    }
                    money.amount = money.amount+ inSellPrice2;
                    System.out.println("У вас теперь" + money.amount);


                    break;


                case 3:
                    int rnd = (int) (Math.random()*Stok.listOfPhones.size());
                    System.out.println(rnd);

                    CellPhone stolenPhone = Stok.listOfPhones.get(rnd);
                    Stok.sell(stolenPhone);
                    System.out.println("У вас украли 1 телефон, на складе осталось: " + Stok.listOfPhones.size() + "телефон(ов)");
                    System.out.println(Stok.listOfPhones);

                    break;

                case 4:
                    int rndInspection = (int) (Math.random()*2);
                    System.out.println(rndInspection);
                    if (rndInspection == 1) {
                        Tax tax = new Tax();
                        tax.inspectionCome();
                        int tiket = tax.tiketAmount();
                        money.amount = money.amount - tiket;
                        System.out.println("У вас осталось "+ money.amount);
                    }
                    else {
                        FierFighters fierFighters = new FierFighters();
                        fierFighters.inspectionCome();

                    }

                    break;

                case 5:
                    System.out.println("У вас на складе: " + Stok.listOfPhones.size() + "телефон(ов)");
                    System.out.println(Stok.listOfPhones);
                    System.out.println("А еще у вас " + money.amount + " наличкой");
                    break;
                case 6:
                    flag = false;
                    break;

                default:
                    throw new IllegalStateException("вы ввели не коректное число: " + num);
            }



        }



    }


}
