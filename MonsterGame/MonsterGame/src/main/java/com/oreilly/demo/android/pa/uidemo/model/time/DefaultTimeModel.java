package com.oreilly.demo.android.pa.uidemo.model.time;

import static com.oreilly.demo.android.pa.uidemo.common.Constants.SEC_PER_HOUR;
import static com.oreilly.demo.android.pa.uidemo.common.Constants.SEC_PER_TICK;

/**
 * An implementation of the stopwatch data model.
 */
public class DefaultTimeModel implements TimeModel {

	private int runningTime;

    /** The lower bound of the counter. */
    private final int min=0;

    /** The upper bound of the counter. */
    private final int max=120;

    @Override
	public void resetRuntime() {
		runningTime = 0;
	}

    @Override
	public void decRuntime()
    {
            if(!isEmpty())
            {
                runningTime = (runningTime - SEC_PER_TICK) % SEC_PER_HOUR;
            }
	}

    @Override
    public void incRuntime()
    {
            if(!isFull())
            {
                runningTime = (runningTime + SEC_PER_TICK) % SEC_PER_HOUR;
            }
    }

    @Override
	public int getRuntime() {
		return runningTime;
	}

    @Override
	public void setRuntime(int time) {
		runningTime = time;
	}

    public boolean isFull() {
        return runningTime >= max;
    }

    public boolean isEmpty() {
        return runningTime <= min;
    }

}