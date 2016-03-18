package fr.mby.traceme.events;

import java.time.Instant;

import fr.mby.traceme.Key;

public class StopEvent extends AbstractEvent<Instant> implements TimerEvent {

	public StopEvent(Key key) {
		super(key, Instant.now());
	}
	
	public StopEvent(Key key, Instant stop) {
		super(key, stop);
	}

}
