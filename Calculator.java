import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) throws IOException {

        FileReader fr = new FileReader("input.txt");
        Scanner sc = new Scanner(fr);
        String[] arr = sc.nextLine().split(" ");
        fr.close();
        File file = new File("output.txt");
        FileWriter fw = new FileWriter(file);
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
                    throw new MyException("Operation Error!");
                }
            } catch (MyException ms) {
                flag = false;
                System.out.println("Operation Error!");
            }
            if (flag) {
                if (arr[1].charAt(0) == '+') {fw.write((first_number + second_number) + "\n");}
                else if (arr[1].charAt(0) == '-') {fw.write((first_number - second_number) + "\n");}
                else if (arr[1].charAt(0) == '*') {fw.write((first_number * second_number) + "\n");}
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
                        fw.write((first_number / second_number) + "\n");
                    }
                }
                fw.close();
            }
        }
    }
}

