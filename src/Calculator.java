import java.util.Scanner;

public class Calculator {
    public static void main(String args[]) throws Exception {

        int result;

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите римские или арабские числа и операнд через пробел");
        String input = sc.nextLine(); // считываем операцию
        String[] inputLine = input.split("\\s+"); // и разделяем по пробелам

        if (inputLine.length < 3){
            throw new Exception("//т.к. строка не является математической операцией");
        }
        if (inputLine.length > 3) {
            throw new Exception("//т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }

        Number firstNumber = new Number(inputLine[0]);
        String operator = inputLine[1];
        Number secondNumber = new Number(inputLine[2]);

        if (firstNumber.isRoman != secondNumber.isRoman) {
            throw new Exception("//т.к. используются одновременно разные системы счисления");
        }

        result = operation(firstNumber.value, operator, secondNumber.value);

        if (firstNumber.isRoman){
            if (result < 0){
                throw new Exception("//т.к. в римской системе нет отрицательных чисел");
            }
            System.out.println(translateToArabic(result));
        }
        else System.out.println(result);
    }


    public static int operation(int a, String operation, int b) throws Exception {
        return switch (operation) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "/" -> a / b;
            case "*" -> a * b;
            default -> throw new Exception("//т.к. оператор указан неверно");
        };
    };

    public static String translateToArabic(int input){
        String s = "";
        while (input >= 100) {
            s += "C";
            input -= 100;
        }
        while (input >= 90) {
            s += "XC";
            input -= 90;
        }
        while (input >= 50) {
            s += "L";
            input -= 50;
        }
        while (input >= 40) {
            s += "XL";
            input -= 40;
        }
        while (input >= 10) {
            s += "X";
            input -= 10;
        }
        while (input >= 9) {
            s += "IX";
            input -= 9;
        }
        while (input >= 5) {
            s += "V";
            input -= 5;
        }
        while (input >= 4) {
            s += "IV";
            input -= 4;
        }
        while (input >= 1) {
            s += "I";
            input -= 1;
        }
        return s;
    };
}