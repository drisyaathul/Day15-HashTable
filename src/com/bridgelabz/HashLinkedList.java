package com.bridgelabz;

public class HashLinkedList<K,V> {

    HashNode<K,V> head;
    HashNode<K,V> tail;

    public void append(K key, V value) {

        HashNode<K,V> newNode = new HashNode<>(key,value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }
    public void push(K key,V value) {

        HashNode<K,V> newNode = new HashNode<>(key,value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }
    public void display() {

        HashNode<K,V> temp = head;
        while (temp != null) {
            System.out.print(temp.key +" = "+ temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println();
    }
    public HashNode<K,V> pop() {

        if (head == null)
            return null;
        HashNode<K,V> popData = head;
        head = head.next;
        return popData;
    }
    public HashNode<K,V> popLast() {

        if (head == null)
            return null;
        HashNode<K,V> popData = tail;
        HashNode<K,V> temp = head;
        while (temp.next != tail) {
            temp = temp.next;
        }
        temp.next = null;
        tail = temp;
        return popData;
    }
    public HashNode<K,V> search(K searchData) {

        HashNode<K,V> temp = head;
        while (temp != null) {
            if (temp.key.equals(searchData)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
    public boolean delete(K key) {
        HashNode<K,V> temp1 = head;
        HashNode<K,V> temp2 = head;
        HashNode<K,V> temp3 = head;
        int count = 0;
        while (temp1 != null & temp2 != null & temp3 != null) {
            count++;
            if (count > 2) {
                temp3 = temp3.next;
            }
            if (temp1.key == key) {
                temp2 = temp2.next;
                temp3.next = temp2;
                return true;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return false;
    }

    @Override
    public String toString() {
        return " \n{" + head + "}";
    }
}







