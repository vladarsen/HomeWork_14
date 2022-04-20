package com.vladarsenjtev;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        List<Integer> integers = new ArrayList<>();
        strings.add("Привет");
        strings.add("Java");
        strings.add("Привет");

        integers.add(1);
        integers.add(2);
        integers.add(5);
        integers.add(7);
        integers.add(1);
        integers.add(2);

        System.out.println(strings);
        System.out.println();
        System.out.println(convertToUnique(strings));
        System.out.println();
        System.out.println(integers);
        System.out.println(getSortedUniqueIntegersASC(integers));
        System.out.println(getSortedUniqueIntegersDESC(integers));
        System.out.println();
        System.out.println(strings);
        System.out.println(buildSentenceDirection(strings));

    }

    public static Set<String> convertToUnique(List<String> str) {
        return new HashSet<>(str);
    }

    public static Set<Integer> getSortedUniqueIntegersASC(List<Integer> ints) {
        return new HashSet<>(ints);
    }

    public static Set<Integer> getSortedUniqueIntegersDESC(List<Integer> ints) {
        Set<Integer> set = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (Integer integers : ints) {
            set.add(integers);
        }
        return set;
    }

    public static Set<String> buildSentenceDirection(List<String> str) {
        Set<String> stringList = new LinkedHashSet<>();
        stringList.addAll(str);
        return stringList;
    }
}
