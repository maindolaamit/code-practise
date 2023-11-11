package com.neetcode.practise.basic;

import java.util.ArrayList;

class DynamicArray {

    private int capacity = 1;
    private int size = 0;
    private Integer[] arr;

    public DynamicArray(int capacity) {
        this.capacity = capacity;
        this.arr = new Integer[capacity];
    }

    public Integer get(int i) {
        return arr[i];
    }

    public void set(int i, Integer n) {
        // resize if capacity is full
        this.arr[i] = n;
    }

    public void pushback(int n) {
        this.set(arr.length - 1, n );
    }

    public int popback() {
        int value = this.arr[this.arr.length - 1];
        this.set(this.arr.length - 1, null);
        this.size--;
        return value;
    }

    private void resize() {
        this.capacity = this.capacity * 2;
        Integer[] arr2 = new Integer[this.capacity];
        for (int i = 0; i < arr.length; i++) {
            arr2[i] = arr[i];
        }
        this.arr = arr2;
        ;
    }

    public int getSize() {
        return this.size;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public static void print(ArrayList<Integer> results) {
        StringBuilder output = new StringBuilder().append("[");
        results.stream().forEach(result -> output.append(result).append(", "));
        output.append("]");
        System.out.println(output);
    }

    public static ArrayList<Integer> process(String[] args, DynamicArray arr) {
        int capacity = Integer.parseInt(args[1]);
        arr = new DynamicArray(capacity);
        ArrayList<Integer> results = new ArrayList<>();
        results.add(null);
        for (int i = 2; i < args.length; i++) {
            String operation = (String) args[i];
            Integer value = null;
            switch (operation.toLowerCase()) {
                case "pushback":
                    value = Integer.parseInt(args[++i]);
                    arr.pushback(value);
                    results.add(null);
                    break;
                case "popback":
                    results.add(arr.popback());
                    break;
                case "get":
                    value = Integer.parseInt(args[++i]);
                    results.add(arr.get(value));
                    break;
                case "set":
                    Integer value1 = Integer.parseInt(args[++i]), value2 = Integer.parseInt(args[++i]);
                    arr.set(value1, value2);
                    results.add(null);
                    break;
                case "getsize":
                    results.add(arr.getSize());
                    break;
                case "getcapacity":
                    results.add(arr.getCapacity());
                    break;
                case "resize":
                    arr.resize();
                    results.add(null);
                    break;
                default:
                    System.out.println("Invalid operation");
            }
        }
        return results;
    }

    public static void main(String[] args) {
        DynamicArray arr = new DynamicArray(1);
        ArrayList<Integer> results = process(args, arr);
        print(results);
    }
}
