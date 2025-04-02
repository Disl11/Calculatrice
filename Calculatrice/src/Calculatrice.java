import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculatrice  implements ActionListener {


    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] operatorButtons = new JButton[8];
    JButton addButton,subButton,mulButton,divButton;
    JButton decButton, equButton, delButton, clrButton;
    JPanel panel;

    Font myFont = new Font("Arial",Font.BOLD,30);

    double num1=0 , num2 = 0, result=0;
    char operator;

    public Calculatrice(){

      frame = new JFrame("Calculatrice");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(420,550);
      frame.setLayout(null);

      textField = new JTextField();
      textField.setBounds(50,25,300,50);
      textField.setFont(myFont);
      textField.setEditable(false);

      addButton = new JButton("+");
      subButton = new JButton("-");
      mulButton = new JButton("*");
      divButton = new JButton("/");
      decButton = new JButton(".");
      equButton = new JButton("=");
      delButton = new JButton("Delete");
      clrButton = new JButton("Clear");

      operatorButtons[0] = addButton;
      operatorButtons[1] = subButton;
      operatorButtons[2] = mulButton;
      operatorButtons[3] = divButton;
      operatorButtons[4] = decButton;
      operatorButtons[5] = equButton;
      operatorButtons[6] = delButton;
      operatorButtons[7] = clrButton;

      for(int i = 0; i < 8 ; i++){
          operatorButtons[i].addActionListener(this);
          operatorButtons[i].setFont(myFont);
          operatorButtons[i].setFocusable(false);
      }

      for(int i = 0; i < 10 ; i++){
          numberButtons[i] = new JButton(String.valueOf(i));
          numberButtons[i].addActionListener(this);
          numberButtons[i].setFont(myFont);
          numberButtons[i].setFocusable(false);
      }

      delButton.setBounds(50,430,145,50);
      clrButton.setBounds(205,430,145,50);

      panel = new JPanel();
      panel.setBounds(50,100,300,300); // placement panel for number
      panel.setLayout(new GridLayout(4,4,10,10)); // creat grid

        // placcement buttons on panel
      panel.add(numberButtons[1]);
      panel.add(numberButtons[2]);
      panel.add(numberButtons[3]);
      panel.add(addButton);
      panel.add(numberButtons[4]);
      panel.add(numberButtons[5]);
      panel.add(numberButtons[6]);
      panel.add(subButton);
      panel.add(numberButtons[7]);
      panel.add(numberButtons[8]);
      panel.add(numberButtons[9]);
      panel.add(mulButton);
      panel.add(numberButtons[0]);
      panel.add(equButton);
      panel.add(divButton);
      panel.add(decButton);


      frame.add(panel);
      frame.add(delButton);
      frame.add(clrButton);
      frame.add(textField);
      frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i))); // call textfield for set text and parametre get textfield for concatene other texte in string with méthode valueof
            }
        }

        if (e.getSource() == decButton) {
            textField.setText(textField.getText().concat("."));
        }

        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if(e.getSource() == mulButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if(e.getSource() == divButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }

        if(e.getSource() == equButton){
            num2 = Double.parseDouble(textField.getText());

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;

                case '-':
                    result = num1 - num2;
                    break;

                case '*':
                    result = num1 * num2;
                    break;

                case '/':
                    result = num1 / num2;
                    break;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
        }

        if(e.getSource() == clrButton){
            textField.setText("");
        }

        if(e.getSource() ==  delButton){
            String string = textField.getText();
            textField.setText("");
            for(int i = 0 ; i < string.length()-1; i++){
                textField.setText(textField.getText() + string.charAt(i));
            }
        }
    }
}
