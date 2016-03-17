package fr.mby.traceme;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.Instant;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import fr.mby.traceme.impl.BasicCounterStat;
import fr.mby.traceme.impl.BasicTimerStat;
import fr.mby.traceme.impl.StringView;
import fr.mby.traceme.simple.Counter;
import fr.mby.traceme.simple.SimpleKey;
import fr.mby.traceme.simple.Timer;
import fr.mby.traceme0.impl.SimpleTimer;
import fr.mby.traceme0.impl.SimpleTimer.StringRenderer;

@RunWith(BlockJUnit4ClassRunner.class)
public class TraceMeTests {

	private static final Key KEY_FOO = new SimpleKey("Foo");
	private static final Key KEY_BAR = new SimpleKey("Bar");
	private static final Key KEY_BAZ = new SimpleKey("Baz");

	@Before
	public void setUp() {

	}

	@Test
	public void testSimpleCounter() throws Exception {
		Counter cm = new Counter();

		BasicCounterStat stat = new BasicCounterStat();
		cm.subscribe(stat);
		
		cm.increment(KEY_FOO);
		cm.increment(KEY_FOO);
		cm.increment(KEY_FOO);
		cm.increment(KEY_BAR);
		cm.increment(KEY_FOO);
		cm.increment(KEY_FOO);
		cm.increment(KEY_BAR);
		cm.increment(KEY_FOO);
		
		StringView view = stat.flush();
		view.paint();
		
		assertEquals("BasicCounterStat view should be exact", "{SimpleKey [key=Bar]=2, SimpleKey [key=Foo]=6}", view.getMessage());
	}

	@Test
	public void testSimpleTimer() throws Exception {
		Timer tm = new Timer();
		
		BasicTimerStat stat = new BasicTimerStat();
		tm.subscribe(stat);
		
		tm.start(KEY_FOO);
		Thread.sleep(1);
		tm.start(KEY_BAR);
		Thread.sleep(1);
		tm.end(KEY_BAR);
		Thread.sleep(1);
		tm.start(KEY_BAR);
		Thread.sleep(1);
		tm.start(KEY_BAR);
		Thread.sleep(1);
		tm.end(KEY_BAZ);
		Thread.sleep(1);
		tm.start(KEY_BAR);
		Thread.sleep(1);
		tm.end(KEY_BAR);
		Thread.sleep(1);
		tm.end(KEY_FOO);
		Thread.sleep(1);
		tm.end(KEY_BAR);
		
		StringView view = stat.flush();
		view.paint();
		
		assertNotNull("SimpleTimer view should not be null", view.getMessage());
	}
	
}
