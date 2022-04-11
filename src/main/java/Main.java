import java.util.Scanner;

public class Main {
    public static int firstPart, secndPart;
    private static final char[] LETTERS = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'}; // Константа содержащая массивом алфавит

    public static String number(String s) {
        String[] subStr = s.split("-"); // строка делится на массив строк

        // конвертация из строки в число
        firstPart = Integer.parseInt(subStr[2]);
        secndPart = Integer.parseInt(subStr[0]);

        // разбор случая введеной строки вида "01-ZZ-99"
        if (subStr[1].equals("ZZ") && firstPart == 99) {
            subStr[1] = "AA"; // "зануляется" второй элемент в массиве
            subStr[2] = "01"; // "зануляется" третий элемент в массиве
            secndPart++; // прибавляется 1 к первому элементо
            String S = Integer.toString(secndPart); // первый элемент массива конвертируется в строку
            if (secndPart < 10) {
                subStr[0] = "0" + S; // добавляем 0 к строке если первый элемент меньше 10
            } else {
                subStr[0] = S;
            }

            // разбор случая введеной строки вида "01-AZ-99"
        } else if (subStr[1].charAt(1) == 'Z' && firstPart == 99) {
            char ch1 = subStr[1].charAt(1); // получили второй символ у второго элемента массива строк subStr
            subStr[2] = "01";
            ch1 = LETTERS[0]; // символу присваевается значение из массиа "A"

            char ch0 = subStr[1].charAt(0); // получил первый символ у второго элемента массива строк subStr

            // поиск символа в массиве букв и присвоение ему следующей по порядку буквы в алфавите
            for (int i = 0; i < LETTERS.length; i++) {
                if (LETTERS[i] == ch0) {
                    ch0 = LETTERS[i + 1];
                    break;
                }
            }
            subStr[1] = String.valueOf(ch0) + String.valueOf(ch1); // собирается второй элемент массива subStr из символов

            // разбор случая введеной строки вида "01-AA-99"
        } else if (firstPart == 99) {
            char ch = subStr[1].charAt(1);

            for (int i = 0; i < LETTERS.length; i++) {
                if (LETTERS[i] == ch) {
                    ch = LETTERS[i + 1];
                    break;
                }
            }
            subStr[1] = String.valueOf(subStr[1].charAt(0)) + String.valueOf(ch);
            subStr[2] = "01";
        } else {
            firstPart++;
            String S = Integer.toString(firstPart);
            if (firstPart < 10) {
                subStr[2] = "0" + S;
            } else {
                subStr[2] = S;
            }
        }
        String arS = String.join("", subStr);

        System.out.println(arS);
        return arS;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Введите чило строку вида: XXYYXX
                XX Любые цифры (кроме 00)

                YY Любые буквы

                Пример: 01АВ01, 01АВ99
                """);
        number(scanner.nextLine());
    }
}