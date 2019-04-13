package MonomPolinom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class OperatiiPolinom {
	
	public static Polinom aduna(Polinom one, Polinom two) {
		ArrayList<Monom> monoameAdunate = new ArrayList<Monom>();

		monoameAdunate.addAll(one.getPolinom());
		monoameAdunate.addAll(two.getPolinom());

		ArrayList<Monom> change = new ArrayList<Monom>();
		change.addAll(monoameAdunate);

		for (int i = 0; i < monoameAdunate.size(); i++) {
			for (int j = i + 1; j < monoameAdunate.size(); j++) {
				if (monoameAdunate.get(i).getExponent().equals(monoameAdunate.get(j).getExponent())) {
					Monom primu = monoameAdunate.get(i);
					Monom aldoilea = monoameAdunate.get(j);

					Monom temp = primu.aduna(aldoilea);
					change.remove(primu);
					change.remove(aldoilea);

					change.add(temp);
				}
			}
		}

		Polinom rezultat = new Polinom();
		Collections.sort(change);
		rezultat.setPolinom(change);

		return rezultat;

	}

	public static Polinom scade(Polinom one, Polinom two) {
		ArrayList<Monom> monoameScazute = new ArrayList<Monom>();

		monoameScazute.addAll(one.getPolinom());
		monoameScazute.addAll(two.getPolinom());

		ArrayList<Monom> change = new ArrayList<Monom>();
		change.addAll(monoameScazute);

		for (int i = 0; i < monoameScazute.size(); i++) {
			for (int j = i + 1; j < monoameScazute.size(); j++) {
				if (monoameScazute.get(i).getExponent().equals(monoameScazute.get(j).getExponent())) {
					Monom primu = monoameScazute.get(i);
					Monom aldoilea = monoameScazute.get(j);

					Monom temp = primu.scade(aldoilea);
					change.remove(primu);
					change.remove(aldoilea);

					change.add(temp);
				}
			}
		}

		Polinom rezultat = new Polinom();
		Collections.sort(change);
		rezultat.setPolinom(change);

		return rezultat;
	}

	public static Polinom inmultire(Polinom one, Polinom other) {
		Iterator<Monom> polinom1Iterator = one.getPolinom().iterator();
		ArrayList<Monom> change = new ArrayList<Monom>();
		ArrayList<Monom> dublura = new ArrayList<Monom>();
		while (polinom1Iterator.hasNext()) {
			Iterator<Monom> polinom2Iterator = other.getPolinom().iterator();
			Monom tempPol1 = polinom1Iterator.next();
			while (polinom2Iterator.hasNext()) {
				Monom tempPol2 = polinom2Iterator.next();
				Monom rezultatMonom = tempPol2.inmultire(tempPol1);
				change.add(rezultatMonom);
			}
		}
		ArrayList<Monom> monoameAdunate = OperatiiPolinom.helpAdunare(change);
		Polinom rezultat = new Polinom();
		Collections.sort(monoameAdunate);
		rezultat.setPolinom(monoameAdunate);
		return rezultat;

	}
	
	public static Polinom derivare(Polinom one) {
		ArrayList<Monom> derivat = new ArrayList<Monom>();
		Iterator<Monom> it = one.getPolinom().iterator();
		while(it.hasNext()) {
			Monom temp = it.next();
			Monom deriv = temp.derivare();
			derivat.add(deriv);
		}
		
		Polinom rezultat = new Polinom();
		rezultat.setPolinom(derivat);
		return rezultat;
	}
	
	public static Polinom integrare(Polinom one) {
		ArrayList<Monom> integrat = new ArrayList<Monom>();
		Iterator<Monom> it = one.getPolinom().iterator();
		while(it.hasNext()) {
			Monom temp = it.next();
			Monom integr = temp.integrare();
			integrat.add(integr);
		}
		
		Polinom rezultat = new Polinom();
		rezultat.setPolinom(integrat);
		return rezultat;
	}
	
	public static ArrayList<Polinom> impartire(Polinom p1, Polinom p2) {
		ArrayList<Polinom> catSiRest = new ArrayList<Polinom>();
		float gradPol1 = p1.getDegree();
		float gradPol2 = p2.getDegree();
		Polinom cat = new Polinom();
		Polinom rest = new Polinom();
		while(gradPol1 >= gradPol2) {
			float coef = p1.getPolinom().get(0).getCoeficient() / p2.getPolinom().get(0).getCoeficient();
			float expo = p1.getPolinom().get(0).getExponent() - p2.getPolinom().get(0).getExponent();
			Monom mono = new Monom(coef, expo);
			cat.getPolinom().add(mono);
			Polinom addMono = new Polinom();
			addMono.getPolinom().add(mono);
			Polinom seScade = new Polinom();
			seScade.setPolinom(OperatiiPolinom.inmultire(addMono, p2).getPolinom());
			p1.setPolinom(OperatiiPolinom.scade(p1, seScade).getPolinom());
			gradPol1--;
			p1.getPolinom().remove(0);
		}
		
		rest.getPolinom().addAll(p1.getPolinom());
		catSiRest.add(cat);
		catSiRest.add(rest);
		return catSiRest;
		
	}

	public static ArrayList<Monom> helpAdunare(ArrayList<Monom> tip) {
		ArrayList<Monom> temp = new ArrayList<Monom>();
		temp.addAll(tip);
		for (int i = 0; i < tip.size(); i++) {
			for (int j = i + 1; j < tip.size(); j++) {
				if (tip.get(i).getExponent().equals(tip.get(j).getExponent())) {
					Monom primu = tip.get(i);
					Monom aldoilea = tip.get(j);

					Monom temporar = primu.aduna(aldoilea);
					temp.remove(primu);
					temp.remove(aldoilea);

					temp.add(temporar);
				}
			}
		}

		return temp;
	}

}
