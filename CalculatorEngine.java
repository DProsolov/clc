import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorEngine implements ActionListener {
    Calculator parent;
    char selectedAction = ' ';
    double currentResult = 0;
    CalculatorEngine(Calculator parent){
        this.parent = parent;
    }

    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();
        String dFT = parent.displayField.getText();
        double dispVl = 0;
        if (!"".equals((dFT))){
            dispVl = Double.parseDouble(dFT);
        }
        Object src = e.getSource();
        if(src == parent.buttonPlus){
            selectedAction = '+';
            currentResult = dispVl;
            parent.displayField.setText("");
            System.out.println("Текущее действие+: " + selectedAction + " " + currentResult);
        } else if(src == parent.buttonMinus){
            selectedAction = '-';
            currentResult = dispVl;
            parent.displayField.setText("");
            System.out.println("Текущее действие-: " + selectedAction + " " + currentResult);
        } else if(src == parent.buttonStr) {
            selectedAction = '*';
            currentResult = dispVl;
            parent.displayField.setText("");
            System.out.println("Текущее действие*: " + selectedAction + " " + currentResult);
        } else if(src == parent.buttonDiv){
                selectedAction = '/';
                currentResult = dispVl;
                parent.displayField.setText("");
            System.out.println("Текущее действие/: " + selectedAction + " " + currentResult);
        } else if(src == parent.buttonEqual){
            if(selectedAction == '+'){
                currentResult += dispVl;
                parent.displayField.setText("" + selectedAction + currentResult);
                System.out.println("Текущее действие=+: " + selectedAction + " " + currentResult);
            } else if (selectedAction == '-'){
                currentResult -= dispVl;
                parent.displayField.setText("" + currentResult);
                System.out.println("Текущее действие=-: " + selectedAction + " " + currentResult);
            } else if (selectedAction == '*'){
                currentResult *= dispVl;
                parent.displayField.setText("" + currentResult);
                System.out.println("Текущее действие=*: " + selectedAction + " " + currentResult);
            } else if (selectedAction == '/'){
                currentResult /= dispVl;
                parent.displayField.setText("" + currentResult);
                System.out.println("Текущее действие=/: " + selectedAction + " " + currentResult);
            }
        } else  {
            String clickedButtonLabel = clickedButton.getText();
            parent.displayField.setText(dFT + clickedButtonLabel);
            System.out.println("Текущее действие кн: " + dFT + " " + clickedButtonLabel);
        }
    }
}
