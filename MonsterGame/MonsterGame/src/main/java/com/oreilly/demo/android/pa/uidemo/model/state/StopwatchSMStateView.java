package com.oreilly.demo.android.pa.uidemo.model.state;


/**
 * The restricted view states have of their surrounding state machine.
 * This is a client-specific interface in Peter Coad's terminology.
 *
 * @author laufer
 */
interface StopwatchSMStateView {

	// transitions
	void toRunningState();
	void toStoppedState();
	void toVulnerableState();
    void toProtectedState();

	// actions
	void actionInit();
	void actionReset();
	void actionStart();
	void actionStop();

	void actionDec();
    void actionSetTime(int time);
	void actionUpdateView();

	// state-dependent UI updates
	void updateUIRuntime();

    //check time
    boolean isTimeZero();
    boolean isTimeAtMax();
}
