package fr.mby.traceme0.impl;

import fr.mby.traceme0.StatView;

public class StringView implements StatView {

	/** SVUID. */
	private static final long serialVersionUID = -6673292862508602346L;

	private String message;

	public StringView(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public void paint() {
		System.out.println(this.getMessage());
	}

}
