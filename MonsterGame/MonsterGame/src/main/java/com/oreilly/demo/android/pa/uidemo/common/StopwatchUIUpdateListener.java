package com.oreilly.demo.android.pa.uidemo.common;

/**
 * A listener for UI update notifications.
 * This interface is typically implemented by the adapter, with the
 * notifications coming from the model.
 *
 * @author laufer
 */
public interface StopwatchUIUpdateListener {
	void updateTime(int timeValue);
	void updateState(int stateId);
}
