import org.restlet.Component;
import org.restlet.data.Protocol;
import org.ros.node.DefaultNodeMainExecutor;
import org.ros.node.NodeConfiguration;
import org.ros.node.NodeMain;
import org.ros.node.NodeMainExecutor;

import sensors.FirstStepsApplication;
import sensors.Listener;

import com.google.common.base.Preconditions;


public class FirstStepsMain {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		
	  	 java.net.URI masterUri = java.net.URI.create("http://127.0.0.1:11311");
	     NodeConfiguration nodeConfiguration = NodeConfiguration.newPublic("127.0.0.1", masterUri);

	      Listener sub = new Listener();
	      NodeMain nodeMain = sub;
		
		
	      Preconditions.checkState(nodeMain != null);
  	    NodeMainExecutor nodeMainExecutor = DefaultNodeMainExecutor.newDefault();
  	    nodeMainExecutor.execute(nodeMain, nodeConfiguration);
	      
	      
		  Component component = new Component();

	        // Add a new HTTP server listening on port 8111.
	        component.getServers().add(Protocol.HTTP, 8080);

	        // Attach the sample application.
	        component.getDefaultHost().attachDefault(new FirstStepsApplication(sub));

	        // Start the component.
	        component.start();
	}

}
