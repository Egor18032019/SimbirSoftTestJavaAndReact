package com.simbir.words.to;

import java.util.TreeMap;
import java.util.logging.Logger;

public class GetUniqueWords {
    private static final Logger log = Logger.getLogger(GetUniqueWords.class.getName());

    public static TreeMap<String, Integer> main(char[] delimiters, String text) {

        TreeMap<String, Integer> foo = new TreeMap<>();

        char[] textmakeChar = text.toCharArray();

        int indexBegin = 0;
        for (int i = 0; i < textmakeChar.length; i++) {
//        Приложение разбивает текст страницы на отдельные слова с помощью
//        списка разделителей.
            for (char delimiter : delimiters) {
                //если разделитель и символ в тексте равны то вырезаем
                if (delimiter == textmakeChar[i]) {
                    String word = text.substring(indexBegin, i).toUpperCase();
                    indexBegin = i + 1;

                    if (word.length() == 0) continue; // убрать пробелы
                    if (word.equals("—")) continue; // убрать тире
                    if (word.equals("-")) continue; // убрать минус
                    if (word.matches("[0-9]+[\\.]?[0-9]*")) continue; // убрать цифры

                    if (!foo.containsKey(word)) {
                        foo.put(word, 1);
                    } else {
                        foo.put(word, foo.get(word) + 1);
                    }
                }
            }
        }
        log.info("INFO get unique words ");
        return foo;
    }
}
