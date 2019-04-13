package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import MonomPolinom.*;
import InterfataGrafica.*;

public class Controller {
	private CalculatorModel model;
	private TheView gui;

	public Controller(CalculatorModel model, TheView view) {
		this.model = model;
		this.gui = view;

		gui.addAdunareListener(new AdunareListener());
		gui.addScadereListener(new ScadereListener());
		gui.addInmultireListener(new InmultireListener());
		gui.addDerivareListener(new DerivareListener());
		gui.addIntegrareListener(new IntegrareListener());
		gui.addResetPolinom1(new ResetListener1());
		gui.addResetPolinom2(new ResetListener2());
		gui.addImpartireListener(new ImpartireListener());
	}

	class AdunareListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			gui.operatieEfectuata.setText("S-a efectuat operatia de adunare");
			String input1 = "";
			String input2 = "";

			try {
				input1 = gui.getPolinomOneFromGui();
				input2 = gui.getPolinomTwoFromGui();
				Polinom p1 = new Polinom(input1);
				Polinom p2 = new Polinom(input2);
				model.adunareDouaPolinoame(p1, p2);
				gui.setRezultat(model.getRezultat());

			}  catch (Exception Ex) {
				gui.showError("Wrong Arguments");
			}
		}
	}

	class ScadereListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			gui.operatieEfectuata.setText("S-a efectuat operatia de scadere");
			String input1 = "";
			String input2 = "";

			try {
				input1 = gui.getPolinomOneFromGui();
				input2 = gui.getPolinomTwoFromGui();
				Polinom p1 = new Polinom(input1);
				Polinom p2 = new Polinom(input2);
				model.scadeDouaPlinoame(p1, p2);
				gui.setRezultat(model.getRezultat());

			}  catch (Exception Ex) {
				gui.showError("Wrong Arguments");
			}
		}
	}

	class InmultireListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			gui.operatieEfectuata.setText("S-a efectuat operatia de inmultire");
			String input1 = "";
			String input2 = "";

			try {
				input1 = gui.getPolinomOneFromGui();
				input2 = gui.getPolinomTwoFromGui();
				Polinom p1 = new Polinom(input1);
				Polinom p2 = new Polinom(input2);
				model.inmultireDouaPolinoame(p1, p2);
				gui.setRezultat(model.getRezultat());

			}  catch (Exception Ex) {
				gui.showError("Wrong Arguments");
			}
		}
	}

	class DerivareListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			gui.operatieEfectuata.setText("S-a efectuat operatia de derivare");
			String input1 = "";

			try {
				input1 = gui.getPolinomOneFromGui();

				Polinom p1 = new Polinom(input1);

				model.derivarePolinom(p1);
				gui.setRezultat(model.getRezultat());

			}   catch (Exception Ex) {
				gui.showError("Wrong Arguments");
			}
		}
	}
	
	class IntegrareListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			gui.operatieEfectuata.setText("S-a efectuat operatia de integrare");
			String input1 = "";

			try {
				input1 = gui.getPolinomOneFromGui();

				Polinom p1 = new Polinom(input1);

				model.integrarePolinom(p1);
				gui.setRezultat(model.getRezultat());

			} catch (Exception Ex) {
				gui.showError("Wrong Arguments");
			}
		}
	}
	
	class ImpartireListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			gui.operatieEfectuata.setText("S-a efectuat operatia de impartire");
			String input1 = "";
			String input2 = "";
			String resultCat = "";
			String resultRest = "";
			try {
				input1 = gui.getPolinomOneFromGui();
				Polinom p1 = new Polinom(input1);
				input2 = gui.getPolinomTwoFromGui();
				Polinom p2 = new Polinom(input2);
				model.impartireDouaPolinoame(p1, p2);
				resultCat = model.getRezultatImpartire().get(0) + "";
				resultRest = model.getRezultatImpartire().get(1) + "";
				gui.catLabel.setText("Catul : ");
				gui.restLabel.setText("Restul: ");
				gui.cat.setText(resultCat);
				gui.rest.setText(resultRest);
			}
			catch(Exception ex) {
				gui.showError("Wrong Arguments");
			}
				
				
				
				
				
			
		}
	}
	
	class ResetListener1 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			gui.setTxt1();
		}
	}
	
	class ResetListener2 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			gui.setTxt2();
		}
	}
	

}
