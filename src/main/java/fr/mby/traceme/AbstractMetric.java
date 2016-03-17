package fr.mby.traceme;

import java.util.HashSet;
import java.util.Set;

import com.google.common.collect.ImmutableSet;

public abstract class AbstractMetric<T extends Event<?>> implements Metric<T> {

	private ImmutableSet<Stat<T>> subscribers = ImmutableSet.of(); 
	
	public void subscribe(Stat<T> stat) {
		Set<Stat<T>> update = new HashSet<>(subscribers);
		update.add(stat);
		
		this.subscribers = ImmutableSet.copyOf(update);
	}
	
	public void unsubscribe(Stat<T> stat) {
		Set<Stat<T>> update = new HashSet<>(subscribers);
		update.remove(stat);
		
		this.subscribers = ImmutableSet.copyOf(update);
	}

	@Override
	public Set<Stat<T>> getSubscribers() {
		return subscribers;
	}
	
	@Override
	public void record(T event) {
		this.getSubscribers().parallelStream().forEach(x -> x.store(event));
	}

}
