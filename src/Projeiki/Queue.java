/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projeiki;

/**
 *
 * @author moaaz
 */
public class Queue {
    
    private Node header;
    private int size=0;

    // return the value of size
    public int getSize() {
        return size;
    }
    
    //add last
    void enqueue(Node newNode){
        if (header==null) {
            header=newNode;
        }
        else{
            Node temp=header;
            while (temp.next!=null) {
                temp=temp.next;
            }
            temp.next=newNode;
            newNode.next=null;
        }
        System.out.print("Your Queue now is : ");
        this.printList();
        size++;
    }
    
    // Remove first
    Node dequeue(){
        if (header!=null) {
            Node temp=header;
            header=header.next;
            temp.next=null;
            size--;
            System.out.print("Your Queue now is : ");
            this.printList();
            return temp;
        }
        else{
            System.out.println("Queue is empty ! ");
            return null;
        }
        
    }
    
    //Show elemants
    void printList(){
        if (header==null) {
            System.out.println("Queue is empty ! ");
        }
        else{
            Node temp=header;
            while (temp!=null) {                
                System.out.print("["+temp.getX()+","+temp.getY()+"] --> ");
                temp=temp.next;
            }
            System.out.println("null");
        }
    }
}
