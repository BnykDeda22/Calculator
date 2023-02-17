import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) throws MyException {

        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().split(" ");
        boolean flag = true;
        double first_number, second_number;
        try {
           Double.parseDouble(arr[0]);
           Double.parseDouble(arr[2]);
        } catch (NumberFormatException nfe) {
            flag = false;
            System.out.println("Error! Not number");
        }
        if (flag) {
            first_number = Double.parseDouble(arr[0]);
            second_number = Double.parseDouble(arr[2]);

            try {
                if (arr[1].length() != 1 || (arr[1].charAt(0) != '+' && arr[1].charAt(0) != '-' && arr[1].charAt(0) != '*' && arr[1].charAt(0) != '/')) {
                    System.out.println(arr[1]);
                    System.out.println(arr[1].charAt(0));
                    throw new MyException("Operation Error!");
                }
            } catch (MyException ms) {
                flag = false;
                System.out.println("Operation Error!");
            }
            if (flag) {
                if (arr[1].charAt(0) == '+') {System.out.println(first_number + second_number);}
                else if (arr[1].charAt(0) == '-') {System.out.println(first_number - second_number);}
                else if (arr[1].charAt(0) == '*') {System.out.println(first_number * second_number);}
                else if (arr[1].charAt(0) == '/') {
                    try {
                        if (second_number == 0){
                            throw new Exception();
                        }
                    } catch (Exception ex) {
                        flag=false;
                        System.out.println("Error! Division by zero");
                    }
                    if (flag){
                        System.out.println(first_number/second_number);
                    }
                }
            }
        }
    }
}

