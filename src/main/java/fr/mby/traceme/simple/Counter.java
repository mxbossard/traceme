package fr.mby.traceme.simple;

import fr.mby.traceme.AbstractMetric;
import fr.mby.traceme.Event;
import fr.mby.traceme.Key;

public class Counter extends AbstractMetric<Counter.CounterEvent> {

	public interface CounterEvent extends Event<Void> {
		
	}
	
	public class IncrementEvent extends SimpleEvent<Void> implements CounterEvent {

		public IncrementEvent(Key key) {
			super(key, null);
		}

	}
	
	public void increment(Key key) {
		this.record(new IncrementEvent(key));
	}

}
