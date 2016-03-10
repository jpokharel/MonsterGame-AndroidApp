package com.oreilly.demo.android.pa.uidemo.model.time;

/**
 * The passive data model of the stopwatch.
 * It does not emit any events.
 *
 * @author laufer
 */
public interface TimeModel {
	void resetRuntime();
	void decRuntime();
    void incRuntime();
	public int getRuntime();
	public void setRuntime(int runtime);
}
