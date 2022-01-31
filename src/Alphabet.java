import java.util.HashMap;
import java.util.Map;

public class Alphabet {
    private static HashMap<Integer, Character> listOfLetters;

    public static HashMap<Integer, Character> getListOfSymbols() {
        listOfLetters = new HashMap<>();
        listOfLetters.put(1, 'а');
        listOfLetters.put(2, 'б');
        listOfLetters.put(3, 'в');
        listOfLetters.put(4, 'г');
        listOfLetters.put(5, 'д');
        listOfLetters.put(6, 'е');
        listOfLetters.put(7, 'ё');
        listOfLetters.put(8, 'ж');
        listOfLetters.put(9, 'з');
        listOfLetters.put(10, 'и');
        listOfLetters.put(11, 'й');
        listOfLetters.put(12, 'к');
        listOfLetters.put(13, 'л');
        listOfLetters.put(14, 'м');
        listOfLetters.put(15, 'н');
        listOfLetters.put(16, 'о');
        listOfLetters.put(17, 'п');
        listOfLetters.put(18, 'р');
        listOfLetters.put(19, 'с');
        listOfLetters.put(20, 'т');
        listOfLetters.put(21, 'у');
        listOfLetters.put(22, 'ф');
        listOfLetters.put(23, 'х');
        listOfLetters.put(24, 'ц');
        listOfLetters.put(25, 'ч');
        listOfLetters.put(26, 'ш');
        listOfLetters.put(27, 'щ');
        listOfLetters.put(28, 'ъ');
        listOfLetters.put(29, 'ы');
        listOfLetters.put(30, 'ь');
        listOfLetters.put(31, 'э');
        listOfLetters.put(32, 'ю');
        listOfLetters.put(33, 'я');
        listOfLetters.put(34, '.');
        listOfLetters.put(35, ',');
        listOfLetters.put(36, '\'');
        listOfLetters.put(37, ':');
        listOfLetters.put(38, '-');
        listOfLetters.put(39, '!');
        listOfLetters.put(40, '?');
        listOfLetters.put(41, ' ');
        listOfLetters.put(42, '0');
        listOfLetters.put(43, '1');
        listOfLetters.put(44, '2');
        listOfLetters.put(45, '3');
        listOfLetters.put(46, '4');
        listOfLetters.put(47, '5');
        listOfLetters.put(48, '6');
        listOfLetters.put(49, '7');
        listOfLetters.put(50, '8');
        listOfLetters.put(51, '9');
        listOfLetters.put(52, '(');
        listOfLetters.put(53, ')');

        return listOfLetters;
    }
}