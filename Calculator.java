import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) throws IOException {

        FileReader fr = new FileReader("input.txt");
        Scanner sc = new Scanner(fr);
        FileWriter fw = null;
        StringBuilder answer_file = new StringBuilder();
        while (sc.hasNextLine()) {
            String[] arr = sc.nextLine().split(" ");
            fr.close();
            File file = new File("output.txt");
            fw = new FileWriter(file);
            boolean flag = true;
            double first_number, second_number;
            try {
                Double.parseDouble(arr[0]);
                Double.parseDouble(arr[2]);
            } catch (NumberFormatException nfe) {
                flag = false;
                answer_file.append(String.join(" ", arr)).append(" = Error! Not number\n");

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
                    answer_file.append(String.join(" ", arr)).append(" = Operation Error!\n");

                }
                if (flag) {
                    if (arr[1].charAt(0) == '+') {
                        answer_file.append(String.join(" ", arr)).append(" = ").append(first_number + second_number).append("\n");
                    } else if (arr[1].charAt(0) == '-') {
                        answer_file.append(String.join(" ", arr)).append(" = ").append(first_number - second_number).append("\n");
                    } else if (arr[1].charAt(0) == '*') {
                        answer_file.append(String.join(" ", arr)).append(" = ").append(first_number * second_number).append("\n");
                    } else if (arr[1].charAt(0) == '/') {
                        try {
                            if (second_number == 0) {
                                throw new Exception();
                            }
                        } catch (Exception ex) {
                            flag = false;
                            answer_file.append(String.join(" ", arr)).append(" = Error! Division by zero\n");
                        }
                        if (flag) {
                            answer_file.append(String.join(" ", arr)).append(" = ").append(first_number / second_number).append("\n");
                        }
                    }
                }
            }
        }
        assert fw != null;
        fw.write(String.valueOf(answer_file));
        fw.close();
    }
}

