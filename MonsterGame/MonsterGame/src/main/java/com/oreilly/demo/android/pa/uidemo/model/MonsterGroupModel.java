package com.oreilly.demo.android.pa.uidemo.model;

import java.util.List;

/**
 * Created by nestor on 5/1/2014.
 */
public interface MonsterGroupModel {
    List<AbstractMonsterModel> getMonsters();

    boolean CellWithMonster(int squareIndex);

    void addNewMonster(int gridSquareIndex);

    void setMonstersListener(MonstersListener l);
}
