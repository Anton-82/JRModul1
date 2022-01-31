import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

public class Main {
    private static String variantOfWork;
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static int offset;
    private static String text = null;
    private static String nameOfFile = null;
    private static String nameOfFileDirectory = "files";
    private static Path file = null;

    public static void main(String[] args) {
        System.out.println("Выбери действие, введя его номер:   !!! Для выхода из программы введите exit !!!\n1. Зашифровать файл ключём\n2. Расшифровать файл ключём");
        System.out.println("3. Расшифровать методом перебора\n4. Расшифровать методом статистичекого анализа ");

        do {
            try {
                System.out.println();
                System.out.print("Введите номер действия: ");
                variantOfWork = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }


            switch (variantOfWork) {
                case "1":
                    try {
                        System.out.print("Введите название файла в корневой папке files: ");
                        nameOfFile = reader.readLine();
                        text = Files.readString(Paths.get(".\\" + nameOfFileDirectory + "\\" + nameOfFile));
                        System.out.print("Введите смещение: ");
                        offset = Integer.valueOf(reader.readLine());
                        Files.writeString(Paths.get(".\\" + nameOfFileDirectory + "\\" + "decrypted_" + nameOfFile), CryptoMethods.encrypt(text.toLowerCase(), offset));
                        System.out.println("Зашифрованый файл " + "decrypted_" + nameOfFile + " создался в корневой папке files");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case "2":
                    try {
                        System.out.print("Введите название файла в корневой папке files: ");
                        nameOfFile = reader.readLine();
                        text = Files.readString(Paths.get(".\\" + nameOfFileDirectory + "\\" + nameOfFile));
                        System.out.print("Введите смещение: ");
                        offset = Integer.valueOf(reader.readLine());
                        Files.writeString(Paths.get(".\\" + nameOfFileDirectory + "\\" + "encrypted_" + nameOfFile), CryptoMethods.encrypt(text.toLowerCase(), -offset));
                        System.out.println("Расшифрованый файл " + "encrypted_" + nameOfFile + " создался в корневой папке files");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case "3":
                    try {
                        System.out.print("Введите название файла в корневой папке files: ");
                        nameOfFile = reader.readLine();
                        text = Files.readString(Paths.get(".\\" + nameOfFileDirectory + "\\" + nameOfFile));
                        Files.writeString(Paths.get(".\\" + nameOfFileDirectory + "\\" + "encrypted_brute_force_" + nameOfFile), CryptoMethods.bruteForce(text.toLowerCase()));
                        System.out.println("Расшифрованый файл " + "encrypted_brute_force_" + nameOfFile + " создался в корневой папке files");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case "4":
                    try {
                        System.out.print("Введите название файла в корневой папке files для анализа: ");
                        nameOfFile = reader.readLine();
                        text = Files.readString(Paths.get(".\\" + nameOfFileDirectory + "\\" + nameOfFile));
                        HashMap<Integer, Double> stat = CryptoMethods.getStatOfOccurCharsInText(text.toLowerCase());
                        System.out.print("Введите название зашифрованного файла в корневой папке files: ");
                        nameOfFile = reader.readLine();
                        text = Files.readString(Paths.get(".\\" + nameOfFileDirectory + "\\" + nameOfFile));
                        Files.writeString(Paths.get(".\\" + nameOfFileDirectory + "\\" + "encrypted_stat_" + nameOfFile), CryptoMethods.decryptWhitStatisticAnalysis(text.toLowerCase(), stat));
                        System.out.println("Расшифрованый файл " + "encrypted_stat_" + nameOfFile + " создался в корневой папке files");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    if (!variantOfWork.equals("exit"))
                    System.out.println("Введите целое число от 1 до 4");
                    break;
            }
        }
        while (!variantOfWork.equals("exit"));

    }
}
