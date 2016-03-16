package fr.mby.traceme;

public interface Stat {

	@SuppressWarnings("unchecked")
	default <S extends Stat, T extends StatView> T flush(ViewRenderer<S, T> renderer) {
		return renderer.render((S)this);
	}
	
	void reset();
	
}
