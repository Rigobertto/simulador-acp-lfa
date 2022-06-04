package lfa;

public interface InterAutomato {
	
	public void reloadAutomato(char start);
	public void validationStart(String start) throws Exception ;
	public boolean alphaStart(char start);
	public boolean alphaStartPile(char element);
	public boolean isVoidTransition();
	
}
