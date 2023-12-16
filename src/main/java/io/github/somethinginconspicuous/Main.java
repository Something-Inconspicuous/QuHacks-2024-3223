package io.github.somethinginconspicuous;

import java.awt.FlowLayout;
//import java.awt.GridLayout;
import java.util.LinkedList;
import java.util.Queue;
//import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import io.github.somethinginconspicuous.game.PlayerCharacter;
import io.github.somethinginconspicuous.game.TimeLimit;

public class Main extends JFrame {
    private Queue<String> output = new LinkedList<>();

    // GUI
    public static Main gui;

    private JPanel pane;

    private JPanel statusPanel;
    private JPanel inventoryPanel;
    private JPanel timePanel;

    private JLabel outLabel;

    private static TimeLimit timeLimit = new TimeLimit();
    private static PlayerCharacter pc;
    //private static Scanner input = new Scanner(System.in);

    private Main(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        pane = new JPanel();
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

        statusPanel = new JPanel(new FlowLayout());
        inventoryPanel = new JPanel(new FlowLayout());
        timePanel = new JPanel(new FlowLayout());

        statusPanel.add(inventoryPanel);
        statusPanel.add(timePanel);

        setContentPane(pane);
        setSize(300, 300);
        setVisible(true);
    }

    @Override
    public void validate(){
        // TODO flush output
        super.validate();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::runGUI);
    }

    private static void runGUI() {
        gui = new Main();
    }

    public static void enterToContinue(){
        in();
    }

    public static String in(){
        //return input.nextLine();
        return null;
    }

    public static void out(Object x){
        //System.out.println(x);
        String str = String.valueOf(x);

        gui.output.offer(str);
    }

    public static void beginning(){
        out("You wake up. It is dark.");
        enterToContinue();
    }

    public static void nameSelf(){
        out("You pick up a medical report laying on the table. You read your name out loud: ");
        //pc = new PlayerCharacter(input.nextLine());
    }

    public static PlayerCharacter pc(){
        return pc;
    }

    public static TimeLimit timeLimit(){
        return timeLimit;
    }
}