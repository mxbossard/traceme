package fr.mby.traceme;

public interface Event<T> {

	Key getKey();
	
	T getMeasure();
	
	<E extends Event<T>> boolean ofType(Class<E> type);
	
}
