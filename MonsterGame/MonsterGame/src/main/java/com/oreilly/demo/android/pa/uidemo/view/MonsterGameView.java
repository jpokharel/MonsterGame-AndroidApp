package com.oreilly.demo.android.pa.uidemo.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;

import com.oreilly.demo.android.pa.uidemo.R;
import com.oreilly.demo.android.pa.uidemo.TouchMe;
import com.oreilly.demo.android.pa.uidemo.model.AbstractMonsterModel;
import com.oreilly.demo.android.pa.uidemo.model.DefaultGridModel;
import com.oreilly.demo.android.pa.uidemo.model.DefaultSquareModel;
import com.oreilly.demo.android.pa.uidemo.model.MonsterGroupModel;

/**
 * Created by jiwanpokharel89 on 4/27/2014.
 */
public class MonsterGameView extends View {
     
        private volatile MonsterGroupModel monsters;
        private volatile DefaultGridModel  g;
        private TouchMe touchMe;

        /**
         * @param context the rest of the application
         */
        public MonsterGameView (Context context) {
            super(context);
            setFocusableInTouchMode(true);
        }

        /**
         * @param context
         * @param attrs
         */
        public MonsterGameView (Context context, AttributeSet attrs) {
            super(context, attrs);
            setFocusableInTouchMode(true);
        }

        /**
         * @param context
         * @param attrs
         * @param defStyle
         */
        public MonsterGameView (Context context, AttributeSet attrs, int defStyle) {
            super(context, attrs, defStyle);
            setFocusableInTouchMode(true);
        }




        public void setGrid(final DefaultGridModel  grid) { this.g = grid; }

        public void setActivity(final TouchMe TM) { this.touchMe  = TM; }
        @Override protected void onSizeChanged (int width, int height, int oldWidth, int oldHeight) {
            super.onSizeChanged(width,height,oldWidth,oldHeight);
            touchMe.makeModel(width, height);
        }



        /**
         * @see android.view.View#onDraw(android.graphics.Canvas)
         */
        @Override protected void onDraw(Canvas canvas) {
            final Paint paint = new Paint();
            paint.setStyle(Style.STROKE);
            paint.setColor(Color.BLACK);
            for(final AbstractMonsterModel m : monsters.getMonsters()) {
                final int gridIndex = m.getIndex();
                final DefaultSquareModel s = g.getSquare(gridIndex);
                paint.setStyle(Paint.Style.FILL);
                Bitmap b= BitmapFactory.decodeResource(getResources(), R.drawable.monster_vulnerable);
                if (m.isVulnerable()) {
                    b= BitmapFactory.decodeResource(getResources(), R.drawable.monster_vulnerable);
                   // paint.setColor(Color.RED);
                } else {
                    b= BitmapFactory.decodeResource(getResources(), R.drawable.monster_protected);
                   // paint.setColor(Color.GREEN);
                }

                canvas.drawBitmap(b, s.getX()-25, s.getY()-25, paint);//This is where we can change the location of image
            }

            for (final DefaultSquareModel g : DefaultGridModel.getList()) {
                paint.setStyle(Paint.Style.STROKE);
                paint.setColor(Color.YELLOW);
                drawSquare(g.getX(), g.getY(), g.getSquareDiameter(), canvas, paint);//Draws each square

            }
        }

        public static void drawSquare(final int x, final int y, final int d, final Canvas canvas,
                                      final Paint paint) {

            final int radius = d/2;

            final int left = x - radius;
            final int top = y - radius;
            final int right = x + radius;
            final int bottom = y + radius;

            canvas.drawRect(left, top, right, bottom, paint);
        }


        public void setMonsters(MonsterGroupModel monsters) {
            this.monsters = monsters;
        }
    }



