package de.hss.schildkroete1;
import java.awt.Color;

import ch.aplu.turtle.Turtle;

public class AufgabenAB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Turtle horst = new Turtle();
		horst.speed(Double.MAX_VALUE);
		mandalaLaufen(horst,24);
//		aufgabe1d(horst,10);
//		formLaufen(horst,10);
	}
	
	static void mandalaLaufen(Turtle schildkr, int facetten) {
		for(int i=0;i<facetten;i++) {
			if(i%2==0) {
				schildkr.setPenColor(Color.red);
			}
			else {
				schildkr.setPenColor(Color.blue);
			}
			schildkr.right(360/facetten);
			formLaufen(schildkr, 4);
			
		}
	}
	
	static void formLaufen(Turtle schildkr, int ecken) {
		for(int i=0;i<ecken;i++) {
			schildkr.forward(400/ecken);
			schildkr.right(360/ecken);
		}
	}
	
	static void aufgabe1d(Turtle schildkr, int stufen) {
		for(int i=0;i<stufen;i++) {
			schildkr.forward(50);
			schildkr.right(90);
			schildkr.forward(50);
			schildkr.left(90);
		}
	}

}
