package seminar2;

import java.util.Objects;
import java.util.Scanner;

/*
 * 1) Дана строка sql-запроса "select * from students WHERE ". Сформируйте часть WHERE этого запроса, используя StringBuilder.
 Данные для фильтрации приведены ниже в виде json-строки.
Если значение null, то параметр не должен попадать в запрос.
String input_str = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}"
Ввод данных: {"name":"Ivanov", "country":"Russia", "age":"null", "city":"Moscow"}
вывод: select * from students WHERE name=Ivanov AND country=Russia AND city=Moscow
 */

public class less1 {
    public static void main(String[] args) {
        String str = EnterOperation();

        System.out.print(SqlBuilder(Split(str)));

    }

    static String EnterOperation() {
        Scanner iScanner = new Scanner(System.in);
        System.out.print("Enter json: ");
        return iScanner.nextLine();
    }

    static String[][] Split(String s) {
        String clearStr = s.replace(":", " ");
        clearStr = clearStr.replace("\"", " ");
        clearStr = clearStr.replace(",", " ");
        clearStr = clearStr.replace("{ }", " ");
        String[] str = clearStr.split(" ");
        String[][] str2 = new String[str.length / 4][2];
        int count = 0;
        boolean flag = true;
        for (int i = 0; i < str.length; i++) {
            if (str[i].length() > 1) {
                if (flag == true) {
                    str2[count][0] = str[i];
                    flag = false;
                } else {
                    str2[count][1] = str[i];
                    flag = true;
                    count++;
                }

            }
        }
        return str2;
    }

    static StringBuilder SqlBuilder(String[][] str) {
        String app = " WHERE ";
        int count = 0;
        StringBuilder sb = new StringBuilder("select * from students");
        for (int i = 0; i < str.length; i++) {
            if (str[i][1] != null) {
                count++;
            }
        }
        for (int i = 0; i < count; i++) {
            if (Objects.equals(str[i][1], "null")) {
            } else {
                sb.append(app + str[i][0] + "=" + str[i][1]);
                app = " AND ";
            }
        }
        return sb;
    }
}
