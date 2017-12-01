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
public class linkedList {
    private Node header;
    private int size = 0;
  
    //return size of linkidList
    public int getSize() {
        return size;
    }
    
    // add first
    void addFirst(Node  newNode,int x,int y) {
        if (header == null) {
            header = newNode;
            size++;
        } else {
            newNode.next = header;
            header.previous = newNode;
            header = newNode;
            size++;
        }
    }
    
    //print list
    void printList() {
        Node temp = header;
  
        while (temp != null) {
            System.out.print("["+temp.getX() + ","+temp.getY() +"] --->  ");
            temp = temp.next;
        }
  
        System.out.print("null\n");
    }
}
