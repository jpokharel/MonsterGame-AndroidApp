package com.oreilly.demo.android.pa.uidemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.oreilly.demo.android.pa.uidemo.model.GameModel;
import com.oreilly.demo.android.pa.uidemo.model.DefaultGridModel;
import com.oreilly.demo.android.pa.uidemo.model.DefaultMonsterGroupModel;
import com.oreilly.demo.android.pa.uidemo.model.MonsterGroupModel;
import com.oreilly.demo.android.pa.uidemo.view.MonsterGameView;

import java.util.Random;


/**
 * Android UI demo program
 */
public class TouchMe extends Activity {

    public static final int DIAMETER_OF_SQUARE = 80;
    private MonsterGameView mgView;
    private final Random rand = new Random();
    private TextView value;
    private static final int NUM_OF_MONSTERS = 5;
    private static boolean model = false;
    private static final MonsterGroupModel monsterGroup = new DefaultMonsterGroupModel();
    private static final DefaultGridModel dgModel = new DefaultGridModel();

    /** Listen for taps. */
    private static final class TrackingTouchListener implements View.OnTouchListener {
        private final DefaultGridModel dgModel;

        TrackingTouchListener(DefaultGridModel dgModel) {
            this.dgModel = dgModel;

        }

        @Override
        public boolean onTouch(View v, MotionEvent evt) {
             return true;
        }
    }

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        // install the view
        setContentView(R.layout.main);
        //Obtain the User Interface elements
        mgView = (MonsterGameView) findViewById(R.id.mgV);
        value = (TextView) findViewById(R.id.value);
        mgView.setActivity(this);

    }

    /**
     * This installs Menu in the UI
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.simple_menu, menu);
        return true;
    }


    /**
     * It installs the created context menu.
     */
    @Override
    public void onCreateContextMenu(ContextMenu menu,View v,ContextMenuInfo menuInfo) {
       menu.add(Menu.NONE, 1, Menu.NONE, "Clear")
               .setAlphabeticShortcut('x');
    }




    /*
    This function makes the new model of the game using the pixel Density resources.
     */

    public void makeModel(final int width, final int height) {

        int d = (int) (DIAMETER_OF_SQUARE * getResources().getDisplayMetrics().density);
        if (!model) {
            GameModel.create(width, height, dgModel, (DefaultMonsterGroupModel) monsterGroup, d, NUM_OF_MONSTERS, rand);
            model = true;
            /*Sets the grid and Monsters for the game*/
            mgView.setGrid(dgModel);
            mgView.setMonsters(monsterGroup);
            mgView.setOnTouchListener(new TrackingTouchListener(dgModel));
        }
    }

}