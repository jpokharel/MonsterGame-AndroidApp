package com.oreilly.demo.android.pa.uidemo.Test;


import com.oreilly.demo.android.pa.uidemo.TouchMe;
import com.oreilly.demo.android.pa.uidemo.model.AbstractMonsterGroupModel;
import com.oreilly.demo.android.pa.uidemo.model.DefaultGridModel;


/**
 * Created by Yang on 5/1/2014.
 */
public abstract class DefaultMonsterGameTest extends MonsterGameTest {


    private TouchMe activity;
    private AbstractMonsterGroupModel monsters;
    private DefaultGridModel grid;

    private MonsterGameTest actualTest;


    @Override
    protected TouchMe getActivity() {
        return activity;
    }

    @Override
    protected AbstractMonsterGroupModel getMonstersModel() { return monsters; }

    @Override
    protected DefaultGridModel getGridModel() { return grid; }

    @Override
    protected void runUiThreadTasks() {
         actualTest.runUiThreadTasks();
    }

 }
