package fr.mby.traceme0;

import fr.mby.traceme.Key;

public interface TimerStat extends Stat {

	void start(Key key);
	
	void end(Key key);
	
}
