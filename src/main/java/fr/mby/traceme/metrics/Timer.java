package fr.mby.traceme.metrics;

import fr.mby.traceme.AbstractMetric;
import fr.mby.traceme.Key;
import fr.mby.traceme.events.TimerEvent;
import fr.mby.traceme.events.StartEvent;
import fr.mby.traceme.events.StopEvent;

public class Timer extends AbstractMetric<TimerEvent> {

	public void start(Key key) {
		this.record(new StartEvent(key));
	}
	
	public void stop(Key key) {
		this.record(new StopEvent(key));
	}
	
}
