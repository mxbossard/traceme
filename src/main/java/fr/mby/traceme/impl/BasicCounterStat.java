package fr.mby.traceme.impl;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import com.google.common.collect.ImmutableMap;

import fr.mby.traceme.Key;
import fr.mby.traceme.Stat;
import fr.mby.traceme.View;
import fr.mby.traceme.simple.Counter.CounterEvent;

public class BasicCounterStat implements Stat<CounterEvent> {

	private ConcurrentHashMap<Key, Long> store = new ConcurrentHashMap<>();
	
	@Override
	public void store(CounterEvent event) {
		store.merge(event.getKey(), 1L, (x, y) -> x + 1);
	}
	
	@Override
	public View draw() {
		return new StringView(store.toString());
	}

	@Override
	public StringView flush() {
		ImmutableMap.Builder<Key, Long> cache = ImmutableMap.builder();
		Iterator<Entry<Key, Long>> it = store.entrySet().iterator();
		it.forEachRemaining(e -> {cache.put(e); it.remove();});
		
		return new StringView(cache.build().toString());
	}


	@Override
	public void reset() {
		store.clear();
	}

}
