package fr.inria.phoenix.scenario.tutorial_phoenix.impl.device;

import org.ros.node.DefaultNodeMainExecutor;
import org.ros.node.NodeConfiguration;
import org.ros.node.NodeMain;
import org.ros.node.NodeMainExecutor;
import org.ros.rosjava_tutorial_pubsub.Client;
import org.ros.rosjava_tutorial_pubsub.GetKNX;
import org.ros.rosjava_tutorial_pubsub.Listener;

import com.google.common.base.Preconditions;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.distributed.dimmablelight.AbstractDimmableLight;

public class DimmableLightImpl extends AbstractDimmableLight {

	public DimmableLightImpl(ServiceConfiguration serviceConfiguration,
			String id, String location, String user) {
		super(serviceConfiguration, id, location, user);
		// TODO Auto-generated constructor stub
	}

	private float lumintensity = 0;
	
	private Listener lsknx;
	
  	java.net.URI masterUri = java.net.URI.create("http://192.168.0.104:11311");
    NodeConfiguration nodeConfiguration = NodeConfiguration.newPublic("127.0.0.1", masterUri);

	public void setListener(Listener l) {
		this.lsknx = l;
	}
	
	@Override
	protected void on() throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	protected void off() throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	protected void setValue(Float value) throws Exception {
		// TODO Auto-generated method stub
		if (value < 0)
		lumintensity = value * (-1);
		else
		lumintensity = value;
	    Client setknx = new Client();
	    setknx.setlum(lumintensity);
	    setknx.setpresence(lsknx.getpresence());
	    NodeMain nodeMain1 = setknx;
	    
		//KNX_Interface.setKNXValue("VariationChambre", (int)lumintensity);
	   
	    Preconditions.checkState(nodeMain1 != null);
	    NodeMainExecutor nodeMainExecutor = DefaultNodeMainExecutor.newDefault();
	    nodeMainExecutor.execute(nodeMain1, nodeConfiguration);
	    
	//    nodeMainExecutor.shutdownNodeMain(nodeMain1);
		publishLevel(lumintensity);
		System.out.println("#Action: value seted "+ lumintensity+"\n");
		
	}


	@Override
	protected void increase() throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	protected void decrease() throws Exception {
		// TODO Auto-generated method stub

	}
	
	@Override
	protected void postInitialize() {
		// TODO Auto-generated method stub
		super.postInitialize();
		GetKNX getknx = new GetKNX();
		
		NodeMain nodeMain2 = getknx;
		   
	    Preconditions.checkState(nodeMain2 != null);
	    NodeMainExecutor nodeMainExecutor = DefaultNodeMainExecutor.newDefault();
	    nodeMainExecutor.execute(nodeMain2, nodeConfiguration);
	    
	  //  System.out.println(getknx.getlum());
	    try {
			Thread.sleep(800);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    lumintensity = getknx.getlum();
		//lumintensity = KNX_Interface.getKNXValue("EtatVarChambre");
		publishLevel(lumintensity);
		System.out.println("inisialiation dimable lamp "+lumintensity );
	}

	

}
