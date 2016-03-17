package fr.mby.traceme;

public interface Event<M> {

	Key getKey();
	
	M getMeasure();
	
}
