package calculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Niclas Johansson "Software86"
 *
 */
public class Calculator {

    JFrame frame;
    JPanel panel;
    JTextField textfield;
    SetupGUI sgui;

    boolean firstEntry = true;
    boolean commaExist = false;
    boolean noPreviousInput = true;
    String firstNumber = null;
    String secondNumber = null;
    String lastOperation;
    

    public static void main(String[] args) {
        // Instantiate a new calculator to get out of the static main method
        Calculator calculator = new Calculator();
    }

    public Calculator() {
        sgui = new SetupGUI(this);
        panel = sgui.getPanel();
        textfield = sgui.getTextfield();
    }

    /**
     * This method gets called from the GUI every time an action is performed.
     * It will get the default action command for the button as in-parameter.
     * @param input The action command that has been performed
     */
    public void checkInput(String input) {
        switch (input) {
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
                // If first entry, take away the original zero
                if (firstEntry) {
                    textfield.setText("");
                    firstEntry = false;
                }
                addToField(input);
                break;
            case ",":
                // Make sure we can only have one comma
                if (!commaExist) {
                    addToField(input);
                    commaExist = true;
                }
                
                break;
            case "0":
                // If first digit, take away the original zero
                if (firstEntry) {
                    textfield.setText("");
                    firstEntry = false;
                }
                addToField(input);
                break;
            case "/":
            case "*":
            case "-":
            case "+":
                if (noPreviousInput) {
                    firstNumber = textfield.getText();
                    noPreviousInput = false;
                    lastOperation = input;
                    reset(false);
                } else {
                    secondNumber = textfield.getText();
                    String result = operation(lastOperation, firstNumber, secondNumber);
                    textfield.setText(result);
                    firstNumber = result;
                    lastOperation = input;
                    reset(false);
                }
                break;
            case "=":
                secondNumber = textfield.getText();
                String result = operation(lastOperation, firstNumber, secondNumber);
                textfield.setText(result);
                firstNumber = result;
                noPreviousInput = true;
                adjustDigitsSize();
                reset(false);
                break;
            case "Reset":
                reset(true);
                break;
        }
    }


    /**
     * Add specified input to the text field
     * @param input What to add
     */
    public void addToField(String input) {
        textfield.setText(textfield.getText() + input);
        adjustDigitsSize();
    }
    
    /**
     * Check if the font-size on the digits needs to be adjusted
     * Calls the setTExtfieldSize method in SetupGUI if true
     */
    public void adjustDigitsSize(){
        if(textfield.getText().length() > 10){
            sgui.setTextfieldSize(18);
        }
        if (textfield.getText().length() > 20){
            JOptionPane.showMessageDialog(null, "To many digits");
            sgui.setTextfieldSize(36);
            reset(true);
        }
    }

    /**
     * Perform specified operation
     * @param operation What operation to perform "+", "-", "*" or "/" 
     * @param number1 The first number, must be a String
     * @param number2 The second number, must be a String
     * @return Returns the outcome of the operation as a String
     */
    public String operation(String operation, String number1, String number2) {
        number1 = number1.replace(",", ".");
        number2 = number2.replace(",", ".");
        BigDecimal number1Bg = new BigDecimal(number1);
        BigDecimal number2Bg = new BigDecimal(number2);
        BigDecimal result = null;

        switch (operation) {
            case "+":
                result = number1Bg.add(number2Bg);
                break;
            case "-":
                result = number1Bg.subtract(number2Bg);
                break;
            case "*":
                result = number1Bg.multiply(number2Bg);
                break;
            case "/":
                result = number1Bg.divide(number2Bg, 2, RoundingMode.HALF_DOWN);
                break;
        }

        String resultString = result.toString();
        resultString = resultString.replace(".", ",");
        return resultString;
    }

    /**
     * Reset all variables
     *
     * @param hardReset Make a hard reset?
     *
     */
    public void reset(boolean hardReset) {
        firstEntry = true;
        commaExist = false;
        if (hardReset) {
            textfield.setText("0");
            firstNumber = null;
            secondNumber = null;
            noPreviousInput = true;
            sgui.setTextfieldSize(36);
        }
    }
}
