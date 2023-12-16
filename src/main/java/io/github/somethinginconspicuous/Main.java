package io.github.somethinginconspicuous;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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

import io.github.somethinginconspicuous.game.Item;
import io.github.somethinginconspicuous.game.Location;
import io.github.somethinginconspicuous.game.PlayerCharacter;
import io.github.somethinginconspicuous.game.TimeLimit;

public class Main extends JFrame {
    private static final String CTC = "[Click to Continue]";
    private static final String GIVE_CHOICES = "__GIVE_CHOICES__";

    //private static final Font FONT = new Font("Orbitron", Font.PLAIN, 24);
    private static Font FONT;

    static {
        try {
            FONT = Font.createFont(Font.TRUETYPE_FONT, new File("src/main/resources/Press_Start_2P/PressStart2P-Regular.ttf")).deriveFont(24.0f);
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(FONT);
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
    private static PlayerCharacter pc = new PlayerCharacter("Tracy Dickenson");
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
        MouseListener clickToNextML = new MouseListener() {

            @Override
            public void mousePressed(MouseEvent e) {
                e.consume();
                //System.out.println("Clicked");
                SwingUtilities.invokeLater(() -> safeNextOut());
            }

            @Override
            public void mouseClicked(MouseEvent e) {} // Nothing
            @Override
            public void mouseReleased(MouseEvent e) {} // Nothing
            @Override
            public void mouseEntered(MouseEvent e) {} // Nothing
            @Override
            public void mouseExited(MouseEvent e) {} // Nothing
            
        };
        pane.addMouseListener(clickToNextML);
        outLabel.addMouseListener(clickToNextML);
        addMouseListener(clickToNextML);
        addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {} // Nothing

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println(e.getKeyCode());
                SwingUtilities.invokeLater(() -> safeNextOut());
            }

            @Override
            public void keyReleased(KeyEvent e) {} // Nothing
            
        });
        
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

    public void safeNextOut(){
        System.out.println("Attempting output");
        if(output.peek() != null)
            nextOut();
    }

    public void nextOut(){
        StringBuilder sb = new StringBuilder("<html><div style=\"font-family:'" + FONT.getName() +"'\">");

        for(JButton bttn : choicesButtons){
            bttn.setVisible(false);
        }

        String line;
        while((line = output.poll()) != null){
            if(line.equals(GIVE_CHOICES)){
                for(JButton bttn : choicesButtons){
                    bttn.setVisible(true);
                }
                break;
            }

            sb.append(
                line
                .replace("\n", "<br>")
                .replaceAll("(?:\\\\\\\\)(?<!\\\\)<", "&lt;")
                .replaceAll("(?:\\\\\\\\)(?<!\\\\)>", "&gt;")
            ).append("<br>");

            if(line.equals(CTC))
                break;
        }


        //String out = sb.toString();
        sb.append("</html>");
        System.out.println("Outputting: " + sb);
        outLabel.setText(sb.toString());
        //outLabel.setText("<html>" + out.replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");
        validate();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::runGUI);

        SwingUtilities.invokeLater(() -> gui.runGame());
        
    }

    private void runGame(){
        beginning();

        nextOut();
    }

    private static void runGUI() {
        gui = new Main();
    }

    public void onChoice(ActionEvent e){
        String actionCommand = e.getActionCommand();
        System.out.println(actionCommand);
        System.out.println(pc.location());

        switch (actionCommand) {
            case "Choice_0":
                choice0(e);
                break;

            case "Choice_1":
                choice1(e);
                break;

            case "Choice_2":
                choice2(e);
                break;

            case "Choice_3":
                choice3(e);
                break;
        
            default:
                break;
        }

        if(timeLimit.hasTimeLeft())
            safeNextOut();
        else 
            end();
    }



    private void end() {
        output.clear();
        out("The oxygen has run out. Unfortunate.");
        SwingUtilities.invokeLater(() -> {while(true);});
    }

    private void choice0(ActionEvent e) {
        switch(pc.location()){
            case HOSPITAL:
                // [Go Back to Bed]
                spendHours(1);
                out("You feel you haven't slept enough, so you go back to sleep.");
                enterToContinue();
                out("You wake up about an hour later.");
                enterToContinue();
                beginning();
                break;

            case HOSPITAL_ITEMS:
                // [Sandwich]
                out("It's slightly wet, but you take it with you anyways.");
                break;
            default:
                break;
            
        }
    }

    private void choice1(ActionEvent e){
        switch(pc.location()){
            case HOSPITAL:
                // [Observer Your Suroundings]
                out("You look around");
                enterToContinue();
                out("There is an old sandwich sitting on the table beside you.");
                out("There a dark figure sitting in the corner.");
                out("There is a door on the right wall.");
                out("There seems to be a loose bit in the wall to your left.");
                pc.setLocation(Location.HOSPITAL_ITEMS);
                giveChoices(Location.HOSPITAL_ITEMS);
                break;
        
            default:
                break;
        }
    }

    private void choice2(ActionEvent e) {
        switch(pc.location()){
            case HOSPITAL:
                break;
        
            default:
                break;
        }
    }

    private void choice3(ActionEvent e) {
        switch(pc.location()){
            case HOSPITAL:
                break;
        
            default:
                break;
        }
    }

    private void spendHours(int hours){
        timeLimit.spendHours(hours);
        timeLabel.setText("Time: " + timeLimit);
    }

    public static void enterToContinue(){
        out(CTC);
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

    //public static void nameSelf(){
    //    out("You pick up a medical report laying on the table.");
    //    //pc = new PlayerCharacter(input.nextLine());
    //}

    public static PlayerCharacter pc(){
        return pc;
    }

    public static void showItem(Item item){
        gui.inventoryPanel.add(new JLabel(item.getImageIcon()));
    }

    public static TimeLimit timeLimit(){
        return timeLimit;
    }

    public static void giveChoices(String... choices){
        for(int i = 0; i < gui.choicesButtons.length; i++){
            gui.choicesButtons[i].setText(choices[i]);
        }
        out(GIVE_CHOICES);
    }

    public static void giveChoices(Location location){
        for(int i = 0; i < gui.choicesButtons.length; i++){
            gui.choicesButtons[i].setText(location.getChoice(i));
        }
        out(GIVE_CHOICES);
    }
    
    //#region game methods

    public static void beginning(){
        out("You wake up to a dim light shining on your face.");
        out("For some reason, it smells faintly like soy sauce.");
        enterToContinue();
        out("You rise from your bed.");
        giveChoices(pc.location());
    }

    //#endregion
}