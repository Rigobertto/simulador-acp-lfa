package lfa;

import java.util.Scanner;

public class Call implements InterCall{
	Scanner in = new Scanner(System.in);
	Modelo modelo = new Modelo();
	
	public void call(Automato automato) {
		int choice = 0;

		while (choice == 0) {
			automato = modelo.PushdownAutomaton();
			System.out.print("Input String: ");
			String start = in.next();

			Automato auto = new Automato(automato.getName(), automato.getFirstState(), automato.getaAutomato(),
					automato.getaPile(), automato.getFirstElement());

			try {
				// entrada completa
				auto.validationStart(start);

				for (int i = 0; i < start.length() || auto.isVoidTransition(); i++) {
					char caractere = i >= start.length() ? '-' : start.charAt(i);
					auto.reloadAutomato(caractere);
				}

				boolean isAutomato = false;

				String msg = "The String";

				for (CurrentState cState : auto.currentStates) {

					boolean ramificacaoMorta = cState == null || cState.getState() == null;

					if (!ramificacaoMorta && cState.getState().isAccepted()) {
						isAutomato = true;
					}
				}

				if (!isAutomato) {
					msg = msg + " not ";
				}
				msg = msg + " is accepted.";

				System.out.println("\n " + msg);
			} catch (Exception exception) {
				exception.printStackTrace();
			}

			System.out.println();
			System.out.print("Input 0 to enter another string or 1 to end it: ");
			int num = in.nextInt();
			
			if (num == 0) {
				choice = num;
			} else {
				choice = num;
			}
		}
		System.out.print("The end!");
	}
}
