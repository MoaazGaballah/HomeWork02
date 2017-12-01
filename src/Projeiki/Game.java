/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projeiki;

import java.lang.reflect.Array;
import jdk.nashorn.internal.ir.ForNode;

/**
 *
 * @author moaaz
 */
public class Game {
    int sizeofX; //the limit of x  ( it must be private ) 
    int sizeofY; //the limit of y  ( it must be private ) 
    int x=0; // this will be current x  ( it must be private ) 
    int y=0; // this will be current y ( it must be private ) 
    Node labirent[][]; // our labirent ( it must be private ) 
    Node startPoint; // start point  ( it must be private ) 
    Node finishPoint; // finish point ( it must be private ) 
    Stack stack=new Stack(); // we will use stack in lookForTheRoad methodd ( it must be private ) 
    Queue queue=new Queue(); // we will use queue in findRecomendedNodes method ( it must be private ) 
    linkedList theWayOut=new linkedList(); // the list that have the way out of the labirent ( it must be private ) 
    
    // Game class constructor
    public Game(int x,int y,int startPointx,int startPointy,int finishPointx,int finishPointy) {
        this.sizeofX=x;
        this.sizeofY=y;
        // the start point in the labirent and we know that it is data will be "0"
        Node sPoint=new Node(0, startPointx, startPointy); 
        this.startPoint=sPoint; // send the node to the startPoint node known in the class
        // the finish point in the labirent and we know that it is data will be "0"
        Node fPoint=new Node(0,finishPointx,finishPointy); 
        this.finishPoint=fPoint; // send the node to the finishPoint known in the class
        // it takes values of y and x (by opposite) and craet an Array with that size
         labirent = (Node[][]) Array.newInstance(Node.class, sizeofY, sizeofX); 
//         for (int i = 0; i < this.sizeofX; i++) {
//             for (int j = 0; j < this.sizeofY; j++) {
//                 System.out.println(this.labirent[i][j].getData());
//             }
//        }
    }
    
    // set values of labirent
    void addDataToLabirent(int data, int x,int y) {// add data to the labirent
        Node temp =new Node(data,x,y); 
        labirent[x][y] = temp; // add data to our labirent at [X,Y]
        y++; // upadate y value (make it ready for next addition)
        if (y==sizeofY) { // if y break the limit go to the first endex of the next line 
            if (x+1!=sizeofX) { // if the next line exist
                y=0; // go to first endex
                x++; // update x value
            }
        }
    }
    
    // return the data at that location
    int getDataAt(int x, int y) {
        return labirent[x][y].getData();
    }
    
