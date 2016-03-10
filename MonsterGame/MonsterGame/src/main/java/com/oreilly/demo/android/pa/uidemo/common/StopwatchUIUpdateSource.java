package com.oreilly.demo.android.pa.uidemo.common;

/**
 * A source of UI update events for the stopwatch.
 * This interface is typically implemented by the model.
 *
 * @author laufer
 */
public interface StopwatchUIUpdateSource {
	void setUIUpdateListener(StopwatchUIUpdateListener listener);
}
