/*
    Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
    Создать множество ноутбуков.
    Написать метод, который будет запрашивать у пользователя критерий фильтрации и выведет ноутбуки, отвечающие фильтру.

NoteBook notebook1 = new NoteBook
NoteBook notebook2 = new NoteBook
NoteBook notebook3 = new NoteBook
NoteBook notebook4 = new NoteBook
NoteBook notebook5 = new NoteBook

Например: “Введите цифру, соответствующую необходимому критерию:
1 - ОЗУ
2 - Объем ЖД hd hdd
3 - Операционная система
4 - Цвет

    Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.

    Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.

Класс сделать в отдельном файле

приветствие
Выбор параметра
выбор конкретнее
вывод подходящих
 */

package seminar6;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Init();
        String hello = " 1 - RAM \n 2 - HDD \n 3 - OS \n 4 - Diagonal \n 0 - Final \n Choice param: ";
        int a = 1;
        Map<Integer, Integer> filter = new HashMap<>();
        while (a != 0) {
            a = EnterOperation(hello);
            switch (a) {
                case 1: // ramsize
                    int b = EnterOperation("Choice RAM: ");
                    System.out.println(b);
                    filter.put(1, b);
                    break;
                case 2: // hddsize
                    b = EnterOperation("Choice HDD: ");
                    System.out.println(b);
                    filter.put(2, b);
                    break;
                case 3: // os
                    b = EnterOperation("Choice OS 1 - Win, 2 - Lin: ");
                    System.out.println(b);
                    filter.put(3, b);
                    break;
                case 4: // diag
                    b = EnterOperation("Choice Diag: ");
                    System.out.println(b);
                    filter.put(4, b);
                    break;
                case 0: // exit
                    Filter(filter, Init());
                    break;
            }
        }
    }

    static void Filter(Map<Integer, Integer> filter, Notebook[] ns) {
        for (int i = 0; i < ns.length; i++) {
            boolean[] flag = new boolean[] { true, true, true, true };
            for (var item : filter.entrySet()) {
                int param = item.getKey();
                switch (param) {
                    case 1: // ramsize
                        if (ns[i].getRamSize() <= item.getValue()) {
                            flag[0] = !flag[0];
                        }
                        break;
                    case 2: // hddsize
                        if (ns[i].getHddSize() <= item.getValue()) {
                            flag[1] = !flag[1];
                        }
                        break;
                    case 3: // os
                        if (ns[i].getOsIndex() <= item.getValue()) {
                            flag[2] = !flag[2];
                        }
                        break;
                    case 4: // diag
                        if (ns[i].getDiag() <= item.getValue()) {
                            flag[3] = !flag[3];
                        }
                        break;
                }
            }
            if (flag[0] == true && flag[1] == true && flag[2] == true && flag[3] == true) {
                System.out.println(ns[i].getNum() + ", ram - " + ns[i].getRamSize() + ", hdd - " + ns[i].getHddSize()
                        + ", os - " + ns[i].getOsVer() + ", diagonal - " + ns[i].getDiag());
            }
        }
    }

    static Notebook[] Init() {
        Notebook n1 = new Notebook(1, 2, 100, 1, 13);
        Notebook n2 = new Notebook(2, 4, 200, 2, 14);
        Notebook n3 = new Notebook(3, 8, 500, 1, 15);
        Notebook n4 = new Notebook(4, 16, 100, 2, 17);
        Notebook n5 = new Notebook(5, 2, 500, 1, 14);
        Notebook n6 = new Notebook(6, 4, 100, 2, 14);
        Notebook n7 = new Notebook(7, 8, 100, 1, 15);
        Notebook n8 = new Notebook(8, 16, 200, 2, 17);
        Notebook n9 = new Notebook(9, 2, 500, 2, 14);
        Notebook n10 = new Notebook(10, 8, 1000, 2, 14);
        Notebook[] ns = new Notebook[] { n1, n2, n3, n4, n5, n6, n7, n8, n9, n10 };
        return ns;
    }

    static int EnterOperation(String str) {
        Scanner Scan = new Scanner(System.in);
        System.out.print(str);
        String i = new String();
        int r = 0;
        if (Scan.hasNext()) {
            i = Scan.next();
            r = Integer.parseInt(i);
        } else {
            Scan.next();
            r = EnterOperation("Error");
        }
        return r;
    }
}
