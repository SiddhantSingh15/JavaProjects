package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        // DYNAMIC ARRAYS

        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 1; i <= 10; i++){
            list.add(i);
        }

        System.out.println(list);

        ArrayList<Integer> list1 = new ArrayList<>(30); // setting the initial capacity

        list1.add(1); // appending the array
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.set(2,100); // replaces the second index with 100

        System.out.println(list1);

        list1.remove(1); // removes the val at index = 1, O(n) = BAD
        System.out.println(list1);

        list1.add(8);
        list1.remove(list1.size()-1); // removes the last val from the list
        System.out.println(list1);


        System.out.println(list1.get(0)); // gets the val at index = 0

        int[] arr = {1, 7, 8, 90};

        for(int element:arr){  // the FOR EACH loop
            System.out.println(element);
        }

        System.out.println("---------------");


        // STACKS

        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println(stack.peek()); // printing the last element of a stack

        stack.pop(); // removing the last element of the stack
        System.out.println(stack.size());

        System.out.println("---------------");


        // QUEUES

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);

        q.poll(); // removing the first element of the queue
        System.out.println(q.peek()); // prints the first element of the queue

        System.out.println("---------------");


        // DEQUEUE

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(1); // [1]
        deque.addFirst(2);  // [2,1]
        deque.addLast(3);  // [2,1,3]
        deque.removeFirst();  // [1,3]
        deque.addFirst(8); // [8,1,3]
        deque.removeLast();  // [1,3]
        System.out.println(deque);

        System.out.println("---------------");


        // PRIORITY QUEUES (sorts the queue with the input)

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(10);  // [10]
        pq.add(20);  // [20,10]
        pq.add(8);  // [20,10,8]
        pq.add(7);  // [20,10,8,7]
        System.out.println(pq.peek());  //Prints the smallest value in the priority queue
        pq.poll();  // [20,10,8]
        pq.poll();  // [20,10]
        pq.add(11);  // [20,11,10]
        System.out.println(pq);

        System.out.println("---------------");


        // UNORDERED SETS

        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);

        System.out.println(set.contains(3));  // Returns TRUE

        set.remove(1);  // removes the element 1 from the set

        System.out.println(set.contains(1));  // Returns FALSE

        set.remove(0);  // nothing happens as 0 doesnt exist in the set

        for(int element:set){
            System.out.println(element);  // iterates through the set in unordered way
        }

        System.out.println("---------------");


        // ORDERED SETS  O(logn) complexity

        TreeSet<Integer> tree = new TreeSet<>();
        tree.add(1);  // [1]
        tree.add(30);  // [1,30]
        tree.add(18);  // [1,30,18]
        tree.add(19);  // [1,18,19,30]
        System.out.println(tree.higher(18));  // returns first element greater than 18
        System.out.println(tree.higher(tree.higher(18)));  // returns the second element greater than 18
        System.out.println(tree.lower(18));  // returns the first element lower than 18
        System.out.println(tree.first());  // returns the smallest element in the set
        System.out.println(tree.last());  // returns the largest element in the set
        System.out.println(tree.higher(tree.last()));  // ERROR, no such element exists

        System.out.println("---------------");



        // MAPS

        Map<String, Integer> map = new HashMap<>();  // creating an ordered map

        map.put("a", 100);
        map.put("b", 200);
        map.put("c", 300);
        map.put("d", 400);

        Set<Map.Entry<String, Integer>> st = map.entrySet();

        for (Map.Entry<String, Integer> me: st){
            System.out.println(me.getKey() + ":");
            System.out.println(me.getValue());
        }

        System.out.println("---------------");


        // ORDERED MAPS


        TreeMap<Integer, Integer> omap = new TreeMap<>();
        omap.put(1,5);  // [(1,5)]
        omap.put(17,7);  // [(1,5); (17,7)]
        omap.put(4,100);  // [(1,5); (4,10); (17,7)]

        System.out.println(omap.firstKey());  // returns 1
        System.out.println(omap.firstEntry()); // returns (1,5)
        System.out.println(omap.lastEntry()); // returns (17,7)
        System.out.println(omap.higherEntry(7)); // returns the entry with the key higher than 7
        omap.remove(17);
        System.out.println(omap.lowerKey(4));  // returns 1
        System.out.println(omap.lowerKey(1));

        System.out.println("---------------");

        // UNORDERED MAPS

        HashMap<Integer, Integer> umap = new HashMap<>();
        umap.put(1,5);  // [(1,5)]
        umap.put(2,7);  // [(1,5); (2,7)]
        umap.put(3,10);  // [(1,5); (2,7); (3,10)]
        umap.remove(2); // removes the elements with key = 2  --> [(1,5); (3,10)]
        System.out.println(umap.get(1)); // returns 5
        System.out.println(umap.containsKey(3));  // returns TRUE
        System.out.println(umap.containsValue(10));  // returns TRUE

        System.out.println("---------------");


    }
}
