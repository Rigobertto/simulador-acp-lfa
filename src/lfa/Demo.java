package lfa;

import java.util.Scanner;

public class Demo {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);

		Automato automato;
		Modelo modelo = new Modelo();
		Call call = new Call();
		System.out.println("The automaton language is: 0(n)1(n+1)");

		automato = modelo.PushdownAutomaton();
		
		call.call(automato);
	}
}
