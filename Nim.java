//Project 1: Racquel Miller
package com.FirstProject;

public class Nim {

    public static void main(String[] args) {
        Marbles marbleCount = new Marbles();
            marbleCount.printMarbles();
        while(marbleCount.printMarblesLeft() > 0){
            marbleCount.printTake();
            System.out.println();
        }
        marbleCount.winLose();
    }
}
