package fr.inria.phoenix.scenario.tutorial_phoenix.impl.context;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.distributed.lightsensor.LevelFromLightSensor;
import fr.inria.phoenix.diasuite.framework.distributed.lumierecalculee.AbstractLumiereCalculee;

public class LumiereCalculeeImpl extends AbstractLumiereCalculee {

	public LumiereCalculeeImpl(ServiceConfiguration serviceConfiguration) {
		super(serviceConfiguration);
	}
	@Override
	protected void postInitialize() {
		// TODO Auto-generated method stub
		super.postInitialize();
		discoverLightSensorForSubscribe.all().subscribeLevel();
	}
	
	@Override
	public Integer onLevelFromLightSensor(
			LevelFromLightSensor levelFromLightSensor,
			GetContextForLevelFromLightSensor getContext,
			DiscoverForLevelFromLightSensor discover) {
		// TODO Auto-generated method stub
			
		int average;
		average = (int)((levelFromLightSensor.value * 100) /3) ;
		System.out.println("#contexte: average= "+ average);
		return average;
	}

}
