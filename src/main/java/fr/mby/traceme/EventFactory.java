package fr.mby.traceme;

public interface EventFactory {

	<M, E extends Event<M>> E build(String eventType, Key key, M measure);
	
}
