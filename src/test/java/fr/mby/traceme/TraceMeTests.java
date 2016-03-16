package fr.mby.traceme;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import fr.mby.traceme.impl.SimpleCounter;
import fr.mby.traceme.impl.SimpleKey;
import fr.mby.traceme.impl.SimpleTimer;
import fr.mby.traceme.impl.StringView;

@RunWith(BlockJUnit4ClassRunner.class)
public class TraceMeTests {

	private static final StatKey KEY_FOO = new SimpleKey("Foo");
	private static final StatKey KEY_BAR = new SimpleKey("Bar");
	private static final StatKey KEY_BAZ = new SimpleKey("Baz");

	@Before
	public void setUp() {

	}

	@Test
	public void testSimpleCounter() throws Exception {
		SimpleCounter sc = new SimpleCounter();
		sc.increment(KEY_FOO);
		sc.increment(KEY_FOO);
		sc.increment(KEY_FOO);
		sc.increment(KEY_BAR);
		sc.increment(KEY_FOO);
		sc.increment(KEY_FOO);
		sc.increment(KEY_BAR);
		sc.increment(KEY_FOO);
		
		StringView view = sc.flush(sc.new StringRenderer());
		view.paint();
		
		assertEquals("SimpleCounter view should be exact", "{SimpleKey [key=Bar]=2, SimpleKey [key=Foo]=6}", view.getMessage());
	}

	@Test
	public void testSimpleTimer() throws Exception {
		SimpleTimer st = new SimpleTimer();
		st.start(KEY_FOO);
		Thread.sleep(1);
		st.start(KEY_BAR);
		Thread.sleep(1);
		st.end(KEY_BAR);
		Thread.sleep(1);
		st.start(KEY_BAR);
		Thread.sleep(1);
		st.start(KEY_BAR);
		Thread.sleep(1);
		st.end(KEY_BAZ);
		Thread.sleep(1);
		st.start(KEY_BAR);
		Thread.sleep(1);
		st.end(KEY_BAR);
		Thread.sleep(1);
		st.end(KEY_FOO);
		Thread.sleep(1);
		st.end(KEY_BAR);
		
		StringView view = st.flush(st.new StringRenderer());
		view.paint();
		
		assertNotNull("SimpleTimer view should not be null", view.getMessage());
	}

}
