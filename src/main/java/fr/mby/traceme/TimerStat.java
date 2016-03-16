package fr.mby.traceme;

public interface TimerStat extends Stat {

	void start(StatKey key);
	
	void end(StatKey key);
	
}
