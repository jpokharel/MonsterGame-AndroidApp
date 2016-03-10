package com.oreilly.demo.android.pa.uidemo.model;
import java.util.Random;
/**
 * Created by jiwanpokharel89 on 4/27/2014.
 */
public class GameModel {

    public static int findSquareIndex(DefaultGridModel dgModel, final float x) {
        return (int) (dgModel.getList().size() * x);
    }

    public static void create(final int width, final int height, final DefaultGridModel dgModel, final DefaultMonsterGroupModel dmgModel,
                              final int diameter, final int x, final Random rand) {

        makeGrid(width, height, diameter, dgModel);
        createMonsters(x, dgModel, dmgModel, rand);
    }

    public static void makeGrid(final int w, final int h,final int d, final DefaultGridModel dgModel) {

        final int center = d / 2;
        final int xValue = h / d;
        final int yValue = w / d;
        dgModel.setXY(yValue, xValue);
        final int hd = (h % d) / 2;
        final int wd = (w % d) / 2;
        for (int i = 0; i < xValue; i++) {
            for (int j = 0; j < yValue; j++) {
                final int xHalf = wd + (j * d) + center;
                final int yHalf = hd + (i * d) + center;
                dgModel.NewSquare(xHalf, yHalf, d);
            }
        }
    }
    public static void createMonsters(final int n, final DefaultGridModel dgModel,final DefaultMonsterGroupModel dmgModel,final Random rand) {
        for (int i = 0; i < n; i++) {
            boolean isCreate = true;
            while (isCreate) {
                final int index = findSquareIndex(dgModel, rand.nextFloat());
                isCreate = dmgModel.CellWithMonster(index);
                if (!isCreate) {
                    dmgModel.addNewMonster(index);
                }
            }
        }
    }



}
