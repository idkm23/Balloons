package edu.uml.cs.balloons;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import org.ros.android.RosActivity;
import org.ros.node.NodeConfiguration;
import org.ros.node.NodeMainExecutor;

import java.io.IOException;
import java.net.URI;

public class MainActivity extends RosActivity {

    private TimeLeftSub timeLeftSub;

    protected MainActivity() {
        super("SomeNode", "SomeNode", URI.create("http://robot-lab1:11311"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void init(NodeMainExecutor nodeMainExecutor) {
        timeLeftSub = new TimeLeftSub();

        try {
            java.net.Socket socket = new java.net.Socket(getMasterUri().getHost(), getMasterUri().getPort());
            java.net.InetAddress local_network_address = socket.getLocalAddress();
            socket.close();
            NodeConfiguration nodeConfiguration =
                    NodeConfiguration.newPublic(local_network_address.getHostAddress(), getMasterUri());
            Log.d("Balloons", local_network_address.getHostAddress() + " " + getMasterUri());
            nodeMainExecutor.execute(timeLeftSub, nodeConfiguration);
        } catch (IOException e) {
            // Socket problem
            Log.e("Balloons", "socket error trying to get networking information from the master uri");
        }
    }

    public void onBeginButtonClick(View v) {
        Intent intent = new Intent(this, BalloonActivity.class);
        startActivity(intent);
    }
}
