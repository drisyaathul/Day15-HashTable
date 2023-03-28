package com.bridgelabz;


public class HashTableMain {

    public static void main(String[] args) {

        String paraGraph = "Paranoids are not paranoid because they are paranoid but because they keep putting themselves deliberately into paranoid avoidable situations";
        HashTable <String,Integer> hashTable = new HashTable<>(6);
        String[] wordsArray = paraGraph.split(" ");     //split based on paragraph;

        for (String word : wordsArray) {
            //System.out.print(word +" => " +word.hashCode());  //to find hashCode of each word;
            //int index = hashTable.getIndex(word);   //to find index of each word;
            //System.out.println(word +" -> " + word.hashCode()+ " -> " +index);
            Integer currentFrequency = hashTable.get(word); //if the value is +1;

            if (currentFrequency == null)
                currentFrequency = 1;
            else
                currentFrequency++;

            hashTable.addOrUpdate(word,currentFrequency);
        }
        System.out.println(hashTable);
    }
}