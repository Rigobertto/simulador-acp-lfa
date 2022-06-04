package lfa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Automato implements InterAutomato{

	private Set<Character> aPile;
	public List<CurrentState> currentStates;

	//
	
	
	
	
	public Set<Character> getaPile() {
		return aPile;
	}

	public void setaPile(Set<Character> aPile) {
		this.aPile = aPile;
	}

	public List<CurrentState> getCurrentStates() {
		return currentStates;
	}

	public void setCurrentStates(List<CurrentState> currentStates) {
		this.currentStates = currentStates;
	}

	public char getFirstElement() {
		return firstElement;
	}

	public void setFirstElement(char firstElement) {
		this.firstElement = firstElement;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public State getFirstState() {
		return firstState;
	}

	public void setFirstState(State firstState) {
		this.firstState = firstState;
	}

	public Set<Character> getaAutomato() {
		return aAutomato;
	}

	public void setaAutomato(Set<Character> aAutomato) {
		this.aAutomato = aAutomato;
	}

	public Automato() {

	}
	private char firstElement;
	private String name;
	private State firstState;
	private Set<Character> aAutomato;
	public Automato(String name, State firstState, Set<Character> aAutomato, Set<Character> aPile, char firstElement) {
		Stack<Character> firstPile = new Stack<Character>();
		this.name = name;

		this.firstState = firstState;
		this.firstElement = firstElement;
		this.aPile = new HashSet<Character>();
		this.aPile.add('-');
		this.aPile.add('=');
		this.aPile.add(firstElement);
		this.aPile.addAll(aPile);
		this.aAutomato = new HashSet<Character>();
		aAutomato.add('-');
		this.aAutomato.addAll(aAutomato);

		currentStates = new ArrayList<CurrentState>();

		firstPile.push(firstElement);

		currentStates.add(new CurrentState(firstState, firstPile));
	}

	public void reloadAutomato(char start) {
		List<CurrentState> reloadCurrentStates = new ArrayList<CurrentState>();

		for (CurrentState currentState : currentStates) {
			List<CurrentState> nextStates = currentState.transictionStates(start);

			System.out.println('\n');
			System.out.println("Previous State: " + currentState.getState().getName());
			System.out.print("Previous Stack: ");
			currentState.viewPile();
			System.out.println("\nA Input: " + start);

			System.out.print("Result of states: ");
			if (nextStates.size() == 0) {
				System.out.print("Tree Death");
			} else {
				reloadCurrentStates.addAll(nextStates);
				CurrentState lastNextState = nextStates.get(nextStates.size() - 1);

				for (CurrentState nextState : nextStates) {
					boolean tree = nextState == null || nextState.getState() == null;
					System.out.print(tree ? "Árvore morre" : nextState.getState().getName());

					if (!tree) {
						System.out.print(" (Stack: ");
						nextState.viewPile();
						System.out.print(")");
					}
					if (nextState != lastNextState) {
						System.out.print(", ");
					}
				}
			}
		}
		System.out.println();
		System.out.println("\n---//------//------//------//------//------//---");

		reloadCurrentStates.removeAll(Collections.singleton(null));
		currentStates = reloadCurrentStates;
	}

	// 
	public void validationStart(String start) throws Exception {
		for (int i = 0; i < start.length(); i++) {
			char caractere = start.charAt(i);

			if (!alphaStart(caractere)) {
				throw new Exception("Invalid Input");
			}
		}
	}

	//
	public boolean alphaStart(char start) {
		for (char caractere : aAutomato) {
			if (caractere == start) {
				return true;
			}
		}

		System.out.println("Unrecognized input");
		return false;
	}

	// 
	public boolean alphaStartPile(char element) {
		for (char caractere : aPile) {
			if (caractere == element) {
				return true;
			}
		}

		System.out.println("Input not accepted");
		return false;
	}

	// 
	public boolean isVoidTransition() {
		for (CurrentState status : currentStates) {

			List<TransitionFunction> transitionFunctions = status.getState().getFunctions();

			if (status.getState().getFunctions() == null) {
				continue;
			}

			for (TransitionFunction function : transitionFunctions) {
				if (function.getStart() == '-') {
					return true;
				}
			}
		}

		return false;
	}

}
