package fr.mby.traceme0.impl;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import fr.mby.traceme.Key;
import fr.mby.traceme0.TimerStat;
import fr.mby.traceme0.ViewRenderer;

public class SimpleTimer implements TimerStat {
	
	private final Map<Key, Stack<Instant>> inProgressTimers = new HashMap<>();
	
	private final Map<Key, Collection<Duration>> recordedDurations = new HashMap<>();
	
	@Override
	public void reset() {
		inProgressTimers.clear();
		recordedDurations.clear();
	}

	@Override
	public void start(Key key) {
		inProgressTimers.putIfAbsent(key, new Stack<Instant>());
		inProgressTimers.get(key).push(Instant.now());
	}

	@Override
	public void end(Key key) {
		inProgressTimers.computeIfPresent(key, (k, stack) -> {
			final Duration duration = Duration.between(stack.pop(), Instant.now());
			recordedDurations.putIfAbsent(key, new ArrayList<>());
			recordedDurations.get(key).add(duration);
			
			return stack;
		});
	}
	
	public class StringRenderer implements ViewRenderer<SimpleTimer, StringView> {

		@Override
		public StringView render(SimpleTimer s) {
			return new StringView(s.recordedDurations.toString());
		}

	}

}
