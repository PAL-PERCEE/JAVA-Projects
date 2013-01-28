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

import java.util.StringTokenizer;

import org.apache.xmlrpc.parser.FloatParser;
import org.ros.exception.RemoteException;
import org.ros.exception.RosRuntimeException;
import org.ros.exception.ServiceNotFoundException;
import org.ros.namespace.GraphName;
import org.ros.node.AbstractNodeMain;
import org.ros.node.ConnectedNode;
import org.ros.node.DefaultNodeMainExecutor;
import org.ros.node.NodeConfiguration;
import org.ros.node.NodeMain;
import org.ros.node.NodeMainExecutor;
import org.ros.node.service.ServiceClient;
import org.ros.node.service.ServiceResponseListener;

import com.google.common.base.Preconditions;

import fr.inria.phoenix.scenario.tutorial_phoenix.impl.device.DimmableLightImpl;

/**
 * A simple {@link ServiceClient} {@link NodeMain}.
 * 
 * @author damonkohler@google.com (Damon Kohler)
 */
public class GetKNX extends AbstractNodeMain {

  @Override
  public GraphName getDefaultNodeName() {
    return new GraphName("rosjava_tutorial_services/client");
  }
  
  private float lumintensity = 0;

  @Override
  public void onStart(final ConnectedNode connectedNode) {
    ServiceClient<knx_service.KnxSet.Request, knx_service.KnxSet.Response> serviceClient;
    try {
      serviceClient = connectedNode.newServiceClient("MADYNEGate/KnxServerNode/KnxAPI", knx_service.KnxSet._TYPE);
    } catch (ServiceNotFoundException e) {
      throw new RosRuntimeException(e);
    }
    final knx_service.KnxSet.Request request = serviceClient.newMessage();
    request.setAction("get");
    request.setTarget("1/5/3");
    //request.setValue((int)lumintensity);
    serviceClient.call(request, new ServiceResponseListener<knx_service.KnxSet.Response>() {
      @Override
      public void onSuccess(knx_service.KnxSet.Response response) {
    	  lumintensity= Integer.parseInt(response.getXml(), 16);
    	//  System.out.println(lumintensity);
        connectedNode.getLog().info(
            String.format("Action: %s %s => Etat %d", request.getAction(), request.getTarget(), request.getValue(),/*response.getEtat() */ Integer.parseInt(response.getXml(), 16) ));
    
      }

      
      
      @Override
      public void onFailure(RemoteException e) {
        throw new RosRuntimeException(e);
      }
    });
  }
  
  public float getlum(){
	 return lumintensity;
  }
  
  public static void main(String[] argv) throws Exception {
  	  
	  	java.net.URI masterUri = java.net.URI.create("http://192.168.0.104:11311");
	    NodeConfiguration nodeConfiguration = NodeConfiguration.newPublic("127.0.0.1", masterUri);

	    GetKNX setknx = new GetKNX();
	    NodeMain nodeMain = setknx;
	    

	    Preconditions.checkState(nodeMain != null);
	    NodeMainExecutor nodeMainExecutor = DefaultNodeMainExecutor.newDefault();
	    nodeMainExecutor.execute(nodeMain, nodeConfiguration);
	    
	  }
}
