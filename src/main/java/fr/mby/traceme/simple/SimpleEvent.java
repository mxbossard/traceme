package fr.mby.traceme.simple;

import fr.mby.traceme.Event;
import fr.mby.traceme.Key;

public class SimpleEvent<M> implements Event<M> {

	//private final Class<? extends EventType> type;
	
	private final Key key;
	
	private final M measure;

	public SimpleEvent(Key key, M measure) {
		super();
		this.key = key;
		this.measure = measure;
	}
	
//	public SimpleEvent(Class<? extends EventType> type, Key key, M measure) {
//		super();
//		this.type = type;
//		this.key = key;
//		this.measure = measure;
//	}

	@Override
	public Key getKey() {
		return key;
	}

	@Override
	public M getMeasure() {
		return measure;
	}

//	@Override
//	public boolean ofType(Class<EventType> type) {
//		return type.equals(this.type);
//	}

}
