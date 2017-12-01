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
public class deneme {
    public static void main(String[] args) {
        Queue kuyruk=new Queue();
        Node node=new Node(1, 1, 4);
        Node node1=new Node(1, 2, 4);
        Node node2=new Node(1, 3, 4);
        Node node3=new Node(1, 4, 4);
        kuyruk.enqueue(node);
//        kuyruk.printList();
        kuyruk.enqueue(node1);
//        kuyruk.printList();
        kuyruk.enqueue(node2);
//        kuyruk.printList();
        kuyruk.enqueue(node3);
//        kuyruk.printList();
        kuyruk.dequeue();
//        kuyruk.printList();
        kuyruk.dequeue();
//        kuyruk.printList();
        kuyruk.dequeue();
//        kuyruk.printList();
        kuyruk.dequeue();
//        kuyruk.printList();
    }
}
