package edu.uml.cs.balloons;

import android.util.Log;

import org.ros.message.MessageListener;
import org.ros.namespace.GraphName;
import org.ros.node.ConnectedNode;
import org.ros.node.Node;
import org.ros.node.NodeMain;
import org.ros.node.topic.Subscriber;

import std_msgs.Int32;

/**
 * Created by csrobot on 12/28/16.
 */

public class TimeLeftSub implements NodeMain {
    @Override
    public GraphName getDefaultNodeName() {
        return GraphName.of("time_sub");
    }

    @Override
    public void onStart(ConnectedNode connectedNode) {
        Subscriber<Int32> subscriber = connectedNode.newSubscriber("/balloons/time", std_msgs.Int32._TYPE);
        subscriber.addMessageListener(new MessageListener<Int32>() {
            @Override
            public void onNewMessage(std_msgs.Int32 message) {
                Log.d("myODG", "I heard: \"" + message.getData() + "\"");
            }
        });
    }

    @Override
    public void onShutdown(Node node) {}

    @Override
    public void onShutdownComplete(Node node) {}

    @Override
    public void onError(Node node, Throwable throwable) {}
}
