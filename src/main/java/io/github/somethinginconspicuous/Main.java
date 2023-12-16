package io.github.somethinginconspicuous;

import java.util.Scanner;

import io.github.somethinginconspicuous.game.PlayerCharacter;
import io.github.somethinginconspicuous.game.TimeLimit;

public class Main {
    private static TimeLimit timeLimit = new TimeLimit();
    private static PlayerCharacter pc;
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

    }

    public static void enterToContinue(){
        in();
    }

    public static String in(){
        return input.nextLine();
    }

    public static void out(Object x){
        System.out.println(x);
    }

    public static void beginning(){
        out("You wake up. It is dark.");
        enterToContinue();
    }

    public static void nameSelf(){
        out("You pick up a medical report laying on the table. You read your name out loud: ");
        pc = new PlayerCharacter(input.nextLine());
    }

    public static PlayerCharacter pc(){
        return pc;
    }

    public static TimeLimit timeLimit(){
        return timeLimit;
    }
}