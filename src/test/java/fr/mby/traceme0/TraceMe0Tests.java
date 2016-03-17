package fr.mby.traceme0;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import fr.mby.traceme.Key;
import fr.mby.traceme0.impl.SimpleCounter;
import fr.mby.traceme0.impl.SimpleKey;
import fr.mby.traceme0.impl.SimpleTimer;
import fr.mby.traceme0.impl.StringView;

@RunWith(BlockJUnit4ClassRunner.class)
public class TraceMe0Tests {

	private static final Key KEY_FOO = new SimpleKey("Foo");
	private static final Key KEY_BAR = new SimpleKey("Bar");
	private static final Key KEY_BAZ = new SimpleKey("Baz");

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
