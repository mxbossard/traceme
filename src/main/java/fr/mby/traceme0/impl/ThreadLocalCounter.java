package fr.mby.traceme0.impl;

import java.util.HashMap;

import fr.mby.traceme.Key;
import fr.mby.traceme0.CounterStat;
import fr.mby.traceme0.ViewRenderer;

public class ThreadLocalCounter implements CounterStat {

	private final ThreadLocal<HashMap<Key, Long>> counter = new ThreadLocal<>();
	
	@Override
	public void reset() {
		counter.set(new HashMap<>());
	}

	@Override
	public void increment(Key key) {
		counter.get().merge(key, 1L, (x, y) -> x + 1);
	}

	public class StringRenderer implements ViewRenderer<ThreadLocalCounter, StringView> {

		@Override
		public StringView render(ThreadLocalCounter s) {
			return new StringView(s.counter.toString());
		}

	}

}

