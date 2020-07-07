package com.examples.code;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * С консоли считывается адрес текстовго файла (например: c:/B.txt).
 * Далее происходит вывод в консоль содержимого файла, заменяя числа: 0,1,2 ... 12, на слова: "ноль", "один", "два" ...
 *
 * Пример данных в файле:
 * Этот товар стоит 2 рубля. А вот этот - 12.
 * Файл называется file1.
 * 230 - это число.
 *
 * Пример вывода в консоль:
 * Этот товар стоит два рубля. А вот этот - двенадцать.
 * Файл называется file1.
 * 230 - это число.
 *
 */

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        BufferedReader reader2 = new BufferedReader(new FileReader(fileName));
        while (reader2.ready()) {
            String result = reader2.readLine();
            for (int i = 12; i >= 0 ; i--) {
                result = result.replaceAll("\\b("+i+")\\b",map.get(i));
            }
            System.out.println(result);
        }
        reader2.close();

    }
}
