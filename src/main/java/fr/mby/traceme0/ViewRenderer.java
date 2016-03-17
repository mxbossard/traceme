package fr.mby.traceme0;

public interface ViewRenderer<S extends Stat, T extends StatView> {

	T render(S s);
	
}
