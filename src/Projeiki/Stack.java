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
public class Stack {
    Node header;
    private int size=0;
    
    // push to stack
    void push (Node  newNode){
        if(this.header==null){
            header=newNode;
        }
        else{
            newNode.next=header;
            header=newNode;
        }
        size++;
        System.out.print("Your Stack now is : ");
        this.printList();
    }
    
    // Pop from stack
    Node pop(){
        if (header==null) {
            System.out.println("list is empty ! ");
            return null;
        }
        else{
            Node temp=header;
            header=header.next;
            temp.next=null;
            size--;
            System.out.print("Your Stack now is : ");
            this.printList();
            return temp;
        }
    }
    Node showTheTop(){
        return header;
    }
    // Read the top of stack
    int peek(){
        if (header==null){
            System.out.println("list is empty !!!!!!");
            return 0;
        }
        else
            return header.getData();
    }
    
    //Show the elemants of stack
    void printList(){
        Node  temp=header;
        while(temp!=null){
            System.out.print("["+temp.getX()+","+temp.getY()+"] --> ");
            temp=temp.next;
        }
        System.out.println("null");
    }
    
    //Return size of stack
    public int getSize() {
        return size;
    }
    
}
