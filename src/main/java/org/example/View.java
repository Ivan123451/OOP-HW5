package org.example;

import java.util.Scanner;

public class View implements InitialMassage, RepetedMassage {

    @Override
    public void initialString() {

        System.out.println("Начинаем, у вас 100 т.р. и 2 телефона на складе, что хотите сделать");

    }

    @Override
    public Integer display() {
               System.out.println("\n Введите число: \n" +
                "1. Купить  телефон на склад\n" +
                "2. Продать телефон со склада\n" +
                "3. Украли телефон\n" +
                "4. Вызвать инспекцию \n" +
                "5. Показать что есть на складе\n" +
                "6. Завершить работу\n");


        Scanner inNum = new Scanner(System.in);
        Integer num = inNum.nextInt();
        return num;


    }
}
