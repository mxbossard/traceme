package fr.mby.traceme0;

import fr.mby.traceme.Key;

public interface CounterStat extends Stat {

	void increment(Key key);
	
}
