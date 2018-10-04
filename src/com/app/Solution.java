package com.app;

public class Solution {

    // You can assume the given node is in the middle (i.e. node.next is NOT null)
    public void removeNode(Node node) {
        Node next = node.next;
        node.val = next.val;
        node.next = next.next;
        next.next = null; // Now next can be garbage-collected
    }

    public Node getMiddleNode(LinkedList linkedList) {
        int middle = (linkedList.size % 2 == 0) ? (linkedList.size / 2 - 1) : linkedList.size / 2;
        Node node = linkedList.head.next;
        int i = 0;
        while (middle != i) {
            node = node.next;
            i++;
        }
        return node;
    }

    public static class LinkedList {

        private int size = 0;
        private Node head = new Node(0); // dummy node
        private Node tail = head; // not a dummy node

        void append(int val) {
            Node node = new Node(val);
            tail.next = node;
            tail = tail.next;
            size++;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof LinkedList)) {
                return false;
            }
            LinkedList other = (LinkedList) o;
            Node node = head.next;
            Node otherNode = other.head.next;
            while (node != null && otherNode != null) {
                if (node.val == otherNode.val) {
                    node = node.next;
                    otherNode = otherNode.next;
                } else {
                    return false;
                }
            }
            return node == null && otherNode == null;
        }

        @Override
        public int hashCode() {
            int res = 17;
            Node node = head.next;
            while (node != null) {
                res = 31 * res + node.val;
                node = node.next;
            }
            return res;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("[");
            Node node = head.next;
            while (node != null) {
                builder.append(node.val);
                if (node.next != null) {
                    builder.append(" > ");
                }
                node = node.next;
            }
            builder.append("]");
            return builder.toString();
        }
    }

    public static class Node {

        Node next;
        int val;

        Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return Integer.toString(val);
        }
    }
}