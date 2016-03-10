package com.oreilly.demo.android.pa.uidemo.model;

/**
 * Created by jiwanpokharel89 on 4/27/2014.
 * A class equivalent to creating a single dot.
 */
public class DefaultSquareModel {
        private final int diameter;
        private final int x;
        private final int y;

        /**
         * Parameterized constructor to initialize the X, Y, and Diameter values
         */
        public DefaultSquareModel(final int a, final int b, final int diameter) {
            this.x = a;
            this.y = b;
            this.diameter = diameter;

        }
        /** return the horizontal location */
        public int getX() { return x; }

        /** return the vertical location */
        public int getY() { return y; }

        /** return the diameter of the single square model */
        public int getSquareDiameter() { return diameter; }

}
