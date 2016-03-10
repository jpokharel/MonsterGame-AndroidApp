package com.oreilly.demo.android.pa.uidemo.model;
/*
A class equivalent to Dot, required to create individual Monsters
 */
public class DefaultMonsterModel implements AbstractMonsterModel {
    private int index ; //To determine the index of the square with monster
    boolean vulnerable; //To determine if the monster is vulnerable

    /*
    *Parameterized constructor which sets properties of monsters as index number and vulnerable.
     */
    public DefaultMonsterModel(int index, boolean vulnerable){
        this.index=index;
        this.vulnerable=vulnerable;
    }

    /*
    *To return the state of the monster
     */
    public boolean isVulnerable(){ return vulnerable;}

    /*
    *To set the state of the monster
     */
    public void makeProtected(boolean x){vulnerable=x;}
    /*
    *Returns the indes in which monster lies
     */
    public int getIndex(){ return  index; }


    /*
    *Uses Cloneable to create multiple copies of monster
     */
    public AbstractMonsterModel MonsterCopy(){return new DefaultMonsterModel(index,vulnerable);}
}
