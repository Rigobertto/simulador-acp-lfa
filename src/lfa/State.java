package lfa;

import java.util.List;

public class State implements InterState{

	private String name;
	private boolean accepted;
	private List<TransitionFunction> functions;

	public State(String name, boolean accepted) {
		this.name = name;
		this.accepted = accepted;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isAccepted() {
		return accepted;
	}

	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}

	public List<TransitionFunction> getFunctions() {
		return functions;
	}

	public void setFunctions(List<TransitionFunction> functions) {
		this.functions = functions;
	}

	@Override
	public String toString() {
		return "[ " + name + " ]";
	}
}
