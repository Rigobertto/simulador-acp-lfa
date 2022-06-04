package lfa;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Modelo implements InterModelo {

	public static Scanner in = new Scanner(System.in);
	
	public Modelo(){
		
	}
	
	// chamar ACP
	public Automato PushdownAutomaton() {

		List<State> state = new ArrayList<State>();
		State state0 = new State("q0", false); State state1 = new State("q1", false); State state2 = new State("q2", true);

		// alfabeto Automato 0(n)1(n+1)
		Set<Character> aAutomato = new HashSet<Character>();
		aAutomato.add('0');
		aAutomato.add('1');

		// alfabeto Pilha
		Set<Character> aPile = new HashSet<Character>();
		aPile.add('0');

		Automato pushdownAutomaton = new Automato("0(n)1(n+1)", state0, aAutomato, aPile, 'Z');

		List<TransitionFunction> functionsA = new ArrayList<TransitionFunction>();
		functionsA.add(new TransitionFunction('0', 'Z', state0, '0'));
		functionsA.add(new TransitionFunction('0', '0', state0, '0'));
		functionsA.add(new TransitionFunction('1', '0', state1, '='));
		state0.setFunctions(functionsA);

		List<TransitionFunction> functionsB = new ArrayList<TransitionFunction>();
		functionsB.add(new TransitionFunction('1', '0', state1, '-'));
		functionsB.add(new TransitionFunction('-', 'Z', state2, '-'));
		state1.setFunctions(functionsB);

		state.add(state0);
		state.add(state1);
		state.add(state2);

		return pushdownAutomaton;
	}

	public State choiceStates(List<State> states) {

		State findState = null;

		while (findState == null) {
			System.out.print("Next state: ");
			for (State state : states) {
				System.out.print(state);
			}
			System.out.print(": ");
			String searchName = in.next();

			for (State state : states) {

				if (state.getName().equals(searchName)) {
					findState = state;
					break;
				}
			}

			if (findState == null) {
				System.out.println("State " + searchName + " not found!");
			}
		}
		return findState;
	}
}
