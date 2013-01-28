/*
 * Copyright (C) 2011 Google Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package org.ros.rosjava_tutorial_pubsub;

import org.apache.commons.logging.Log;
import org.ros.message.MessageListener;
import org.ros.namespace.GraphName;
import org.ros.node.AbstractNodeMain;
import org.ros.node.ConnectedNode;
import org.ros.node.DefaultNodeMainExecutor;
import org.ros.node.NodeConfiguration;
import org.ros.node.NodeMain;
import org.ros.node.NodeMainExecutor;
import org.ros.node.topic.Subscriber;

import com.google.common.base.Preconditions;

import fr.inria.diagen.core.ServiceConfiguration;


/**
 * A simple {@link Subscriber} {@link NodeMain}.
 * 
 * @author damonkohler@google.com (Damon Kohler)
 */
public class ListenerKNX extends AbstractNodeMain {
	
	
  private  int presence = 0;


@Override
  public GraphName getDefaultNodeName() {
    return new GraphName("listenerKNX");
  }

  @Override
  public void onStart(ConnectedNode connectedNode) {
 //   final Log log = connectedNode.getLog();
    Subscriber<std_msgs.Int32> subscriber = connectedNode.newSubscriber("knx_chambre", "std_msgs/Int32");
    subscriber.addMessageListener(new MessageListener<std_msgs.Int32>() {
      @Override
      public void onNewMessage(std_msgs.Int32 message) {
      //  log.info("I heard: \"" + message.getFrameId() + "\"");
        System.out.println(message.getData());
        presence = message.getData();
  
        //int etat = message.getData();
   //     System.out.println("["+message.getSeq()+"]"+"  Capteur: "+data[3]+", Température: "+ data[11]+ ", Lumière: "+ data[13]);
     
      }
    });
  }
  
  public int getpresence(){
	  return presence;
  }

/*
  public static void main(String[] argv) throws Exception {
	  	  
	  	java.net.URI masterUri = java.net.URI.create("http://192.168.0.103:11311");
	    NodeConfiguration nodeConfiguration = NodeConfiguration.newPublic("127.0.0.1", masterUri);

	    ListenerKNX sub = new ListenerKNX();
	    NodeMain nodeMain = sub;
	    

	    Preconditions.checkState(nodeMain != null);
	    NodeMainExecutor nodeMainExecutor = DefaultNodeMainExecutor.newDefault();
	    nodeMainExecutor.execute(nodeMain, nodeConfiguration);
	  }
*/
  
}
