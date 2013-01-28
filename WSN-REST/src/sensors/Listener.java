package sensors;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.ros.message.MessageListener;
import org.ros.namespace.GraphName;
import org.ros.node.AbstractNodeMain;
import org.ros.node.ConnectedNode;
import org.ros.node.NodeMain;
import org.ros.node.topic.Subscriber;




/**
 * A simple {@link Subscriber} {@link NodeMain}.
 * 
 * @author damonkohler@google.com (Damon Kohler)
 */
public class Listener extends AbstractNodeMain {
	
	  
	Map<Integer, Sensor> capteurs = new HashMap<Integer, Sensor>();
	List<String> sensordatalist = new ArrayList<String>() ;
		

	Vector<String> sensorlist = new Vector<String>();
	
	
	public void DiscoverSensors(final ConnectedNode connectedNode){
		
		
		 Subscriber<std_msgs.String> subscriber = connectedNode.newSubscriber("SensorIDs", "std_msgs/String");
		    subscriber.addMessageListener(new MessageListener<std_msgs.String>() {
		      @Override
		      public void onNewMessage(std_msgs.String message) {
		      //  log.info("I heard: \"" + message.getFrameId() + "\"");
		       // System.out.println(message.getSensvals());
		       
		      	if(sensorlist.size()==0){
		      		
		      		System.out.println("Détection d'un nouvaeu capteur: ID = "+message.getData());
		      		sensorlist.add(message.getData());
		      		AddSub(connectedNode, message.getData());
		      				      		
		      	}
		      	else {		
		      		
		      		if(!sensorlist.contains(message.getData())){
		      			System.out.println("Détection d'un nouvaeu capteur: ID = "+message.getData());
		      			sensorlist.add(message.getData());
		      			AddSub(connectedNode, message.getData());
		      		}		      				      		
		      	}
		        
		      }
		    });
		
		
	}
	
	
	
  @Override
  public GraphName getDefaultNodeName() {
    return new GraphName("rosjava_tutorial_pubsub/listener");
  }

  @Override
  public void onStart(ConnectedNode connectedNode) {

	  DiscoverSensors(connectedNode);
	  
  }
 
  
  
  public void AddSub(ConnectedNode connectedNode, String capID ){
	  
	  String topic = "MADYNESGate/ZigbeeNode/cap"+capID;
	  
	  Subscriber<PALGATE_msgs.ZigbeeFrame> subscriber = connectedNode.newSubscriber(topic, "PALGATE_msgs/ZigbeeFrame");
	    subscriber.addMessageListener(new MessageListener<PALGATE_msgs.ZigbeeFrame>() {
	      @Override
	      public void onNewMessage(PALGATE_msgs.ZigbeeFrame message) {
	      //  log.info("I heard: \"" + message.getFrameId() + "\"");
	       // System.out.println(message.getSensvals());
	       
	    		    	  
	        String delims = "[#]";
	        String[] data = message.getSensvals().split(delims);
	     //   System.out.println("["+message.getCapid()+"]"+"  Capteur: "+data[3]+", Température: "+ data[7]+ ", Lumière: "+ data[9]);
	        
	        int id = Integer.valueOf(message.getCapid());
	                
	        capteurs.put(id, new Sensor(id, "mush"));
	        
	        capteurs.get(id).setLocation(message.getCaplocation());
	        
	        String trame="Capteur "+message.getCapid()+" : "; 
	        
	        for (int i=0; i<data.length;i++){
	        	
	        	if (data[i].equals("Var01")){
	        		 capteurs.get(id).addVariable("Temp");
	        	 	 capteurs.get(id).setTemp(data[i+1]);
	        	 	 trame+="Température: "+data[i+1]+" ";
	        	}
	        	if (data[i].equals("Var02")){
	        		 capteurs.get(id).addVariable("Light");
	        	 	 capteurs.get(id).setLight(data[i+1]);
	        	 	trame+="Limière: "+data[i+1]+" ";
	        	}
	        	if (data[i].equals("Var08")){
	        		 capteurs.get(id).addVariable("Charge");
	        	 	 capteurs.get(id).setCharge(data[i+1]);
	        	 	trame+="Charge: "+data[i+1]+" ";
	        	}
	        	if (data[i].equals("Var10")){
	        		 capteurs.get(id).addVariable("Presence");
	        	 	 capteurs.get(id).setPresence(data[i+1]);
	        	 	trame+="Presence: "+data[i+1]+" ";
	        	}
	        	if (data[i].equals("Var04")){
	        		 capteurs.get(id).addVariable("Pression");
	        	 	 capteurs.get(id).setPression(data[i+1]);
	        	 	trame+="Pression: "+data[i+1]+" ";
	        	}
	         	if (data[i].equals("Var09")){
	        		 capteurs.get(id).addVariable("Door");
	        	 	 capteurs.get(id).setDoor(data[i+1]);
	        	 	trame+="Door: "+data[i+1]+" ";
	        	}
	        	
	        }
	     	        
	        System.out.println(trame);
	      	        
	      /*  capteurs.get(id).setTemp(data[7]);
	        capteurs.get(id).setLight(data[9]);
	        capteurs.get(id).setCharge(data[11]);*/

	 
	        
	        
	      }
	    });
	    
	  
	  
  }
  
  
  
  
}
