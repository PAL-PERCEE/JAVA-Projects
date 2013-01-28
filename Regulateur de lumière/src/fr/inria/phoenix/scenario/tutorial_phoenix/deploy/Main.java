
package fr.inria.phoenix.scenario.tutorial_phoenix.deploy;
		
//import fr.inria.diagen.commlayer.rmi.RmiServiceConfiguration;
import fr.inria.diagen.commlayer.local.LocalServiceConfiguration;

import org.ros.node.DefaultNodeMainExecutor;
import org.ros.node.NodeConfiguration;
import org.ros.node.NodeMain;
import org.ros.node.NodeMainExecutor;
import org.ros.rosjava_tutorial_pubsub.LightSensorImpl;
import org.ros.rosjava_tutorial_pubsub.Listener;
import org.ros.rosjava_tutorial_pubsub.ListenerKNX;

import com.google.common.base.Preconditions;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.log.DiaLog;

import fr.inria.phoenix.diasuite.framework.distributed.deployment.MainDeploy;
import fr.inria.phoenix.diasuite.framework.distributed.lumierecalculee.AbstractLumiereCalculee;
import fr.inria.phoenix.diasuite.framework.distributed.regulationindicator.AbstractRegulationIndicator;
import fr.inria.phoenix.diasuite.framework.distributed.tutorial_phoenixcontroller.AbstractTutorial_phoenixController;
import fr.inria.phoenix.scenario.tutorial_phoenix.impl.context.LumiereCalculeeImpl;
import fr.inria.phoenix.scenario.tutorial_phoenix.impl.context.RegulationIndicatorImpl;
import fr.inria.phoenix.scenario.tutorial_phoenix.impl.controller.Tutorial_phoenixControllerImpl;
import fr.inria.phoenix.scenario.tutorial_phoenix.impl.device.DimmableLightImpl;
//import fr.inria.phoenix.scenario.tutorial_phoenix.impl.device.LightSensorImpl;
import fr.inria.phoenix.scenario.tutorial_phoenix.impl.device.SetPointConsoleImpl;

public class Main extends MainDeploy {
				
	public static void main(String[] args) {
		Main main = new Main();
		main.deployAll();
	}

	public Main() {
		//DiaLog.setLevel(DiaLog.INFO);
		// add devices with add(...) methods
		
	  	java.net.URI masterUri = java.net.URI.create("http://192.168.0.104:11311");
	    NodeConfiguration nodeConfiguration = NodeConfiguration.newPublic("127.0.0.1", masterUri);
	  //  NodeConfiguration nodeConfiguration = NodeConfiguration.newPrivate();
	    Listener sub = new Listener();
	    NodeMain nodeMain = sub;
	    
	    ListenerKNX knxpresence = new ListenerKNX();
	    NodeMain nodeMainknx = knxpresence;

	    Preconditions.checkState(nodeMain != null);
	    NodeMainExecutor nodeMainExecutor = DefaultNodeMainExecutor.newDefault();
	    nodeMainExecutor.execute(nodeMain, nodeConfiguration);
	    
	    Preconditions.checkState(nodeMainknx != null);
	    nodeMainExecutor.execute(nodeMainknx, nodeConfiguration);


	    LightSensorImpl ls = new LightSensorImpl(getServiceConfiguration("LightSensorImpl"), "capzigbee", "salon", null); 
		DimmableLightImpl lsknx= new DimmableLightImpl(getServiceConfiguration("DimmableLightIMPL"), "lampsalon", "salon", null);
		ls.setListener(sub);
		lsknx.setListener(sub);
		add(lsknx);
		add (ls);
		new SetPointConsoleImpl(getServiceConfiguration("setpoint")).initialize();
		
		
		new LumiereCalculeeImpl(getServiceConfiguration("pourcentcontext")).initialize();
		new RegulationIndicatorImpl(getServiceConfiguration("contextRegulation")).initialize();
		new Tutorial_phoenixControllerImpl(getServiceConfiguration("controlleur")).initialize();
		
	}
	
	@Override
	public ServiceConfiguration getServiceConfiguration(String name) {
		
		   LocalServiceConfiguration srvCfg = new LocalServiceConfiguration();
	       srvCfg.setName(name);
		   return srvCfg;
		 
	}

	@Override
	protected AbstractLumiereCalculee getLumiereCalculeeInstance() {
		// TODO Auto-generated method stub
		return new LumiereCalculeeImpl(getServiceConfiguration("LumiereCalculeeImpl"));
	}

	@Override
	protected AbstractRegulationIndicator getRegulationIndicatorInstance() {
		// TODO Auto-generated method stub
		return new RegulationIndicatorImpl(getServiceConfiguration("RegulationIndicatorImpl"));
	}

	@Override
	protected AbstractTutorial_phoenixController getTutorial_phoenixControllerInstance() {
		// TODO Auto-generated method stub
		return new Tutorial_phoenixControllerImpl(getServiceConfiguration("COntrolleur"));
	}
}
			