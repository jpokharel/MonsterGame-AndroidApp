package com.oreilly.demo.android.pa.uidemo.model;

import com.oreilly.demo.android.pa.uidemo.common.StopwatchUIListener;
import com.oreilly.demo.android.pa.uidemo.common.StopwatchUIUpdateSource;
import com.oreilly.demo.android.pa.uidemo.model.AbstractMonsterModel;
import com.oreilly.demo.android.pa.uidemo.model.MonsterGroupModel;


/**
 * A thin model facade. Following the Facade pattern,
 * this isolates the complexity of the model from its clients (usually the adapter).
 *
 * @author laufer
 */
public interface StopwatchModelFacade extends StopwatchUIListener, StopwatchUIUpdateSource,MonsterGroupModel{
    void onStart();
}
