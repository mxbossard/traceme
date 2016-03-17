package fr.mby.traceme.impl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import fr.mby.traceme.Key;
import fr.mby.traceme.Stat;
import fr.mby.traceme.simple.Counter.CounterEvent;

public class BasicCounterStat implements Stat<CounterEvent> {

	private Map<Key, Long> store = new ConcurrentHashMap<>();
	
	@Override
	public void store(CounterEvent event) {
		store.merge(event.getKey(), 1L, (x, y) -> x + 1);
	}
	

	@Override
	public StringView flush() {
		return new StringView(store.toString());
	}


	@Override
	public void reset() {
		store.clear();
	}

}
