package fr.inria.phoenix.scenario.tutorial_phoenix.impl.controller;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.distributed.regulationindicator.RegulationIndicatorValue;
import fr.inria.phoenix.diasuite.framework.distributed.tutorial_phoenixcontroller.AbstractTutorial_phoenixController;

public class Tutorial_phoenixControllerImpl extends
		AbstractTutorial_phoenixController {


	public Tutorial_phoenixControllerImpl(
			ServiceConfiguration serviceConfiguration) {
		super(serviceConfiguration);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onRegulationIndicator(
			RegulationIndicatorValue regulationIndicator,
			GetContextForRegulationIndicator getContext,
			DiscoverForRegulationIndicator discover) {
		// TODO Auto-generated method stub
				
		discover.dimmableLights().all().anyOne().setValue(regulationIndicator.value());
		System.out.println("#controlleur: set valeur "+ regulationIndicator.value());

				
	}

}
