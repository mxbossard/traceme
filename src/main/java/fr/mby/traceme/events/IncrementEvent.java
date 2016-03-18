package fr.mby.traceme.events;

import fr.mby.traceme.Key;

public class IncrementEvent extends AbstractEvent<Long> {

	public IncrementEvent(Key key, Long increment) {
		super(key, increment);
	}

}
