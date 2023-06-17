
package seminar3;
/*
 Пусть дан произвольный список целых чисел.
1) Нужно удалить из него чётные числа
2) Найти минимальное значение
3) Найти максимальное значение
4) Найти среднее значение
 */

import java.util.*;

public class less1 {
    public static void main(String[] args) {
        Calculate(Initial());

    }

    static List<Integer> Initial() {
        List<Integer> list1 = new ArrayList(Arrays.asList(3, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        return list1;
    }

    static void Calculate(List<Integer> lst) {
        int numMinimal = lst.get(0);
        int numMaximal = lst.get(0);
        float numSummary = 0;
        int count = 0;
        Iterator<Integer> col = lst.iterator();
        while (col.hasNext()){
         //   for (int i : lst) {
        int i = col.next();
            if (i % 2 == 0) {
                col.remove();
            } else {
                numSummary += i;
                count++;
                if (i < numMinimal) {
                    numMinimal = i;
                } else if (i > numMaximal) {
                    numMaximal = i;
                }
            }

        }
        for (int j : lst) {System.out.print(" " + j);}
        System.out.println("");
        System.out.println("Minimal " + numMinimal);
        System.out.println("Maximal " + numMaximal);
        System.out.println("Average " + numSummary / count);


     }
}
