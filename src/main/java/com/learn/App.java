package com.learn;

import java.lang.reflect.Array;
import java.util.*;
import java.util.regex.*;

/**
 * Hello world!
 */
public class App {

    public static void addIntegers(List<? super Integer> list){
        list.add(new Integer(50));
    }

    public static void main2(String[] args) {

        List<? extends Integer> intList1 = new ArrayList<>();
        List<? extends Number>  numList1;

        List<Integer> l1 = new ArrayList<>();
        List<Number> l2 = new ArrayList<>();
        List<Double> l3 = new ArrayList<>();

        addIntegers(l2);

        Integer integer = 1;
        Double doubles = 2.0;
        Number number = 2;

        number = integer;
        number = doubles;

        Pattern pattern = Pattern.compile("(\\d+)([a-z]+)");
        Matcher matcher = pattern.matcher("21ab234ab21ab");
        // using Matcher find(), group(), start() and end() methods

        while (matcher.find()) {
            System.out.println("Found the text \"" + matcher.group(1) + " " + matcher.group(2)
                    + "\" starting at " + matcher.start()
                    + " index and ending at index " + matcher.end());
        }

//        Pattern pattern = Pattern.compile(".xx.");
//        Matcher matcher = pattern.matcher("MxxY");
//        System.out.println("Input String matches regex - " + matcher.matches());
//
//        String str = "bbb";
//        System.out.println("Using String matches method: " + str.matches(".bb"));
//        System.out.println("Using Pattern matches method: " + Pattern.matches("^[abc]d.", "ad9"));
    }

    public static void main(String[] args) {
        String str = "abc";
        str.length();
        str.startsWith("");
        str.substring(0);
        str.toCharArray();
        str.indexOf("");
        str.lastIndexOf("");
        str.split("");
        str.charAt(0);
        str.contains("");
        str.replace("", "");
        str.toLowerCase();
        str.toUpperCase();
        str.matches("regex");


        StringBuilder sb = new StringBuilder();
        sb.append("abcdef");
        sb.reverse();
        sb.insert(1, "");
        sb.delete(0, 1);
        sb.deleteCharAt(0);
        sb.indexOf("");
        sb.lastIndexOf("");
        sb.replace(0, 2, "dd");

        List al = new ArrayList();
        Set s = new HashSet();
        Stack<String> stack = new Stack();
        Map<String, String> map = new HashMap<>();
        map.put("1", "value1");
        map.getOrDefault("1", "default");
        map.get("1");
        map.remove("2");
        map.replace("1", "new value");
        map.containsKey("1");
        map.containsValue("2");
        map.keySet();
        map.values();
        for(Map.Entry<String, String> entry: map.entrySet()) {
        }
        map.forEach((key, value) -> {

        });

        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");

        stack.remove("2");
        stack.remove(1);
        stack.forEach(System.out::println);

        Queue<String> queue = new PriorityQueue<>();
        queue.remove();
        queue.remove("");
        queue.peek();
        queue.poll();
        queue.remove();

        Deque<String> dequeue = new LinkedList<>();
        dequeue.addFirst("");
        dequeue.addLast("");
        dequeue.removeFirst();
        dequeue.removeLast();

        /*
        Collection: size(), iterator(), add(), remove(), clear()
        List (ArrayList, LinkedList) , Set (HashSet, TreeSet), Map (HashMap, TreeMap) , Queue, Stack
        ArrayList:
         */
    }

}
