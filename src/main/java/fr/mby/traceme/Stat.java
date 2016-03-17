package fr.mby.traceme;

public interface Stat<T extends Event<?>> {

	/**
	 * Store an event.
	 * 
	 * @param event
	 */
	void store(T event);
	
	/**
	 * Draw the Stat View by it state.
	 * @return
	 */
	View draw();

	/** 
	 * Flush the Stat state generating the View.
	 * 
	 * @return
	 */
	View flush();

	/**
	 * Reset the Stat state.
	 */
	void reset();

}
