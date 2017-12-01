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
// Node s type is integer
public class Node {
    /*
    There is will be next, down, data(0 OR 1), x, y and visited 
    */
    protected Node next;
    protected Node previous;
    protected Node down;
    protected Node up;
    private  int data;
    private int x;
    private int y;
    protected boolean visited=false;
    
    // will be used in stack and queue calsses
     public Node(int  data,int x,int y) {
        this.data = data;
        this.next=null;
        this.previous=null;
        this.down=null;
        this.up=null;
        this.x=x;
        this.y=y;
    }
     
    // set the value of Y (the x will be send , y)
    public void setX(int x) {
        this.x = x;
    }
    
    // set the value of Y (x , the y will be send)
    public void setY(int y) {
        this.y = y;
    }
    
    // get the value of X (?,y)
    public int getX() {
        return x;
    }
    
    // get the value of Y (x,?)
    public int getY() {
        return y;
    }
    
    //return the statue of the node is visited or not 
    public boolean isVisited() {
        return visited;
    }
    
    // return the data of a node 
    public int getData() {
        return data;
    }
    
}
