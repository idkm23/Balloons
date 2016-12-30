package edu.uml.cs.balloons;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Created by csrobot on 12/28/16.
 */

public class Balloon {

    public static enum BalloonColor {
        BLUE,
        GREEN,
        PINK,
        RED,
        YELLOW;

        public static BalloonColor getRandomColor() {
            return BalloonColor.values()[(int)(Math.random() * (BalloonColor.values().length - 1))];
        }
    }

    private static int balloonHeight;
    private int x;
    private int y = 0;
    private int speed = 5;
    private BalloonColor color;

    public Balloon() {
        // x is between 0.1 to 0.9 of the screen width
        this.x = (int) ((Math.random() * .8 + .1) * Resources.getSystem().getDisplayMetrics().widthPixels);
        this.y = Resources.getSystem().getDisplayMetrics().heightPixels;
        this.color = BalloonColor.getRandomColor();
    }

    /**
     * Moves the balloon.
     * @return true if balloon has moved off the screen.
     */
    public boolean updatePos() {
        y -= speed;
        return y < -balloonHeight;
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    public BalloonColor color() {
        return color;
    }

    public static void setBalloonHeight(int balloonHeight) {
        Balloon.balloonHeight = balloonHeight;
    }
}
