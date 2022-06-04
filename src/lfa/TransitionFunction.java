package lfa;

public class TransitionFunction {

	public TransitionFunction(char start, char topPile, State nextState, char nextSymbol) {
		this.start = start;
		this.topPile = topPile;
		this.nextState = nextState;
		this.nextSymbol = nextSymbol;
	}

	private char start;
	private char topPile;
	private State nextState;
	private char nextSymbol;

	public TransitionFunction() {

	}

	public char getStart() {
		return start;
	}

	public void setStart(char start) {
		this.start = start;
	}

	public char getTopPile() {
		return topPile;
	}

	public void setTopPile(char topPile) {
		this.topPile = topPile;
	}

	public State getNextState() {
		return nextState;
	}

	public void setNextState(State nextState) {
		this.nextState = nextState;
	}

	public char getNextSymbol() {
		return nextSymbol;
	}

	public void setNextSymbol(char nextSymbol) {
		this.nextSymbol = nextSymbol;
	}

	@Override
	public String toString() {
		return "(" + start + ")";
	}
}
