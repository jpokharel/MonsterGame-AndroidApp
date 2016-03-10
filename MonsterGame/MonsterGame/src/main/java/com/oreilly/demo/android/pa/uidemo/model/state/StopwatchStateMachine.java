package com.oreilly.demo.android.pa.uidemo.model.state;

import com.oreilly.demo.android.pa.uidemo.common.StopwatchUIListener;
import com.oreilly.demo.android.pa.uidemo.common.StopwatchUIUpdateSource;
import com.oreilly.demo.android.pa.uidemo.model.clock.OnTickListener;

/**
 * The state machine for the state-based dynamic model of the stopwatch.
 * This interface is part of the State pattern.
 *
 * @author laufer
 */
public interface StopwatchStateMachine extends StopwatchUIListener, OnTickListener, StopwatchUIUpdateSource, StopwatchSMStateView { }
