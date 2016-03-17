package fr.mby.traceme.simple;

import java.time.Instant;

import fr.mby.traceme.AbstractMetric;
import fr.mby.traceme.Event;
import fr.mby.traceme.Key;

public class Timer extends AbstractMetric<Timer.TimerEvent> {

	public interface TimerEvent extends Event<Instant> {
		
	}
	
	public class StartEvent extends SimpleEvent<Instant> implements TimerEvent {
		public StartEvent(Key key) {
			super(key, Instant.now());
		}
	}
	
	public class EndEvent extends SimpleEvent<Instant> implements TimerEvent {
		public EndEvent(Key key) {
			super(key, Instant.now());
		}
	}

	public void start(Key key) {
		this.record(new StartEvent(key));
	}
	
	public void end(Key key) {
		this.record(new EndEvent(key));
	}
	
}
