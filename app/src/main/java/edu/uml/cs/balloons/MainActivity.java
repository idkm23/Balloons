package edu.uml.cs.balloons;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.ros.android.RosActivity;
import org.ros.node.NodeMainExecutor;

import java.net.URI;

public class MainActivity extends RosActivity {

    protected MainActivity() {
        super("SomeNode", "SomeNode", URI.create("http://129.63.16.221:11311"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void init(NodeMainExecutor nodeMainExecutor) {

    }
}
