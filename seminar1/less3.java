package seminar1;
import java.util.Scanner;

public class less3 {
 //   Scanner iScanner = new Scanner(System.in);
    public static void main(String[] args) {
        int a = EnterNumber(1);
        char c = EnterOperation();
        int b = EnterNumber(2);

        System.out.print(Calculate(a, b, c));
    }

    static char EnterOperation(){
        Scanner iScanner = new Scanner(System.in);        
        System.out.print("Enter operation: ");
        String s = iScanner.next();
        char c=s.charAt(0);
        return c;
    }

    static int EnterNumber(int a){
        Scanner iScanner = new Scanner(System.in);
        System.out.print("Enter number " + a + ":");
        int i;
        if(iScanner.hasNextInt()){
            i = iScanner.nextInt();
        } else {
            System.out.print("Error");
            iScanner.next();
            i = EnterNumber(a);
        }
        return i;
    }

    static int Calculate(int a, int b, char c){
        int res = 0;
                switch(c){
            case '+':
                res = a + b;
                break;
            case '-':
                res = a - b;
                break;
            case '*':
                res = a * b;
                break;
            case '/':
                res = a / b;
                break;
                }
        return res;
    }
}
