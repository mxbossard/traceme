package fr.mby.traceme;

public interface CounterStat extends Stat {

	void increment(StatKey key);
	
}
