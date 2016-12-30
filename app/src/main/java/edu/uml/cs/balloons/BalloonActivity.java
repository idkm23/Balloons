package edu.uml.cs.balloons;

import android.app.Activity;
import android.os.Bundle;

public class BalloonActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new GameView(getApplicationContext()));
    }
}
