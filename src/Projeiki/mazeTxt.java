/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projeiki;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.shape.Line;

/**
 *
 * @author moaaz
 */
public class mazeTxt {
    // creat a game
    static Game game;
    
    // read data and set values to the game from maze.txt
    static void readFile() throws IOException{        
        FileReader file = new FileReader("D:\\FSM\\bahar 2016-2017\\Veri yapıları\\maze.txt"); // file reader objecet
        BufferedReader br = new BufferedReader(file); // this is buffered reader object
        Scanner scan = new Scanner(br); // this is will read lines from the file
        file=null; // send the first vlaue of file
        br=null; // send the first value of br
        String temp; // we will use it in for loop
        int counter=0; // we will use it to break while loop 
        int sizeOfx=0, sizeOfy=0;
        int startPointx=0, startPointy=0;
        int finishPointx=0, finishPointy=0;
        while (scan.hasNext()) { // read a line from the maze.txt file  
            if (counter < 6) {
                if (counter == 0) {
                    sizeOfx = scan.nextInt(); // set sizeOfx belongs to labirent
                    counter++; 
                    continue;
                } else if (counter == 1) {
                    sizeOfy = scan.nextInt(); // set sizeOfy belongs to labirent
                    counter++;
                    continue;
                } else if (counter == 2) {
                    startPointx = scan.nextInt(); // set startPointX belongs to labirent
                    counter++;
                    continue;
                } else if (counter == 3) {
                    startPointy = scan.nextInt();// set startPointy belongs to labirent
                    counter++;
                    continue;
                } else if (counter == 4) {
                    finishPointx = scan.nextInt(); // set finishPointX belongs to labirent
                    counter++;
                    continue;
                } else if (counter == 5) {
                    finishPointy = scan.nextInt();; // set finishPointy belongs to labirent
                }
            }
            if (counter==5) { // set these value when counter=5
                // creat new game at the same time we set the sizeof x and y ,startPointx,startPointy, finishPointx
                // and finishPointy of the game object
                Game g = new Game(sizeOfx, sizeOfy,startPointx,startPointy,finishPointx,finishPointy);
                game=g;
                counter++;
                continue;
            }
            else {
                // you have to convert from string to integer
                for (int i = 0; i < game.sizeofX; i++) { // this for loop to scan the string length to convert it to integer
                    int x=i; // this is the value of y
                    temp = scan.next(); //this is line had been red
                    for (int j = 0; j < game.sizeofY; j++) {
                        int y=j; // this is the value of x
                        int intTemp = Integer.parseInt(String.valueOf(temp.charAt(j)));// convert from char to int
                        game.addDataToLabirent(intTemp,x,y);
                    }
                }
            }
        }
        
        if (file!=null) {// if file reader still opened
            try {
                file.close(); // close it 
            } catch (IOException ex) {
                System.out.println(" FileReader had not been closed yet !");
            }
        }
        if (br!=null) { // if Buffered reader still opened
            try {  
                br.close(); // close it 
            } catch (IOException ex) {
                System.out.println("BufferedReader had not been closed yet !");            }
        }
    }
    
    // main method
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // at first read the file 
        readFile();
        // now we have to find the way out of the labirent
        linkedList theWayOut =game.lookForTheRoad();
        // then print theWayOut linkidList to the screen
        theWayOut.printList();
    }
}
