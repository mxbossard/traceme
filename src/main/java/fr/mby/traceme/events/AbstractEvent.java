package fr.mby.traceme.events;

import fr.mby.traceme.Event;
import fr.mby.traceme.Key;

public abstract class AbstractEvent<T> implements Event<T> {

	private final Key key;
	
	private final T measure;

	public AbstractEvent(Key key, T measure) {
		super();
		this.key = key;
		this.measure = measure;
	}

	@Override
	public Key getKey() {
		return key;
	}

	@Override
	public T getMeasure() {
		return measure;
	}

	@Override
	public <E extends Event<T>> boolean ofType(Class<E> type) {
		return type.isAssignableFrom(this.getClass());
	}

}
