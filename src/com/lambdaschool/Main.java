package com.lambdaschool;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.function.Function;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        System.out.println("firetest");

        File filePath = new File("text.txt");

        HashMap<String, Integer> counter = new HashMap<>(50);

        Scanner sc;
        try {
            sc = new Scanner(filePath).useDelimiter(Pattern.compile("[^A-Za-z0-9]+"));
            while (sc.hasNext()) {
                String word = sc.next();
                word = word.toLowerCase();
                counter.put(word, counter.getOrDefault(word, 0) + 1);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ArrayList<HashMap.Entry<String, Integer>> list = new ArrayList<>(counter.entrySet());
        list.sort(Comparator.comparing((Function<Map.Entry<String, Integer>, Integer>) Map.Entry::getValue).reversed());
        List<HashMap.Entry<String, Integer>> top50 = list.subList(0, 50);

        for (HashMap.Entry<String, Integer> entry : top50) {
            System.out.println("Word: " + entry.getKey() + ", Count: " + entry.getValue() + "\n");
        }
    }
}
