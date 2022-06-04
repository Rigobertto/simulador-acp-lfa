package lfa;

import java.util.List;

public interface InterModelo {

	public Automato PushdownAutomaton();
	//public List<State> createState();
	//public Automato createAutomato(List<State> states);
	//public void completeTransitionFunctions(List<State> states, Automato pushdownAutomaton);
	public State choiceStates(List<State> states);
	
}
