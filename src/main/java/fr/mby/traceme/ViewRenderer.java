package fr.mby.traceme;

public interface ViewRenderer<S extends Stat, T extends StatView> {

	T render(S s);
	
}
