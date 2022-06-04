package lfa;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CurrentState implements InterCurrentState{

	private State state;

	private Stack<Character> currentPile;

	public CurrentState(State state, Stack<Character> currentPile) {
		this.state = state;
		this.currentPile = currentPile;
	}

	public CurrentState() {

	}

	public void viewPile() {
		if (currentPile.size() == 0)
			return;
		Character elemtent = currentPile.get(currentPile.size() - 1);

		for (Character elements : currentPile) {
			System.out.print(elements + " ");

			if (elements != elemtent) {
				System.out.print(" ");
			}
		}
	}

	// tratarAdicaoPilha
	public void addPile(Stack<Character> pile, char start) {
		if (start == '-') {
			pile.pop();
		} else if (start != '=') {
			pile.push(start);
		}
	}

	public List<CurrentState> transictionStates(char start) {
		if (start == '-' && state.getFunctions().size() == 0) {
			// próximosEstados == nStates
			List<CurrentState> nStates = new ArrayList<CurrentState>();
			nStates.add(this);
			return nStates;
		}

		return transictionStates(state, start, null);
	}

	public List<CurrentState> transictionStates(State state, char start, Stack<Character> InitialPile) {

		List<CurrentState> nextStates = new ArrayList<CurrentState>();

		for (TransitionFunction transitionFunction : state.getFunctions()) {

			// consumiu entrada = usedStart
			boolean usedStart = transitionFunction.getStart() == start;
			// entrada Equivalente == eStart
			boolean eStart = transitionFunction.getStart() == '-' || usedStart;
			// topo Equivalente == tEquivalent
			boolean tEquivalent = currentPile.size() != 0 && transitionFunction.getTopPile() == currentPile.peek();

			if (tEquivalent && eStart) {
				// Pilha atualizada == reloadPile
				Stack<Character> reloadPile = new Stack<Character>();

				if (InitialPile != null) {
					reloadPile.addAll(InitialPile);
				} else {
					reloadPile.addAll(currentPile);
				}

				addPile(reloadPile, transitionFunction.getNextSymbol());

				State nextState = transitionFunction.getNextState();
				if (usedStart) {
					nextStates.add(new CurrentState(nextState, reloadPile));
				} else {
					nextStates.addAll(transictionStates(nextState, start, reloadPile));
				}
			}
		}

		return nextStates;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Stack<Character> getCurrentPile() {
		return currentPile;
	}

	public void setCurrentPile(Stack<Character> currentPile) {
		this.currentPile = currentPile;
	}

}
