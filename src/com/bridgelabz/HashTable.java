package com.bridgelabz;
import java.util.Hashtable;
public class HashTable
{
	public static void main(String[] args) 
	{
		HashtableImpl<String, Integer> hashImpl = new HashtableImpl();
        String message = "Paranoids are not paranoid because they are paranoid but " +
                "because they keep putting themselves deliberately into paranoid avoidable situations";

        //String to String[] conversion.
        String[] messageArray = message.toLowerCase().split(" ");

        //Iterate within the array
        for(String word: messageArray) 
        {
            //Search for the word in the linked list
            Integer value =  hashImpl.get(word);
            if( value == null)
                value = 1;
            else
                value = value + 1;
            hashImpl.add(word , value);
        }
        //Display the linked list
        System.out.println(hashImpl);
        //Remove "avoidable" from the hashtable
        hashImpl.remove("avoidable");

        //Display the hashtable
        System.out.println(hashImpl);
}
}