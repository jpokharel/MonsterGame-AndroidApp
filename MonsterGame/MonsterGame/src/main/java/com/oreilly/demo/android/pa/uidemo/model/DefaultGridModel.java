package com.oreilly.demo.android.pa.uidemo.model;
import java.util.LinkedList;
import java.util.Collections;
import java.util.List;
/**
 * It makes a grid through the list of the number of squares.
 */
public class DefaultGridModel {
        private int width;
        private int height;
        private final  static LinkedList<DefaultSquareModel> square= new LinkedList<DefaultSquareModel>();
        private final static List<DefaultSquareModel> squareList = Collections.unmodifiableList(square);


        public  DefaultSquareModel getSquare(int squareIndex){
            return square.get(squareIndex);
        }


        public static List<DefaultSquareModel> getList(){
            return squareList;
        }

        /*
        It sets the height and width for the grid model
         */
        public void setXY(final int a, final int b) {
            this.width = a;
            this.height = b;
        }
    /*
    Uses square model to create the new model.
     */
        public void NewSquare(final int a, final int b, final int d) {
            square.add(new DefaultSquareModel(a, b, d));
        }
}
