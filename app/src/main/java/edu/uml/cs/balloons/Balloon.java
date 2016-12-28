package edu.uml.cs.balloons;

import android.content.res.Resources;

/**
 * Created by csrobot on 12/28/16.
 */

public class Balloon {
    private static int balloonHeight;
    private int x;
    private int y = 0;
    private int speed = 1;

    public Balloon() {
        // x is between 0.1 to 0.9 of the screen width
        this.x = (int) ((Math.random() * .8 + .1) * Resources.getSystem().getDisplayMetrics().widthPixels);
        this.y = Resources.getSystem().getDisplayMetrics().heightPixels;
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

    public static void setBalloonHeight(int balloonHeight) {
        Balloon.balloonHeight = balloonHeight;
    }
}
