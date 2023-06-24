package seminar5;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

/*
Реализуйте структуру телефонной книги с помощью HashMap.
Программа также должна учитывать, что во входной структуре будут повторяющиеся имена с разными телефонами, их необходимо считать, как одного человека с разными телефонами.
Вывод должен быть отсортирован по убыванию числа телефонов.

Пример:
Иванов 1231234
Иванов 3456345
Иванов 5676585
Петров 12345
Петров 82332
 */

public class less1 {
    public static void main(String[] args) {
        Map<Integer, String> hMap = Enter();
        Sort(hMap);
    }

    static Map<Integer, String> Enter() {
        Map<Integer, String> hmap = new HashMap<>();
        hmap.put(123456, "Иванов");
        hmap.put(321456, "Васильев");
        hmap.put(234561, "Петрова");
        hmap.put(234432, "Иванов");
        hmap.put(654321, "Петрова");
        hmap.put(345678, "Иванов");
        hmap.put(234562, "Петрова");
        hmap.put(234862, "Иванова");
        return hmap;
    }

    static void Sort(Map<Integer, String> hmap) {
        TreeMap<String, Integer> tmap = new TreeMap<>();
        for (var item : hmap.entrySet()) {
            tmap.putIfAbsent(item.getValue(), 0);
            tmap.put(item.getValue(), tmap.get(item.getValue()) + 1);
        }
        ArrayList<Integer> list1 = new ArrayList();
        for (var item : tmap.entrySet()) {
            if (list1.contains(item.getKey())) {
            } else {
                list1.add(item.getValue());
            }
        }
        Collections.sort(list1, Collections.reverseOrder());
        ArrayList<String> listName = new ArrayList();
        for (int i = 0; i < list1.size(); i++) {
            for (var item : tmap.entrySet()) {
                if (list1.get(i) == item.getValue()) {
                    listName.add(item.getKey());
                }
            }
        }
        Print(hmap, listName);
    }

    static void Print(Map<Integer, String> hmap, ArrayList<String> listName) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < listName.size(); i++) {
            str.append(listName.get(i));
            for (var item : hmap.entrySet()) {
                if (Objects.equals(listName.get(i), item.getValue())) {
                    str.append(", " + item.getKey());
                }
            }
            System.out.println(str);
            str.setLength(0);
        }

    }
}
