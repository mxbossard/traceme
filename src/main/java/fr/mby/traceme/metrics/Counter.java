package fr.mby.traceme.metrics;

import fr.mby.traceme.AbstractMetric;
import fr.mby.traceme.Key;
import fr.mby.traceme.events.IncrementEvent;

public class Counter extends AbstractMetric<IncrementEvent> {

	public void increment(Key key) {
		this.record(new IncrementEvent(key, 1L));
	}
	
	public void increment(Key key, Long increment) {
		this.record(new IncrementEvent(key, increment));
	}

}
