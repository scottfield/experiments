package com.gnum.experiments;

/**
 * @author jackie
 * @date 2015/10/13
 */
public class LinkedStack<T> {
    private class Node<U> {
        U item;
        Node<U> next;

        Node() {
            item = null;
            next = null;
        }

        Node(U item, Node<U> next) {
            this.item = item;
            this.next = next;
        }

        boolean end() {
            return item == null && next == null;
        }
    }

    private Node<T> top = new Node<T>();//end sentinel

    public void push(T item) {
        top = new Node<T>(item, top);
    }

    public T pop() {
        T item = top.item;
        if (!top.end()) {
            top = top.next;
        }
        return item;
    }

    public static void main(String[] args) {
        LinkedStack<String> ls = new LinkedStack<>();
        for(String s:"hello world m".split(" ")) {
            ls.push(s);
        }
        String str ;
        while ((str = ls.pop()) != null) {
            System.out.println(str);
        }
    }

}
