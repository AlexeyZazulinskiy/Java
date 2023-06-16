package seminar1;
import java.util.Scanner;

/*
 * 1) Вычислить n-ое треугольного число (сумма чисел от 1 до n), n! (произведение чисел от 1 до n)
 */

public class less1 {
    public static void main(String[] args) {
        int x = EnterNumber();
        System.out.println("Summa "+CalculateSum(x));
        System.out.println("Factorial "+CalculateFact(x));
    }

    static int EnterNumber() {
        Scanner iScanner = new Scanner(System.in);

        System.out.print("Enter number: ");
        int i;
        if(iScanner.hasNextInt()){
            i = iScanner.nextInt();
        } else {
            System.out.println("Error");
            iScanner.next();
            i = EnterNumber();
        }

        iScanner.close();
        return i;
    }

    static int CalculateSum(int a) {
        a = (1 + a) * a / 2;
        return a;
    }

    static int CalculateFact(int a) {
        int sum = 1;
        for (int i = 1; i <= a; i++) {
            sum = sum * i;
        }
        return sum;
    }
}
