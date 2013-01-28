package fr.inria.phoenix.scenario.tutorial_phoenix.impl.context;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.distributed.lumierecalculee.LumiereCalculeeValue;
import fr.inria.phoenix.diasuite.framework.distributed.regulationindicator.AbstractRegulationIndicator;

public class RegulationIndicatorImpl extends AbstractRegulationIndicator {

	public RegulationIndicatorImpl(ServiceConfiguration serviceConfiguration) {
		super(serviceConfiguration);
	}
	
	@Override
	protected void postInitialize() {
		// TODO Auto-generated method stub
		super.postInitialize();
	}
	
	@Override
	public RegulationIndicatorValuePublishable onLumiereCalculee(
			LumiereCalculeeValue lumiereCalculee,
			GetContextForLumiereCalculee getContext,
			DiscoverForLumiereCalculee discover) {
		// TODO Auto-generated method stub
		
		float lumecart = 0;
		boolean publish = false;
		
		float level = discover.dimmableLights().all().anyOne().getLevel();
		float setpoint = discover.setPointConsoles().all().anyOne().getSetPoint();
		float average = lumiereCalculee.value();
		
		float ecart = setpoint - average;
		
		
		if(level>=255){
			System.out.println("#Context regulation: No publish ! Système atteint sa limite \n");
			return (new RegulationIndicatorValuePublishable(lumecart, publish));
		}

			
		
		
		
		
		
	//	float ecart = discover.setPointConsoles().all().anyOne().getSetPoint() - lumiereCalculee.value();
		
		if(ecart>40 && ecart<= 100){
			lumecart = (float)(discover.dimmableLights().all().anyOne().getLevel() + 70);
			
			if (lumecart<255)
			 publish = true;
			
			 System.out.println("#Context regulation: publish lumecart "+lumecart);
		}
		if(ecart>20 && ecart<40){
			lumecart = (float)(discover.dimmableLights().all().anyOne().getLevel() + 50);
			
			if (lumecart<255)
			 publish = true;
			
			 System.out.println("#Context regulation: publish lumecart "+lumecart);
		}
		else if (ecart>10 && ecart<20){
			lumecart = (float)(discover.dimmableLights().all().anyOne().getLevel() + 20);

			if (lumecart<255)
			 publish = true;
			
			 System.out.println("#Context regulation: publish lumecart "+lumecart);
		}
		else if (ecart>0 && ecart<10){
			lumecart = (float)(discover.dimmableLights().all().anyOne().getLevel() + 5);

			if (lumecart<255)
			 publish = true;
			
			 System.out.println("#Context regulation: publish lumecart "+lumecart);
		}
			
		/*if (lumiereCalculee.value() < discover.setPointConsoles().all().anyOne().getSetPoint())
		{
			lumecart = (float)(discover.dimmableLights().all().anyOne().getLevel() + 9);

			 publish = true;
			 System.out.println("#Context regulation: publish lumecart "+lumecart);
		}*/
		else if (lumiereCalculee.value() > discover.setPointConsoles().all().anyOne().getSetPoint())
		{
			lumecart = (float)(10 - discover.dimmableLights().all().anyOne().getLevel() );

			 publish = true;
			 System.out.println("#Context regulation: publish lumecart "+lumecart);
		}

		else System.out.println("#Context regulation: No publish \n");
		
		return (new RegulationIndicatorValuePublishable(lumecart, publish));
	}

}
