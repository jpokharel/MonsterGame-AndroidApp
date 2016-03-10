package com.oreilly.demo.android.pa.uidemo.model.state;


import com.oreilly.demo.android.pa.uidemo.common.StopwatchUIUpdateListener;
import com.oreilly.demo.android.pa.uidemo.model.clock.ClockModel;
import com.oreilly.demo.android.pa.uidemo.model.time.TimeModel;

/**
 * An implementation of the state machine for the stopwatch.
 *
 * @author laufer
 */
public class DefaultStopwatchStateMachine implements StopwatchStateMachine {

	public DefaultStopwatchStateMachine(final TimeModel timeModel, final ClockModel clockModel) {
		this.timeModel = timeModel;
		this.clockModel = clockModel;
	}

	private final TimeModel timeModel;

	private final ClockModel clockModel;

	/**
	 * The internal state of this adapter component. Required for the State pattern.
	 */
	private StopwatchState state;

	protected void setState(final StopwatchState state) {
		this.state = state;
		uiUpdateListener.updateState(state.getId());
	}


	private StopwatchUIUpdateListener uiUpdateListener;

	@Override
	public void setUIUpdateListener(final StopwatchUIUpdateListener uiUpdateListener) {
		this.uiUpdateListener = uiUpdateListener;
	}

	// forward event uiUpdateListener methods to the current state
	@Override public void onStartStop() { state.onStartStop(); }
	@Override public void onReset()  { state.onReset(); }
	@Override public void onTick()      { state.onTick(); }

	@Override public void updateUIRuntime() { uiUpdateListener.updateTime(timeModel.getRuntime()); }


	// known states
	private final StopwatchState STOPPED     = new StoppedState(this);
	private final StopwatchState RUNNING     = new RunningState(this);
	private final StopwatchState VULNERABLE = new VulnerableState(this);
    private final StopwatchState PROTECTED = new ProtectedState(this);


	// transitions
	@Override public void toRunningState()    { setState(RUNNING); }
	@Override public void toStoppedState()    { setState(STOPPED); }
	@Override public void toVulnerableState() { setState(VULNERABLE); }
    @Override public void toProtectedState() { setState(PROTECTED); }

    //check if time is up or at max
    @Override public boolean isTimeZero(){if(timeModel.getRuntime()==0){return true;}return false;}
    @Override public boolean isTimeAtMax(){if(timeModel.getRuntime()==120){return true;}return false;}

	// actions
	@Override public void actionInit()       { toStoppedState(); actionReset(); }
	@Override public void actionReset()      { timeModel.setRuntime(120); actionUpdateView(); }
	@Override public void actionStart()      { clockModel.start(); }
	@Override public void actionStop()       { clockModel.stop();timeModel.resetRuntime(); }
	@Override public void actionDec(){timeModel.decRuntime(); actionUpdateView();}
    @Override public void actionSetTime(int time){timeModel.incRuntime(); actionUpdateView();}
	@Override public void actionUpdateView() { state.updateView(); }

     }

