package com.app;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Solution.LinkedList linkedList = new Solution.LinkedList();
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(4);
        linkedList.append(5);
        Solution.Node node = solution.getMiddleNode(linkedList);
        solution.removeNode(node);
        System.out.println(linkedList);
    }
}
