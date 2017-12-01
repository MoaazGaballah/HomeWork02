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
public interface GameInterface {
    
    void addDataToNetwork(int data); // fill in the network with random intial data ( null) 
    Node getDataAt(int x, int y); // return the data at the location 
    void findRecomendedNodes(Node node); // it is find the recomended nodes for any node in the labirent
    linkedList lookForTheRoad(); // it return the way out ( solution ) of the labirent
    void copyStack(); // this method copy the nodes in the stack to the theWayOut linkedlist and make it ready for printing
    
}
