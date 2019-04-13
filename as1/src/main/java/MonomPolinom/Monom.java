package MonomPolinom;

import java.util.Comparator;

public class Monom implements Comparable<Monom> {
	private Float coeficient;
	private Float exponent;

	public Monom(Float coef, Float exp) {
		this.coeficient = coef;
		this.exponent = exp;
	}

	public Monom() {
		this.coeficient = 0f;
		this.exponent = 0f;
	}

	public Float getCoeficient() {
		return coeficient;
	}

	public void setCoeficient(Float coeficient) {
		this.coeficient = coeficient;
	}

	public Float getExponent() {
		return exponent;
	}

	public void setExponent(Float exponent) {
		this.exponent = exponent;
	}

	public Monom aduna(Monom other) {
		Monom rezultat = new Monom();
		rezultat.exponent = other.exponent;
		rezultat.coeficient = this.coeficient + other.coeficient;

		return rezultat;
	}

	public Monom scade(Monom one) {
		Monom rezultat = new Monom();
		rezultat.exponent = one.exponent;
		rezultat.coeficient = this.coeficient - one.coeficient;

		return rezultat;
	}

	public Monom inmultire(Monom other) {
		Monom rezultat = new Monom();
		rezultat.exponent = this.exponent + other.exponent;
		rezultat.coeficient = this.coeficient * other.coeficient;
		return rezultat;
	}
	
	public Monom derivare() {
		Monom rezultat = new Monom(1f,1f);
		if(this.exponent == 0) 
			{
				rezultat.coeficient = 0f;
				rezultat.exponent = 0f;
			}
		else {
			rezultat.coeficient = this.exponent * this.coeficient;
			rezultat.exponent = this.exponent -= 1;
		}
		return rezultat;
	}
	
	public Monom integrare() {
		Monom rezultat = new Monom(1f,1f);
		rezultat.exponent = this.exponent + 1f;
		 rezultat.coeficient =(float)(this.coeficient) / rezultat.exponent;
		 
		 return rezultat;
	}
	
	public Monom impartire(Monom other) {
		Monom imp = new Monom(this.coeficient/other.coeficient, this.exponent-other.getExponent());
		return imp;
	}

	@Override
	public String toString() {
		String result = "";
		String coef = "";
		String exp = "";

		if (this.coeficient > 0) {
			result = "+" + this.coeficient;
			if (this.exponent != 0) {
				result += "x^" + this.exponent;
			}

		} else if (this.coeficient < 0) {
			result += this.coeficient;
			if (this.exponent != 0) {
				result += "x^" + this.exponent;
			}
		}
		return result;

	}

	 

	public int compareTo(Monom o) {
		// TODO Auto-generated method stub
		return (int) (o.exponent - this.exponent);
	}

}
