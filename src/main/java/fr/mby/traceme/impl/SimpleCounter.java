package fr.mby.traceme.impl;

import java.util.HashMap;
import java.util.Map;

import fr.mby.traceme.CounterStat;
import fr.mby.traceme.StatKey;
import fr.mby.traceme.ViewRenderer;

public class SimpleCounter implements CounterStat {

	private final Map<StatKey, Long> counter = new HashMap<>();
	
	@Override
	public void reset() {
		counter.clear();
	}

	@Override
	public void increment(StatKey key) {
		counter.merge(key, 1L, (x, y) -> x + 1);
	}

	public class StringRenderer implements ViewRenderer<SimpleCounter, StringView> {

		@Override
		public StringView render(SimpleCounter s) {
			return new StringView(s.counter.toString());
		}

	}

}

