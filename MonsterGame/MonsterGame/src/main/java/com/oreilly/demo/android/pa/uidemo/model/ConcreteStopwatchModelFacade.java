package com.oreilly.demo.android.pa.uidemo.model;

import com.oreilly.demo.android.pa.uidemo.common.StopwatchUIUpdateListener;
import com.oreilly.demo.android.pa.uidemo.model.clock.ClockModel;
import com.oreilly.demo.android.pa.uidemo.model.clock.DefaultClockModel;
import com.oreilly.demo.android.pa.uidemo.model.state.DefaultStopwatchStateMachine;
import com.oreilly.demo.android.pa.uidemo.model.state.StopwatchStateMachine;
import com.oreilly.demo.android.pa.uidemo.model.time.DefaultTimeModel;
import com.oreilly.demo.android.pa.uidemo.model.time.TimeModel;

/**
 * An implementation of the model facade.
 *
 * @author laufer
 */
public abstract class ConcreteStopwatchModelFacade implements StopwatchModelFacade {

	private StopwatchStateMachine stateMachine;

    private ClockModel clockModel;

	private TimeModel timeModel;

    private MonsterGroupModel monsterGroupModel;


	public ConcreteStopwatchModelFacade() {
        monsterGroupModel= new DefaultMonsterGroupModel();
		timeModel = new DefaultTimeModel();
		clockModel = new DefaultClockModel();
		stateMachine = new DefaultStopwatchStateMachine(timeModel, clockModel);
		clockModel.setOnTickListener(stateMachine);

	}

	@Override
	public void onStart() {
		stateMachine.actionInit();
	}

	@Override
	public void setUIUpdateListener(final StopwatchUIUpdateListener listener) {
		stateMachine.setUIUpdateListener(listener);
	}

    @Override
	public void onStartStop() {
        stateMachine.onStartStop();
	}

	@Override
	public void onReset() {
		stateMachine.onReset();
	}

    //implemented click counter model


}
