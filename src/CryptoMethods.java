import java.util.*;

public class CryptoMethods {

    public static String encrypt(String text, int offsetNumber) {
        HashMap<Integer, Character> listOfSymbols = Alphabet.getListOfSymbols();
        String encryptText = null;
        StringBuilder stringBuilder = new StringBuilder();
        int newKeyOfHashMap;
        char[] symbolsOfText = text.toCharArray();

        for (int i = 0; i < symbolsOfText.length; i++) {
            if (listOfSymbols.containsValue(symbolsOfText[i])) {
                for (Map.Entry<Integer, Character> pair : listOfSymbols.entrySet()) {
                    int keyOfHashMap = pair.getKey();
                    char valueOfHashMap = pair.getValue();

                    if (symbolsOfText[i] == valueOfHashMap) {
                        newKeyOfHashMap = keyOfHashMap + offsetNumber;

                        if (newKeyOfHashMap <= listOfSymbols.size() && newKeyOfHashMap > 0)
                            stringBuilder.append(listOfSymbols.get(newKeyOfHashMap));
                        else if (newKeyOfHashMap > listOfSymbols.size())
                            stringBuilder.append(listOfSymbols.get(newKeyOfHashMap - listOfSymbols.size()));
                        else
                            stringBuilder.append(listOfSymbols.get(newKeyOfHashMap + listOfSymbols.size()));
                    }
                }
            } else
                stringBuilder.append(symbolsOfText[i]);
        }
        encryptText = stringBuilder.toString();
        return encryptText;
    }


    public static String bruteForce(String encryptText) {
        String decryptText = null;

        for (int i = 1; i <= Alphabet.getListOfSymbols().size(); i++) {
            decryptText = encrypt(encryptText, i);
            char[] symbolsOfDecryptText = decryptText.toCharArray();
            int count = 0;

            for (int j = 1; j < symbolsOfDecryptText.length; j++) {

                if (symbolsOfDecryptText[j - 1] == '.' && symbolsOfDecryptText[j] == ' ')
                    count++;
            }
            System.out.println(count);

            if (decryptText.contains(", ") && decryptText.contains(". ") && count >10)
                break;
        }
        return decryptText;
    }


    public static String decryptWhitStatisticAnalysis(String encryptText, HashMap<Integer, Double> statisticBase) {
        String decryptText = null;
        HashMap<Integer, Character> symbols = Alphabet.getListOfSymbols();
        HashMap<Integer, Double> statCharsOfEncryptText = getStatOfOccurCharsInText(encryptText);
        HashMap<Integer, Integer> decryptionKeyInt = new HashMap<>();
        HashMap<Character, Character> decryptionKeyChar = new HashMap<>();
        ArrayList<Map.Entry<Integer, Double>> listOfStatisticBaseFromOftenChar = new ArrayList<>(statisticBase.entrySet());
        ArrayList<Map.Entry<Integer, Double>> listOfStatCharsOfEncryptTextFromOftenChar = new ArrayList<>(statCharsOfEncryptText.entrySet());
        char[] symbolsOfEncryptText = encryptText.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();

        Collections.sort(listOfStatisticBaseFromOftenChar, new Comparator<Map.Entry<Integer, Double>>() {
            @Override
            public int compare(Map.Entry<Integer, Double> o1, Map.Entry<Integer, Double> o2) {
                return (int) ((o1.getValue() - o2.getValue()) * 1000000);
            }
        });

        Collections.sort(listOfStatCharsOfEncryptTextFromOftenChar, new Comparator<Map.Entry<Integer, Double>>() {
            @Override
            public int compare(Map.Entry<Integer, Double> o1, Map.Entry<Integer, Double> o2) {
                return (int) ((o1.getValue() - o2.getValue()) * 1000000);
            }
        });


        for (int i = 0; i < listOfStatisticBaseFromOftenChar.size(); i++) {
            decryptionKeyChar.put(symbols.get(listOfStatCharsOfEncryptTextFromOftenChar.get(i).getKey()), symbols.get(listOfStatisticBaseFromOftenChar.get(i).getKey()));
        }

        for (int i = 0; i < symbolsOfEncryptText.length; i++) {
            stringBuilder.append(decryptionKeyChar.get(symbolsOfEncryptText[i]));
        }

        decryptText = stringBuilder.toString();
        return decryptText;
    }


    public static HashMap<Integer, Double> getStatOfOccurCharsInText(String textForAnalysis) {
        HashMap<Integer, Double> statisticBase = new HashMap<>();
        HashMap<Integer, Character> symbols = Alphabet.getListOfSymbols();

        for (int i = 1; i < symbols.size(); i++) {
            double count = textForAnalysis.length() - textForAnalysis.replace(symbols.get(i).toString(), "").length();
            statisticBase.put(i, (count * 100) / textForAnalysis.length());
        }
        return statisticBase;
    }
}
