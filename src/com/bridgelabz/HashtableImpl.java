package com.bridgelabz;
import java.util.ArrayList;
public class HashtableImpl<K, V> 
{
	Node head;
    Node tail;
    private final int numOfBuckets;
    ArrayList<Node<K,V>> myBucketArray;

    public HashtableImpl() 
    {
        this.numOfBuckets = 20;                    
        this.myBucketArray = new ArrayList<>();
        for (int i = 0; i < numOfBuckets; i++)
            this.myBucketArray.add(null);
    }
    public void add(K key, V value) 
    {
    	 int index = this.getBucketIndex(key);
         Node<K,V> myNode= this.myBucketArray.get(index);
         if(myNode == null) 
         {
             myNode = new Node<>(key , value);
             this.myBucketArray.set(index, myNode);
         }
         myNode = (Node<K, V>) searchNode(key);
         if(myNode == null) 
         {
             myNode = new Node<>(key , value);
             this.append(myNode);
         }
         else 
         {
             myNode.setValue(value);
         }
    }

    //Append the value in the linked list
    public void append(Node<K, V> myNode) 
    {
        if(this.head == null)
            this.head = myNode;
        if(this.tail == null)
            this.tail = myNode;
        else {
            this.tail.setNext(myNode);
            this.tail = myNode;
        }
    }

    //Searching for the word in the linked list
    public Node<K, V> searchNode(K data) 
    {
        Node<K, V> currentNode = head;
        int position = 0;
        while (currentNode != null) 
        {
            position++;
            if (currentNode.getKey().equals(data)) 
            {
                return currentNode;
            }
            currentNode = currentNode.getNext();
        }
        return currentNode;
    }

    //Searching for the word and get the value from the linked list
    public V get(K word) 
    {
    	int index = this.getBucketIndex(word);
        if(this.myBucketArray.get(index) == null)
            return null;
        Node<K, V> myMapNode = searchNode(word);
        return (myMapNode == null) ? null : myMapNode.getValue();
    }
    //hashcode to find the index
    private int getBucketIndex(K word) 
    {
        int hashCode = Math.abs(word.hashCode());
        int index = hashCode % numOfBuckets;
        //System.out.println("Key: "+word+" hashcode: "+hashCode+" index: "+index);
        return index;
    }
    //Print the linked list
    @Override
    public String toString() 
    {
        return "MyLinkedListNodes{" + head + "}";
    }
   
    public void printNodes() 
    {
        System.out.println("My nodes: " + head);
    }
}
