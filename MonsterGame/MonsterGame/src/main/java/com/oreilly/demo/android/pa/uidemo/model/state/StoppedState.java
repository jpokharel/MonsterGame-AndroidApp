package com.oreilly.demo.android.pa.uidemo.model.state;


import com.oreilly.demo.android.pa.uidemo.R;

class StoppedState implements StopwatchState {

	public StoppedState(final StopwatchSMStateView sm) {
		this.sm = sm;
	}

	private final StopwatchSMStateView sm;

	@Override
	public void onStartStop() {
        sm.actionStop();
    }
	@Override
	public void onReset() {}

	@Override
	public void onTick() {

	}

	@Override
	public void updateView() {
		sm.updateUIRuntime();
	}

	@Override
	public int getId() {
		return R.string.STOPPED;
	}
}
