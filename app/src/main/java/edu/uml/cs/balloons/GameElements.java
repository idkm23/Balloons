package edu.uml.cs.balloons;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by csrobot on 12/30/16.
 */

public class GameElements {

    private double BALLOON_SPAWN_RATE = 0.01;
    private List<Balloon> balloonList;
    
    public GameElements() {
        balloonList = new ArrayList<Balloon>();
    }

    public void update() {
        for (Balloon balloon : balloonList) {
            balloon.updatePos();
        }

        if (BALLOON_SPAWN_RATE > Math.random()) {
            balloonList.add(new Balloon());
        }
    }

    public List<Balloon> getBalloonList() {
        return balloonList;
    }
}
