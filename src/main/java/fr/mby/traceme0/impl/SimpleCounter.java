package fr.mby.traceme0.impl;

import java.util.HashMap;
import java.util.Map;

import fr.mby.traceme.Key;
import fr.mby.traceme0.CounterStat;
import fr.mby.traceme0.ViewRenderer;

public class SimpleCounter implements CounterStat {

	private final Map<Key, Long> counter = new HashMap<>();
	
	@Override
	public void reset() {
		counter.clear();
	}

	@Override
	public void increment(Key key) {
		counter.merge(key, 1L, (x, y) -> x + 1);
	}

	public class StringRenderer implements ViewRenderer<SimpleCounter, StringView> {

		@Override
		public StringView render(SimpleCounter s) {
			return new StringView(s.counter.toString());
		}

	}

}

