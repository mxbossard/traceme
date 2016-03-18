package fr.mby.traceme.events;

import java.time.Instant;

import fr.mby.traceme.Key;

public class StartEvent extends AbstractEvent<Instant> implements TimerEvent {

	public StartEvent(Key key) {
		super(key, Instant.now());
	}
	
	public StartEvent(Key key, Instant start) {
		super(key, start);
	}

}
