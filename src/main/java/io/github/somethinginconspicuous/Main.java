package io.github.somethinginconspicuous;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
//import java.awt.GridLayout;
import java.util.LinkedList;
import java.util.Queue;
//import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import io.github.somethinginconspicuous.game.PlayerCharacter;
import io.github.somethinginconspicuous.game.TimeLimit;

public class Main extends JFrame {
    //private static final Font FONT = new Font("Orbitron", Font.PLAIN, 24);
    private static Font FONT;

    static {
        try {
            FONT = Font.createFont(Font.TRUETYPE_FONT, new File("src/main/resources/Press_Start_2P/PressStart2P-Regular.ttf")).deriveFont(24.0f);
        } catch (FontFormatException | IOException e) {
            FONT = Font.getFont("Serif");
            e.printStackTrace();
        }
    
    }

    private Queue<String> output = new LinkedList<>();

    // GUI

    public static Main gui;

    private JPanel pane;

    private JPanel statusPanel;

    private JPanel inventoryPanel;
    private JLabel inventoryLabel;

    private JPanel timePanel;
    private JLabel timeLabel;

    private JPanel outPanel;
    private JLabel outLabel;
    
    private static final int NUM_CHOICES = 4;
    private JPanel choicesPanel;
    private JButton[] choicesButtons;

    private static TimeLimit timeLimit = new TimeLimit();
    private static PlayerCharacter pc;
    //private static Scanner input = new Scanner(System.in);

    private Main(){
        super("Game");
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        pane = new JPanel();
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
        
        statusPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        statusPanel.setForeground(Color.BLACK);
        statusPanel.setBackground(Color.BLACK);
        
        inventoryPanel = new JPanel(new FlowLayout());
        inventoryPanel.setForeground(Color.BLACK);
        inventoryPanel.setBackground(Color.BLACK);

        inventoryLabel = new JLabel("Inventory: ");
        inventoryLabel.setForeground(Color.WHITE);
        inventoryLabel.setBackground(Color.BLACK);
        inventoryLabel.setFont(FONT);
        
        inventoryPanel.add(inventoryLabel);
        
        timePanel = new JPanel(new FlowLayout());
        timePanel.setBackground(Color.BLACK);
        timePanel.setForeground(Color.BLACK);
        
        timeLabel = new JLabel("Time: 9:00");
        timeLabel.setForeground(Color.WHITE);
        timeLabel.setBackground(Color.BLACK);
        timeLabel.setFont(FONT);
        
        timePanel.add(timeLabel);
        
        statusPanel.add(timePanel);
        statusPanel.add(inventoryPanel);
        
        pane.add(statusPanel);
        
        outPanel = new JPanel();
        outPanel.setForeground(Color.BLACK);
        outPanel.setBackground(Color.BLACK);
        outLabel = new JLabel("output output output output output output output output");
        outLabel.setForeground(Color.WHITE);
        outLabel.setBackground(Color.BLACK);
        outLabel.setFont(FONT);
        
        outPanel.add(outLabel);
        
        pane.add(outPanel);
        
        choicesPanel = new JPanel(new GridLayout(3, NUM_CHOICES, 10, 0));
        choicesPanel.setBackground(Color.BLACK);
        choicesPanel.setForeground(Color.BLACK);
        
        choicesButtons = new JButton[NUM_CHOICES];
        
        JPanel empty = new JPanel();
        empty.setForeground(Color.BLACK);
        empty.setBackground(Color.BLACK);

        for(int i = 0; i < choicesButtons.length; i++){
            choicesButtons[i] = new JButton("Choice_" + i);
            choicesButtons[i].setFont(FONT);
            //choicesButtons[i].setForeground(Color.WHITE);
            //choicesButtons[i].setBackground(Color.BLACK);
            choicesButtons[i].setActionCommand("Choice_" + i);
            choicesButtons[i].addActionListener(this::onChoice);
        }
        
        // Fill first row with emptiness
        for(int i = 0; i < choicesButtons.length; i++){
            choicesPanel.add(empty);
        }
        
        for(int i = 0; i < choicesButtons.length; i++){
            choicesPanel.add(choicesButtons[i]);
        }
        
        for(int i = 0; i < choicesButtons.length; i++){
            choicesPanel.add(empty);
        }
        
        pane.add(choicesPanel);
        
        setContentPane(pane);
        setSize(1920, 1080);
        //pack();
        setVisible(true);

        setForeground(Color.BLACK);
        setBackground(Color.BLACK);
        pane.setBackground(Color.BLACK);
        pane.setForeground(Color.BLACK);

        outPanel.setPreferredSize(new Dimension(getWidth(), getHeight() * 3 / 5));
        statusPanel.setPreferredSize(new Dimension(getWidth(), getHeight() / 5));
    }

    @Override
    public void validate(){
        // TODO flush output
        super.validate();
    }

    public void nextOut(){
        outLabel.setText(output.poll());
        validate();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::runGUI);
    }

    private static void runGUI() {
        gui = new Main();
    }

    public void onChoice(ActionEvent e){

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