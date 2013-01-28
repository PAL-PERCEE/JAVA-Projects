package org.ros.rosjava_tutorial_pubsub;

import org.ros.node.DefaultNodeMainExecutor;
import org.ros.node.NodeConfiguration;
import org.ros.node.NodeMain;
import org.ros.node.NodeMainExecutor;

import com.google.common.base.Preconditions;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.distributed.lightsensor.AbstractLightSensor;


public class LightSensorImpl extends AbstractLightSensor {

	private Listener ls;
	
	public LightSensorImpl(ServiceConfiguration serviceConfiguration,
			String id, String location, String user) {
		super(serviceConfiguration, id, location, user);
		// TODO Auto-generated constructor stub
		
	}
	
	public void setListener(Listener l) {
		this.ls = l;
	}
	
	private float lumabiante = 0.0f;
	
	@Override
	protected void postInitialize() {
		// TODO Auto-generated method stub
		super.postInitialize();

		pubzigbee_Data();
	   
	}
	
	public void publishData(Float data){
		
		publishLevel(data);
		
	}
	
	
	public void pubzigbee_Data() {
		if (ls == null) return;
		// Simulation

		while(true){
			try {
				float lum = ls.getlum();
				if (Math.abs(lum - lumabiante) > 0.01f) {
					lumabiante = lum;
					publishLevel(lumabiante); // Appliquer le traitement
					System.out.println("#Source: Published lum "+lumabiante);								// par DiaSuite de la
					// nouvelle valeur
				}
				Thread.sleep(100); // Sleep
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	

}
