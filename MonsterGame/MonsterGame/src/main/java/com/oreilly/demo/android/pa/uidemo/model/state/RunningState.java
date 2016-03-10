package com.oreilly.demo.android.pa.uidemo.model.state;

import com.oreilly.demo.android.pa.uidemo.R;

class RunningState implements StopwatchState {

	public RunningState(final StopwatchSMStateView sm) {
		this.sm = sm;
	}

	private final StopwatchSMStateView sm;


	@Override
	public void onStartStop() {
        sm.toStoppedState();
        sm.actionReset();
	}

	@Override
	public void onReset() {
	}

    @Override
    public void onTick() {
        sm.actionDec();
        sm.toRunningState();
        if(sm.isTimeZero())
        {sm.toStoppedState();}
    }


	@Override
	public void updateView() {
		sm.updateUIRuntime();
	}

	@Override
	public int getId() {
		return R.string.RUNNING;
	}
}
