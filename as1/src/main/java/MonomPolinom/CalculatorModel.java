package MonomPolinom;

import java.util.ArrayList;

public class CalculatorModel {
	
	public Polinom rezultat;
	 public ArrayList<Polinom> rezultatImpartire = new ArrayList<Polinom>();
	
	public void adunareDouaPolinoame(Polinom p1, Polinom p2) {
		this.rezultat = OperatiiPolinom.aduna(p1, p2);
	}
	
	public void scadeDouaPlinoame(Polinom p1, Polinom p2) {
		this.rezultat = OperatiiPolinom.scade(p1, p2);
	}
	
	public void inmultireDouaPolinoame(Polinom p1, Polinom p2) {
		this.rezultat = OperatiiPolinom.inmultire(p1, p2);
		
	}
	
	public void derivarePolinom(Polinom p1) {
		this.rezultat = OperatiiPolinom.derivare(p1);
	}
	
	public void integrarePolinom(Polinom p1) {
		this.rezultat =OperatiiPolinom.integrare(p1);
	}
	
	public void impartireDouaPolinoame(Polinom p1, Polinom p2) {
		this.rezultatImpartire = OperatiiPolinom.impartire(p1, p2);
	}

	public Polinom getRezultat() {
		return rezultat;
	}

	public void setRezultat(Polinom rezultat) {
		this.rezultat = rezultat;
	}

	public ArrayList<Polinom> getRezultatImpartire() {
		return rezultatImpartire;
	}

	public void setRezultatImpartire(ArrayList<Polinom> rezultatImpartire) {
		this.rezultatImpartire = rezultatImpartire;
	}
	
	
	
}
