package fr.mby.traceme;

import java.util.Set;

public interface Metric<T extends Event<?>> {

	void record(T event);

	void subscribe(Stat<T> stat);
	
	void unsubscribe(Stat<T> stat);
	
	Set<Stat<T>> getSubscribers();
	
}
