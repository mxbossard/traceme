package fr.mby.traceme;

public interface Event<M> {

	//boolean ofType(Class<EventType> type);
	
	Key getKey();
	
	M getMeasure();
	
}
