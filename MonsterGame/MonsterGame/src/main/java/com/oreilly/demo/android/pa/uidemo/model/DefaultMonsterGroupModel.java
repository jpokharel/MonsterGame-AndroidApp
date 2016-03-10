package com.oreilly.demo.android.pa.uidemo.model;
import java.util.*;
/**
 * All the individual monsters are collected into the list in this class, to make a complex list of monsters.
 */
public class DefaultMonsterGroupModel implements MonsterGroupModel {
        private   List<AbstractMonsterModel> monster = new ArrayList<AbstractMonsterModel>();
        private   List<AbstractMonsterModel> monsterCollection = Collections.unmodifiableList(monster);


        private MonstersListener mListener;

        public void setMonstersListener(final MonstersListener l) {
             mListener = l;
        }

    /*
    This function adds a new monster
     */
    public void addNewMonster(final int i) {
        monster.add(new DefaultMonsterModel(i, false));
        AlertMonsterListener();
    }

    /*
    Function to obtain the monster from the List.
     */
        public  List<AbstractMonsterModel> getMonsters() {
            final List<AbstractMonsterModel> MonsterList = new ArrayList<AbstractMonsterModel>();
            for (final AbstractMonsterModel m : monsterCollection ) {
                MonsterList.add(m.MonsterCopy());
            }
            return MonsterList;
        }
        protected  void AlertMonsterListener() {
            if (null != mListener) {
                mListener.changeMonsterVulnerability();
            }
        }


    /*
    This function returns the index of the square box which has the monster.
     */
        public boolean CellWithMonster(final int i) { 
           if(!monsterCollection.contains(monsterCollection.get(i).MonsterCopy()))
                {
                    return true;
                }
            return false;
        }

    //for movement, get all cells with monsters and increment i by 1 to move it right, decrement by 1 to move left
    //decrement i by number of squares in row to move up, increment i by number of squares in row to move down
    // and create if statements so they don't move to where a monster is located or out of bounds


}
