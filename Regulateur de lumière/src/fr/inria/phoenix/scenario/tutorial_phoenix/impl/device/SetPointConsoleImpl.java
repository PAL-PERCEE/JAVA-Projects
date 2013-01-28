package fr.inria.phoenix.scenario.tutorial_phoenix.impl.device;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.distributed.setpointconsole.AbstractSetPointConsole;

public class SetPointConsoleImpl extends AbstractSetPointConsole {

	

	public SetPointConsoleImpl(ServiceConfiguration serviceConfiguration) {
		super(serviceConfiguration);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void postInitialize() {
		// TODO Auto-generated method stub
		super.postInitialize();
		int reference = 70;
		publishSetPoint(reference);
		System.out.println("inisialisation de setpoint "+reference);
	}

	
}
