package com.FirstProject;

import java.util.Random;
import java.util.Scanner;

public class Marbles{
    public int numMarbles;
    public int numFirst;
    public int userInputRequest;
    public int humanVSComputer;
    public int easyHard;

    public Marbles(){
        Random numberM = new Random();
        numMarbles = numberM.nextInt(90+1)+10;
        Random numF = new Random();
        numFirst = numF.nextInt(1+1);
        humanVSComputer = numFirst;
        easyHard = numF.nextInt(1+1);

    }
    public void printMarbles(){
        System.out.println("Starting amount of Marbles is: " + numMarbles);
        if(easyHard == 0){
            System.out.println("Computer Difficulty: EASY");
        }
        else {
            System.out.println("Computer Difficulty: HARD");
        }
        System.out.println();
        if(numFirst ==  0) {
            System.out.println("Human Goes First");
            humanVSComputer = 0;
        }
        else{
            System.out.println("Computer Goes First");
            humanVSComputer = 1;
        }
    }

    public void printTake(){
        int Take;
        if(humanVSComputer == 0) {
            if(numMarbles <= 3){
                System.out.println("You can only take 1.");
                Scanner sc = new Scanner(System.in);
                System.out.println("How many would you like to take? ");
                int requests = Integer.parseInt(sc.nextLine());
                if(requests == 1) {
                    numMarbles = numMarbles - requests;
                    humanVSComputer = 1;
                    userInputRequest = requests;
                }
                else{
                    humanVSComputer = 0;
                }
            }
            else {
                System.out.println("You can only take 1 to " + numMarbles / 2 + ".");
                Scanner sc = new Scanner(System.in);
                System.out.println("How many would you like to take? ");
                int requests = Integer.parseInt(sc.nextLine());
                if (requests <= numMarbles / 2 && requests > 0) {
                    numMarbles = numMarbles - requests;
                    humanVSComputer = 1;
                    userInputRequest = requests;
                } else {
                    humanVSComputer = 0;
                }
            }
        }
        else if (humanVSComputer == 1){
            if(easyHard == 0){ //EASY Mode against the Computer
                Random take = new Random();
                if(numMarbles == 1){
                    Take = 1;
                }
                else {
                    Take = take.nextInt(numMarbles / 2) + 1;
                }
                System.out.println("Computer took: "+ Take);
                numMarbles = numMarbles - Take;
                humanVSComputer = 0;
            }
            else if(easyHard == 1){ //HARD Mode against the Computer
                double changeBase;
                double numberTakes;
                int idealTaking;
                int idealNumber;
                int power;
                changeBase = Math.log(numMarbles)/Math.log(2);
                numberTakes = (int)changeBase;
                power = (int) Math.pow(2, numberTakes);
                idealTaking = (numMarbles - power) + 1;
                if(idealTaking <= numMarbles/2){
                    if(numMarbles == 1){
                        idealNumber = 1;
                    }
                    else {
                        idealNumber = idealTaking;
                    }
                    System.out.println("Computer took: "+ idealNumber);
                    numMarbles = numMarbles - idealNumber;
                }
                else{
                    Random taking = new Random();
                    if(numMarbles == 1){
                        Take = 1;
                    }
                    else {
                        Take = taking.nextInt(numMarbles / 2) + 1;
                    }
                    System.out.println("Computer took: "+ Take);
                    numMarbles = numMarbles - Take;
                }
                humanVSComputer = 0;
            }
        }
    }

    public int printMarblesLeft(){
        System.out.println("Marbles left: "+ numMarbles);
        return numMarbles;
    }

    public void winLose(){
        if(numMarbles == 0 && humanVSComputer == 0){
            System.out.println("YOU WON!");
        }
        else if(numMarbles == 0 && humanVSComputer == 1){
            System.out.println("You took the last marble. YOU LOST!");
        }
    }
}
