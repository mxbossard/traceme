package fr.mby.traceme.impl;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;

import fr.mby.traceme.Key;
import fr.mby.traceme.Stat;
import fr.mby.traceme.View;
import fr.mby.traceme.events.TimerEvent;
import fr.mby.traceme.events.StartEvent;
import fr.mby.traceme.events.StopEvent;

public class BasicTimerStat implements Stat<TimerEvent> {

	private Map<Key, Stack<Instant>> inProgressTimers = new ConcurrentHashMap<>();
	
	private Map<Key, Collection<Duration>> recordedDurations = new ConcurrentHashMap<>();
	
	@Override
	public void store(TimerEvent event) {
		if (event.ofType(StartEvent.class)) {
			storeStart((StartEvent) event);
		} else if (event.ofType(StopEvent.class)) {
			storeEnd((StopEvent) event);
		}
	}
	
	@Override
	public View draw() {
		return new StringView(recordedDurations.toString());
	}

	@Override
	public StringView flush() {
		return new StringView(recordedDurations.toString());
	}

	@Override
	public void reset() {
		inProgressTimers.clear();
		recordedDurations.clear();
	}

	private void storeStart(StartEvent event) {
		inProgressTimers.putIfAbsent(event.getKey(), new Stack<Instant>());
		inProgressTimers.get(event.getKey()).push(event.getMeasure());
	}

	private void storeEnd(StopEvent event) {
		inProgressTimers.computeIfPresent(event.getKey(), (k, stack) -> {
			final Duration duration = Duration.between(stack.pop(), event.getMeasure());
			recordedDurations.putIfAbsent(event.getKey(), new ArrayList<>());
			recordedDurations.get(event.getKey()).add(duration);
			
			return stack;
		});
	}

}
