package com.oreilly.demo.android.pa.uidemo.model.state;

//.

import com.oreilly.demo.android.pa.uidemo.R;

class ProtectedState implements StopwatchState {

	public ProtectedState(final StopwatchSMStateView sm) {
		this.sm = sm;
	}

	private final StopwatchSMStateView sm;

	@Override
	public void onStartStop() {

	}

	@Override
	public void onReset() {
	}

	@Override
	public void onTick() {
        sm.toVulnerableState();
	}

	@Override
	public void updateView() {sm.updateUIRuntime();
	}

	@Override
	public int getId() {
		return R.string.PROTECTED;
	}

    }

