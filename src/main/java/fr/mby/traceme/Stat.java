package fr.mby.traceme;

public interface Stat<T extends Event<?>> {

	void store(T event);
	
	View flush();
	
	void reset();
	
}
