package com.oreilly.demo.android.pa.uidemo.model.state;

import com.oreilly.demo.android.pa.uidemo.common.StopwatchUIListener;
import com.oreilly.demo.android.pa.uidemo.model.clock.OnTickListener;

/**
 * A state in a state machine. This interface is part of the State pattern.
 *
 * @author laufer
 */
interface StopwatchState extends StopwatchUIListener, OnTickListener {
	void updateView();
	int getId();
}
