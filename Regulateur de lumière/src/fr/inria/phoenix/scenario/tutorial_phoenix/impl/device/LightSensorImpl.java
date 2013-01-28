package fr.inria.phoenix.scenario.tutorial_phoenix.impl.device;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.distributed.lightsensor.AbstractLightSensor;

import org.ros.rosjava_tutorial_pubsub.Listener;
import org.ros.node.AbstractNodeMain;

public class LightSensorImpl extends AbstractLightSensor {

	public LightSensorImpl(ServiceConfiguration serviceConfiguration,
			String id, String location, String user) {
		super(serviceConfiguration, id, location, user);
		// TODO Auto-generated constructor stub
		
	}
	
	float lumabiante;
	
	@Override
	protected void postInitialize() {
		// TODO Auto-generated method stub
		super.postInitialize();
		
		pubzigbee_Data();
		
	   
	}
	
	
	public void pubzigbee_Data() {

		// Simulation
		for (int i = 0; i < 4; i++) {

			try {
				lumabiante = i;
				publishLevel(lumabiante); // Appliquer le traitement
				System.out.println("#Source: Published lum "+lumabiante);								// par DiaSuite de la
													// nouvelle valeur
				Thread.sleep(2000); // Sleep
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	

}
