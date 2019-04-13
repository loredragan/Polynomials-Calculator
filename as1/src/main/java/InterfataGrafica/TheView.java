
package InterfataGrafica;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

import Main.*;
import MonomPolinom.*;

public class TheView extends JFrame{
	public JLabel input1 = new JLabel("Polinom 1");
	public JLabel input2 = new JLabel("Polinom 2");
	public JLabel output = new JLabel("Polinom rezultat");
	public  JTextField polinom1txt= new JTextField(30);
	public JTextField polinom2txt = new JTextField(30);
	public JLabel polinomOutTxt = new JLabel("");
	public JButton butonAdunare = new JButton("Adunare");
	public JButton butonScadere = new JButton("Scadere");
	public JButton butonInmultire = new JButton("Inmultire");
	public JButton butonImpartire = new JButton("Impartire");
	public JButton butonDerivare = new JButton("Derivare");
	public JButton butonIntegrare = new JButton("Integrare");
	public JLabel operatieEfectuata = new JLabel("");
	public CalculatorModel model;
	public JButton resetIn1 = new JButton("Reset input1");
	public JButton resetIn2 = new JButton("Reset input2");
	public JLabel cat = new JLabel("");
	public JLabel rest = new JLabel("");
	public JLabel catLabel = new JLabel("");
	public JLabel restLabel = new JLabel("");
	
	public TheView () {
		
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
		
		JPanel panel1 = new JPanel();
		panel1.add(input1);
		panel1.add(polinom1txt);
		panel1.add(resetIn1);
		mainPanel.add(panel1);
		
		JPanel panel2 = new JPanel();
		panel2.add(input2);
		panel2.add(polinom2txt);
		panel2.add(resetIn2);
		mainPanel.add(panel2);
		
		JPanel panel3 = new JPanel();
		panel3.add(output);
		panel3.add(polinomOutTxt);
		
		JPanel panel4 = new JPanel();
		panel4.add(catLabel);
		panel4.add(cat);
		
		JPanel panel5 = new JPanel();
		panel5.add(restLabel);
		panel5.add(rest);
		
		mainPanel.add(panel3);
		mainPanel.add(panel4);
		mainPanel.add(panel5);
		mainPanel.add(operatieEfectuata);
		
		JPanel panouButoane = new JPanel();
		GridLayout forButtons = new GridLayout(0,2);
		panouButoane.setLayout(forButtons);
		panouButoane.add(butonAdunare);
		panouButoane.add(butonScadere);
		panouButoane.add(butonInmultire);
		panouButoane.add(butonImpartire);
		panouButoane.add(butonDerivare);
		panouButoane.add(butonIntegrare);
		mainPanel.add(panouButoane);
		
		
		
		
		this.setContentPane(mainPanel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
		this.setSize(600, 400);
		this.setTitle("Calculator de Polinoame");
		this.setVisible(true);
		
		
	}
	
	
	
	public String getPolinomOneFromGui() {
		return polinom1txt.getText();
	}
	
	public String getPolinomTwoFromGui() {
		return polinom2txt.getText();
	}
	
	public void showError(String errorMessage) {
		JOptionPane.showMessageDialog(this, errorMessage);
	}
	
	public void addAdunareListener(ActionListener add) {
		butonAdunare.addActionListener(add);
	}
	
	public void addScadereListener(ActionListener scad) {
		butonScadere.addActionListener(scad);
	}
	
	public void addInmultireListener(ActionListener scad) {
		butonInmultire.addActionListener(scad);
	}
	
	public void addIntegrareListener(ActionListener integr) {
		butonIntegrare.addActionListener(integr);
	}
	
	public void addDerivareListener(ActionListener deriv) {
		butonDerivare.addActionListener(deriv);
	}
	
	public void addImpartireListener(ActionListener impartire) {
		butonImpartire.addActionListener(impartire);
	}
	
	public void setRezultat(Polinom rezultat) {
		polinomOutTxt.setText(rezultat.toString());
	}
	
	
	
	public void addResetPolinom1(ActionListener reset) {
		this.resetIn1.addActionListener(reset);
	}
	
	public void addResetPolinom2(ActionListener reset) {
		this.resetIn2.addActionListener(reset);
	}
	
	public void setTxt1() {
		this.polinom1txt.setText("");
	}
	
	public void setTxt2() {
		this.polinom2txt.setText("");
	}
	

	
	

}
