import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class WS1 extends JFrame implements ActionListener{
private JLabel lblDC, lblNC, lblCr;
private JTextField  txtDC, txtNC, txtCr;
private JButton btnSubmit, btnExit;

public WS1() {
	
	//setting layout
	setLayout(new GridLayout(4, 2));
	
	//gui items
	lblDC = new JLabel ("Department Code");
	lblDC.setForeground(Color.BLUE);
	lblNC = new JLabel("Numeric Code");
	lblNC.setForeground(Color.RED);
	lblCr = new JLabel("Credits");
	lblCr.setForeground(Color.GREEN);
	
	
	
	txtDC = new JTextField();
	txtNC = new JTextField();
	txtCr = new JTextField();
	
	btnSubmit = new JButton("Submit");
	btnExit = new JButton("Exit");
	
	add(lblDC);
	add(txtDC);
	add(lblNC);
	add(txtNC);
	add(lblCr);
	add(txtCr);
	add(btnSubmit);
	add(btnExit);
	
	//registering buttons to respond actions
	btnSubmit.addActionListener(this);
	btnExit.addActionListener(this);
	
	//set frame
	setSize(700,700);
	setVisible(true);
	setDefaultCloseOperation(EXIT_ON_CLOSE);	
}


private void reset() {
	txtDC.setText("");
	txtNC.setText("");
	txtCr.setText("");
	
}

public static void main(String[] args) {
	new WS1();
}


@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub


String message = "Department Code: " + txtDC.getText() + "\nNumeric Code: " + txtNC.getText() + "\nCredits: " +txtCr.getText();

if(isValidTxtOne(txtDC.getText()) == false){
JOptionPane.showMessageDialog(this, "Type a Department code less then or equal to 5", "ERROR",JOptionPane.ERROR_MESSAGE );

}
else if(isValidTxtTwo(txtNC.getText()) == false){
JOptionPane.showMessageDialog(this, "Type a Numeric Code between 100 and 600", "ERROR",JOptionPane.ERROR_MESSAGE );

}
else if(isValidTxtThree(txtCr.getText()) == false){
JOptionPane.showMessageDialog(this, "Type a credit between 1 and 9", "ERROR",JOptionPane.ERROR_MESSAGE );

}
else {
JOptionPane.showMessageDialog(this, message, "Course",JOptionPane.INFORMATION_MESSAGE);
reset();



}
}



// all the conditions

private boolean isValidTxtOne(String txtDC){
return txtDC.length() <= 5;
}

private boolean isValidTxtTwo(String txtNC){
return 100 < Integer.parseInt(txtNC) && Integer.parseInt(txtNC) < 600;
}

private boolean isValidTxtThree(String txtCr){
return (1 < Integer.parseInt(txtCr)) && (Integer.parseInt(txtCr) < 9);
}

}


