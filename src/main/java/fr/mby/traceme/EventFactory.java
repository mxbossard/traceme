package fr.mby.traceme;

public interface EventFactory {

	<M, E extends Event<M>> E build(Class<E> eventType, Key key, M measure);
	
}
