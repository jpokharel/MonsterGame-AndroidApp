package com.oreilly.demo.android.pa.uidemo.model;

/*
Monster model interface, implemented by DefaultMonsterModel
It extends Cloneable to help create copies of monsters
 */
public interface AbstractMonsterModel extends Cloneable {
    public int getIndex();
    public boolean isVulnerable();
    public AbstractMonsterModel MonsterCopy();
    public void makeProtected(boolean x);
}
