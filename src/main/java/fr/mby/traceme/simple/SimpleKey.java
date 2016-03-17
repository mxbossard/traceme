package fr.mby.traceme.simple;

import fr.mby.traceme.Key;

public class SimpleKey implements Key {

	/** SVUID. */
	private static final long serialVersionUID = -6212304597317488036L;
	
	private final String key;

	public SimpleKey(String key) {
		super();
		this.key = key;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SimpleKey other = (SimpleKey) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SimpleKey [key=" + key + "]";
	}

}
