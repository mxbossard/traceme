package fr.mby.traceme.impl;

import java.util.HashMap;

import fr.mby.traceme.CounterStat;
import fr.mby.traceme.StatKey;
import fr.mby.traceme.ViewRenderer;

public class ThreadLocalCounter implements CounterStat {

	private final ThreadLocal<HashMap<StatKey, Long>> counter = new ThreadLocal<>();
	
	@Override
	public void reset() {
		counter.set(new HashMap<>());
	}

	@Override
	public void increment(StatKey key) {
		counter.get().merge(key, 1L, (x, y) -> x + 1);
	}

	public class StringRenderer implements ViewRenderer<ThreadLocalCounter, StringView> {

		@Override
		public StringView render(ThreadLocalCounter s) {
			return new StringView(s.counter.toString());
		}

	}

}

