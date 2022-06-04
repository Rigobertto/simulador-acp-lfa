package lfa;

import java.util.List;
import java.util.Stack;

public interface InterCurrentState {
	
	public void viewPile();
	public List<CurrentState> transictionStates(char start);
	public void addPile(Stack<Character> pile, char start);
	public List<CurrentState> transictionStates(State state, char start, Stack<Character> InitialPile);
	
}