    // to find the recomended nodes ( will be called at lookForTheRoad method )
    int findRecomendedNodes(Node node){
        int counter=0; // to know how much nodes will be added to Queue
        Node temp=node;
        // ( 0 < x < sizeofX ) and ( 0 < y < sizeofY )
        if (temp.getX()>0&&temp.getX()<this.sizeofX&&temp.getY()>0&&temp.getY()<this.sizeofY) {
            // now find the nodes can be gone from the startPoint
            if (this.labirent[temp.getX()-1][temp.getY()].getData()==0) {
                // the up node of temp       
                this.queue.enqueue(this.labirent[temp.getX()-1][temp.getY()]);
                counter++;
            }
            if (this.labirent[temp.getX()+1][temp.getY()].getData()==0) {
                // // the down node of temp      
                this.queue.enqueue(this.labirent[temp.getX()+1][temp.getY()]);
                counter++;
            }
            if (this.labirent[temp.getX()][temp.getY()-1].getData()==0) {
                // the previous node of temp 
                this.queue.enqueue(this.labirent[temp.getX()][temp.getY()-1]);
                counter++;
            }
            if (this.labirent[temp.getX()][temp.getY()+1].getData()==0) {
                // the next node of temp 
                this.queue.enqueue(this.labirent[temp.getX()][temp.getY()+1]);
                counter++;
            }
        }
        // ( x=0 ) and ( 0 < y < sizeofY ) tekrar
        else if(temp.getX()==0&&temp.getY()>0&&temp.getY()<this.sizeofY){ 
            // now find the nodes can be gone from the startPoint
            if (this.labirent[temp.getX()+1][temp.getY()].getData()==0){
                // the down node of temp ( current = 1)      
                this.queue.enqueue(this.labirent[temp.getX()+1][temp.getY()]);
                counter++;
            }            
            if (this.labirent[temp.getX()][temp.getY()-1].getData()==0) {
                // the previous node of temp 
                this.queue.enqueue(this.labirent[temp.getX()][temp.getY()-1]);
                counter++;
            }
            if (this.labirent[temp.getX()][temp.getY()+1].getData()==0) {
                // the next node of temp
                this.queue.enqueue(this.labirent[temp.getX()][temp.getY()+1]);
                counter++;
            }
        }
        // ( x=sizeofX ) and ( 0 < y < sizeofY )
        else if(temp.getX()==this.sizeofX&&temp.getY()>0&&temp.getY()<this.sizeofY){ 
            // now find the nodes can be gone from the startPoint
            if (this.labirent[temp.getX()-1][temp.getY()].getData()==0){
                // the down node of temp       
                this.queue.enqueue(this.labirent[temp.getX()-1][temp.getY()]);
                counter++;
            }
            if (this.labirent[temp.getX()][temp.getY()-1].getData()==0) {
                // the previous node of temp 
                this.queue.enqueue(this.labirent[temp.getX()][temp.getY()-1]);
                counter++;
            }
            if (this.labirent[temp.getX()][temp.getY()+1].getData()==0) {
                // the next node of temp
                this.queue.enqueue(this.labirent[temp.getX()][temp.getY()+1]);
                counter++;
            }
        }
        // ( 0 < x < sizeofX ) and ( y =0 )
        else if(temp.getX()>0&&temp.getX()<this.sizeofX&&temp.getY()==0){ 
            // now find the nodes can be gone from the startPoint
            if (this.labirent[temp.getX()][temp.getY()+1].getData()==0){
                // the next node of temp      
                this.queue.enqueue(this.labirent[temp.getX()][temp.getY()+1]);
                counter++;
            }
            if (this.labirent[temp.getX()-1][temp.getY()].getData()==0) {
                // the up node of temp 
                this.queue.enqueue(this.labirent[temp.getX()-1][temp.getY()]);
                counter++;
            }
            if (this.labirent[temp.getX()+1][temp.getY()].getData()==0) {
                // the down node of temp 
                this.queue.enqueue(this.labirent[temp.getX()+1][temp.getY()]);
                counter++;
            }
        }
        // ( 0 < x < sizeofX ) and ( y=sizeofY )
        else if(temp.getX()>0&&temp.getX()<this.sizeofY&&temp.getY()==this.sizeofX){ 
            // now find the nodes can be gone from the startPoint
            if (this.labirent[temp.getX()][temp.getY()-1].getData()==0){
                // the previous node of temp       
                this.queue.enqueue(this.labirent[temp.getX()][temp.getY()-1]);
                counter++;
            }
            if (this.labirent[temp.getX()-1][temp.getY()].getData()==0) {
                // the up node of temp 
                this.queue.enqueue(this.labirent[temp.getX()-1][temp.getY()]);
                counter++;
            }
            if (this.labirent[temp.getX()+1][temp.getY()].getData()==0) {
                // the down node of temp
                this.queue.enqueue(this.labirent[temp.getX()+1][temp.getY()]);
                counter++;
            }
        }
        // ( x=0 ) and ( y=0 )
        else{
            if (this.labirent[temp.getX()+1][temp.getY()].getData()==0) {
                // the down node of temp       
                this.queue.enqueue(this.labirent[temp.getX()+1][temp.getY()]);
                counter++;
            }
            if (this.labirent[temp.getX()][temp.getY()+1].getData()==0) {
                // the next node of temp 
                this.queue.enqueue(this.labirent[temp.getX()][temp.getY()+1]);
                counter++;
            }
        }
        return counter;
    }
    
    // send the startPoint to Stack 
    // send the recommended nodes to Queue ( if there is no recommended nodes pop it from stack )
    // dequeue from Queue and push it to Stack 
    linkedList lookForTheRoad(){
        this.stack.push(this.labirent[this.startPoint.getX()][this.startPoint.getY()]); // send the start point to stack 
        this.startPoint.visited=true; // make it visited
        Node temp=this.startPoint;
        // we set the that t to update the temp node to be ready for findRecomendedNodes method
        Node t=temp;
        while (temp!=this.finishPoint) {
            int comeBackVlaue=this.findRecomendedNodes(temp); // if the number of come back nodes =0
            if (comeBackVlaue==0) {
                this.stack.pop(); // that means there is no nodes to go so pop it from stack 
            }
            t = this.queue.dequeue(); // we will update temp with this node
            // make a control if that node in stack or not 
            if (t != this.stack.header&& t.visited == false) { //( it is done anyway do it again )
                this.stack.push(t); // if not dequeue it from Queue and add it to stack 
                t.visited = true; // make it visited not to be add agian to stack 
            }
            // now we have to update temp that sent to findRecommendedNodes method 
            temp = t;
        }
        // now copy the stack 
        copyStack();
        // return our way ouuuuuuut !
        return this.theWayOut;
    }
    
    // copy the elemants in stack to theWayOut linkedlist
    void copyStack(){
        Node  temp=this.stack.pop();
        while(temp!=null){
            // add the node poped from stack
            this.theWayOut.addFirst(temp, temp.getX(), temp.getY());
        }
    }
}
