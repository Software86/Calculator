package calculator;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Niclas Johansson "Software86"
 */
public class SetupGUI implements ActionListener{
    
    JPanel panel;
    JTextField textfield;
    JFrame frame;
    Calculator calculator;
    Font font;
    
    public SetupGUI(Calculator calculator) {
        this.calculator = calculator;
        addComponents();
        setupFrame();
    }
    
    /**
     *  Setup panel and the layout.
     *  Because of some components being larger then other, use GridBagLayout
     *  with GridBagConstraints.
     */
    public void addComponents(){
        
        panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        // Setup textfield
        textfield = new JTextField();
        textfield.setEditable(false);
        textfield.setText("0");
        textfield.setHorizontalAlignment(JTextField.RIGHT);
        
        // Setup the font to be used for the buttons
        // also set the size of the digits in the textfield
        Font font = new Font("Verdana", Font.PLAIN, 20);
        setTextfieldSize(36);
        
        // Instatiate components, save them in a arraylist for easy handling later
        ArrayList<JButton> list = new ArrayList<>();
        list.add(new JButton("7"));
        list.add(new JButton("8"));
        list.add(new JButton("9"));
        list.add(new JButton("/"));
        list.add(new JButton("4"));
        list.add(new JButton("5"));
        list.add(new JButton("6"));
        list.add(new JButton("*"));
        list.add(new JButton("1"));
        list.add(new JButton("2"));
        list.add(new JButton("3"));
        list.add(new JButton("-"));
        list.add(new JButton("0"));
        list.add(new JButton(","));
        list.add(new JButton("="));
        list.add(new JButton("+"));
        list.add(new JButton("Reset"));
        
        // Add action Listeners to every component
        for (int i = 0; i < list.size(); i++) {
            list.get(i).addActionListener(this);
        }
        // Set the font for the buttons
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setFont(font);
        }
        
        // Place out components in the panel using the gridbagconstraint
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.ipady = 42;
        c.gridwidth = 4;
        textfield.setBackground(Color.WHITE);
        panel.add(textfield, c);
        c.ipady = 20;
        c.ipadx = 20;
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 1;
        int numberInList = 0;
        panel.add(list.get(numberInList++), c);
        c.gridx = 1;
        c.gridy = 1;
        panel.add(list.get(numberInList++), c);
        c.gridx = 2;
        c.gridy = 1;
        panel.add(list.get(numberInList++), c);
        c.gridx = 3;
        c.gridy = 1;
        panel.add(list.get(numberInList++), c);
        c.gridx = 0;
        c.gridy = 2;
        panel.add(list.get(numberInList++), c);
        c.gridx = 1;
        c.gridy = 2;
        panel.add(list.get(numberInList++), c);
        c.gridx = 2;
        c.gridy = 2;
        panel.add(list.get(numberInList++), c);
        c.gridx = 3;
        c.gridy = 2;
        panel.add(list.get(numberInList++), c);
        c.gridx = 0;
        c.gridy = 3;
        panel.add(list.get(numberInList++), c);
        c.gridx = 1;
        c.gridy = 3;
        panel.add(list.get(numberInList++), c);
        c.gridx = 2;
        c.gridy = 3;
        panel.add(list.get(numberInList++), c);
        c.gridx = 3;
        c.gridy = 3;
        panel.add(list.get(numberInList++), c);
        c.gridx = 0;
        c.gridy = 4;
        panel.add(list.get(numberInList++), c);
        c.gridx = 1;
        c.gridy = 4;
        panel.add(list.get(numberInList++), c);
        c.gridx = 2;
        c.gridy = 4;
        panel.add(list.get(numberInList++), c);
        c.gridx = 3;
        c.gridy = 4;
        panel.add(list.get(numberInList++), c);
        c.gridx = 0;
        c.gridy = 5;
        c.gridwidth = 4;
        c.ipady = 20;
        panel.add(list.get(numberInList++), c);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Everytime an action is performed
        // call checkinput() with the default actioncommand as in-parameter
        calculator.checkInput(e.getActionCommand());
    }
    
    /**
     *  Setup the frame
     */
    public void setupFrame() {
        frame = new JFrame("Calculator");
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.pack();
    }
    
    /**
     *  Change the size of the digits in the text field.
     * @param size
     */
    public void setTextfieldSize(int size){
        font = new Font("Verdana", Font.PLAIN, size);
        textfield.setFont(font);
    }
    
    //Getters
    
    public JPanel getPanel(){
        return panel;
    }
    
    public JTextField getTextfield(){
        return textfield;
    }
    
    public JFrame getFrame(){
        return frame;
    }
}
