package seminar4;

import java.net.SocketImpl;
import java.net.SocketPermission;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;

/*
 * Даны два Deque, представляющие два целых числа. Цифры хранятся в обратном порядке и каждый из их узлов содержит одну цифру.
1) Умножьте два числа и верните произведение в виде связанного списка.
2) Сложите два числа и верните сумму в виде связанного списка.
Одно или два числа могут быть отрицательными.

Даны два Deque, цифры в обратном порядке.
[3,2,1,-] - пример Deque
[5,4,3]- пример второго Deque
1) -123 * 345 = -42 435
Ответ всегда - связный список, в обычном порядке
[-,4,2,4,3,5] - пример ответа
 */

public class less1 {
    public static void main(String[] args) {
        String n1 = "-1230";
        String n2 = "345";
        Deque first = DequeInit(n1);
        Deque second = DequeInit(n2);
        System.out.print("Miltipler  = ");
        System.out.println(DMulitiper(first, second));
        System.out.print("Summary = ");
        System.out.println(DSummaru(first, second));

    }

    static Deque DequeInit(String str) {
        String[] strArr = str.split("");
        Deque<String> dq = new LinkedList();
        for (int i = 0; i < strArr.length; i++) {
            dq.addFirst(strArr[i]);
        }
        return dq;

    }

    static Deque DMulitiper(Deque n1, Deque n2) {
        boolean flag = false;
        int summ = 0;
        Deque<String> result = new LinkedList();
        if (Objects.equals(n1.getLast(), "-")) {
            flag = !flag;
            n1.removeLast();
        }
        if (Objects.equals(n2.getLast(), "-")) {
            flag = !flag;
            n2.removeLast();
        }
        int n = 1;
        for (Iterator i = n1.iterator(); i.hasNext();) {
            String s = (String) i.next();
            int a = Integer.parseInt(s);
            int m = 1;
            for (Iterator j = n2.iterator(); j.hasNext();) {
                String d = (String) j.next();
                int b = Integer.parseInt(d);
                summ = summ + (a * b * m * n);
                m = m * 10;
            }
            n = n * 10;
        }
        if (flag == true) {
            result.add("-");
        }
        String s = Integer.toString(summ);
        for (int i = 0; i < s.length(); i++) {
            result.add(Character.toString(s.charAt(i)));
        }

        return result;
    }

    static Deque DSummaru(Deque n1, Deque n2) {
        int summ = 0;
        Deque<String> result = new LinkedList();
        int a = Dtoint(n1);
        int b = Dtoint(n2);
        summ = a + b;
        String s = Integer.toString(summ);
        for (int i = 0; i < s.length(); i++) {
            result.add(Character.toString(s.charAt(i)));
        }
        return result;
    }

    static int Dtoint(Deque dq) {
        boolean flaga = false;
        if (Objects.equals(dq.getLast(), "-")) {
            flaga = !flaga;
            dq.removeLast();
        }

        int m = 1;
        int res = 0;
        for (Iterator i = dq.iterator(); i.hasNext();) {
            String s = (String) i.next();
            int a = Integer.parseInt(s);
            res = res + a * m;
            m = m * 10;
        }
        if (flaga == true) {
            res = -res;
        }
        return res;
    }

}
