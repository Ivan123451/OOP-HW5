package org.example;

import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean flag = true;
        Money<Integer> money = new Money();
        money.amount = 100000;
        CellPhone iPhone = new CellPhone("iPhone", "13", 50000);
        Stok.add(iPhone);
        CellPhone Honor = new CellPhone("Honor", "newModel", 20000);
        Stok.add(Honor);
        System.out.println("Начинаем, у вас 100 т.р. и 2 телефона на складе, что хотите сделать");

        while (flag == true) {
            System.out.println("\n Введите число: \n" +
                    "1. Купить  телефон на склад\n" +
                    "2. Продать телефон со склада\n" +
                    "3. Украли телефон\n" +
                    "4. Пришла налоговая\n" +
                    "5. Показать что есть на складе\n" +
                    "6. Завершить работу\n");
            Scanner inNum = new Scanner(System.in);
            Integer num = inNum.nextInt();


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
                    int tiket = (int) (money.amount*0.3);
                    System.out.println("К вам пришла налоговая и оштрафовала вас за неуплату налогов " +
                            " на " + tiket);
                    money.amount = money.amount - tiket;
                    System.out.println("У вас осталось "+ money.amount);
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