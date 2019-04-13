package MonomPolinom;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import InterfataGrafica.*;

public class Polinom {

	private ArrayList<Monom> polinom = new ArrayList<Monom>();
	private List<Float> coeficienti = new ArrayList<Float>();
	private List<Float> exponenti = new ArrayList<Float>();

	public Polinom() {
		
	}

	public Polinom(String polinomInput) {
		coeficienti = this.extractCoeficients(polinomInput);
		exponenti = this.extractExponents(polinomInput);
		Iterator<Float> pesteCoeficienti = coeficienti.iterator();

		Iterator<Float> pesteExponenti = exponenti.iterator();
		while (pesteCoeficienti.hasNext() && pesteExponenti.hasNext()) {

			Float coeficientTemp = pesteCoeficienti.next();
			Float exponentTemp = pesteExponenti.next();
			Monom newMonom = new Monom(coeficientTemp, exponentTemp);
			this.polinom.add(newMonom);
		}
	}

	public List<Float> extractCoeficients(String polynomial) {
		List<Float> result = new ArrayList<Float>();

		String[] coefs = polynomial.split("x\\^\\d+\\+?");

		for (String coef : coefs) {
			result.add(Float.parseFloat(coef));
		}

		return result;
	}

	public List<Float> extractExponents(String polynomial) {
		List<Float> result = new ArrayList<Float>();

		String[] terms = polynomial.split("(-|\\+)");

		// we ignore the first term
		for (int i = 1; i < terms.length; i++) {
			String[] parts = terms[i].split("\\^");
			String exp = parts.length > 1 ? parts[1] : "0";
			result.add(Float.parseFloat(exp));
		}

		return result;
	}


	
	public Float getDegree() {
		
		Float gradPolinom;
		gradPolinom = polinom.get(0).getExponent();
		
		return gradPolinom;
	}
	
	public Monom getMonomGradMax() {
		
		return this.polinom.get(0);
	}

	public ArrayList<Monom> getPolinom() {
		return polinom;
	}

	public void setPolinom(ArrayList<Monom> polinom) {
		this.polinom = polinom;
	}
	
	

	public ArrayList<Float> getCoeficienti() {
		return (ArrayList<Float>) coeficienti;
	}

	public void setCoeficienti(List<Float> coeficienti) {
		this.coeficienti = coeficienti;
	}

	public List<Float> getExponenti() {
		return exponenti;
	}

	public void setExponenti(List<Float> exponenti) {
		this.exponenti = exponenti;
	}

	@Override
	public String toString() {
		String result = "";
		Iterator<Monom> it = this.polinom.iterator();
		while (it.hasNext()) {
			Monom temp = it.next();
			result += temp;
		}

		return result;
	}
	
	
	

}
