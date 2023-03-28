package com.bridgelabz;

import java.util.ArrayList;
import java.util.List;

public class HashTable<K,V> {

    int bucketSize;

    List<HashLinkedList<K, V>> bucketArray = new ArrayList<>(bucketSize);

    public HashTable(int bucketSize) {
        this.bucketSize = bucketSize;
        for (int i = 0; i < bucketSize; i++) {
            bucketArray.add(i, null);
        }
    }
    public int getIndex(K key) {
        int index = Math.abs(key.hashCode()) % bucketSize;    //h(k) = hashcode of k % m;
        return index;
    }

    public void addOrUpdate(K key, V value) {
        int index = getIndex(key);
        HashLinkedList<K, V> myLinkedList = bucketArray.get(index);   //when linked list newly created;
        if (myLinkedList == null) {
            myLinkedList = new HashLinkedList<>();
            bucketArray.add(index, myLinkedList);
            myLinkedList.append(key, value);
        }else {
            HashNode<K,V> currentNode = myLinkedList.search(key); //when linked list already exist;
            if (currentNode != null){
                currentNode.value = value;
            }else {
                myLinkedList.append(key,value);
            }
        }
    }
    public V get(K key) {
        int index = getIndex(key);
        HashLinkedList<K, V> myLinkedList = bucketArray.get(index);
        if (myLinkedList == null)
            return null;
        HashNode<K,V> currentNode = myLinkedList.search(key);
        return currentNode != null ? currentNode.value : null;
       /** if (currentNode != null){
            return currentNode.value;
        }else
            return null;
        **/
    }

    @Override
    public String toString() {
        return "HashTable{" +
                "bucketArray=" + bucketArray +
                '}';
    }
}

