package sensors;
import java.util.Iterator;
import java.util.List;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;


/**
 * Resource which has only one representation.
 */
public class SensorsValue extends ServerResource {

	   String capID;
	   String value;
	   
	
	 @Override
	    public void doInit() {
	        this.capID = (String) getRequestAttributes().get("cap");
	        this.value = (String) getRequestAttributes().get("reading");
	        
	      //  this.user = null; // Could be a lookup to a domain object.
	    }	
	
    @Get
    public String toString()  {
    	
    	
    	if(this.value.equals("readings")){
    		    	
    		String lum="Sensor "+this.capID+"\n\n"+"Location: "+ GetCapLocation(Integer.parseInt(capID)) +"\n";	
    		
    		List<String> variables = FirstStepsApplication.lsknx.capteurs.get(Integer.parseInt(capID)).getVariablesList();
    		
    		Iterator it = variables.iterator();

            while(it.hasNext()){
            	 String val = (String)it.next();
            	 
 	        	if(val.equals("Temp"))
 	        		lum+="Temp: "+FirstStepsApplication.lsknx.capteurs.get(Integer.parseInt(capID)).getTemp()+"\n";
 	        	else if (val.equals("Light"))
 	        	 	lum+="Light: "+FirstStepsApplication.lsknx.capteurs.get(Integer.parseInt(capID)).getLight()+"\n"; 	        	
 	        	else if (val.equals("Pression"))
 	        		lum+="pression: "+FirstStepsApplication.lsknx.capteurs.get(Integer.parseInt(capID)).getPression()+"\n";
 	        	else if (val.equals("Presence"))
 	        		lum+="Presence: "+FirstStepsApplication.lsknx.capteurs.get(Integer.parseInt(capID)).getPresence()+"\n"; 	        	
 	        	else if (val.equals("Charge"))
 	        		lum+="Charge: "+FirstStepsApplication.lsknx.capteurs.get(Integer.parseInt(capID)).getCharge()+"\n";
 	        	else if (val.equals("Door"))
 	        		lum+="Door: "+FirstStepsApplication.lsknx.capteurs.get(Integer.parseInt(capID)).getDoor()+"\n";
            }

        	/*lum="Sensor 45: Location Salon\n";
        	lum+="Light: "+FirstStepsApplication.lsknx.capteurs.get(Integer.parseInt(capID)).getLight()+"\n";
        	lum+="Temp: "+FirstStepsApplication.lsknx.capteurs.get(Integer.parseInt(capID)).getTemp()+"\n";
        	lum+="Charge: "+FirstStepsApplication.lsknx.capteurs.get(Integer.parseInt(capID)).getCharge()+"\n";*/
        	
        	lum+="Variables List: "+FirstStepsApplication.lsknx.capteurs.get(Integer.parseInt(capID)).AfficheVariablesList();
        	
    		return lum;
    	}
    	else if(this.value.equals("light"))
    		return "Data Luminosity: "+FirstStepsApplication.lsknx.capteurs.get(Integer.parseInt(capID)).getLight();
    	else if (this.value.equals("temp")) 	
    		return "Data Temperature: "+FirstStepsApplication.lsknx.capteurs.get(Integer.parseInt(capID)).getTemp();
    	else if (this.value.equals("charge")) 	
    		return "Data Battery level: "+FirstStepsApplication.lsknx.capteurs.get(Integer.parseInt(capID)).getCharge();
    	else if (this.value.equals("presence")) 	
    		return "Data Presence: "+FirstStepsApplication.lsknx.capteurs.get(Integer.parseInt(capID)).getPresence();
    	else if (this.value.equals("pression")) 	
    		return "Data Pression: "+FirstStepsApplication.lsknx.capteurs.get(Integer.parseInt(capID)).getPression();
    	else if (this.value.equals("door")) 	
    		return "Data Door: "+FirstStepsApplication.lsknx.capteurs.get(Integer.parseInt(capID)).getDoor();
    	else
        return ("Erreur ! Veuillez vérifier l'ID du capteur ou bien la variable du capteur \n\n" +
        		"For sensor list tape: http://localhost:8080/sensor/list\n" +
        		"For sensor data tape: http://localhost:8111/sensor/{capID}/readings");
    	
  
    }
    
    
    public static String GetCapLocation(int capID){
    	
    	if (FirstStepsApplication.lsknx.capteurs.get(capID).getlocation().equals("03"))
    		return "Séjour";
    	else if (FirstStepsApplication.lsknx.capteurs.get(capID).getlocation().equals("05"))
    		return "Chambre";
    	else if (FirstStepsApplication.lsknx.capteurs.get(capID).getlocation().equals("04"))
    		return "Salle de bain";
    	else if (FirstStepsApplication.lsknx.capteurs.get(capID).getlocation().equals("02"))
    		return "Salle à manger";
    	else if (FirstStepsApplication.lsknx.capteurs.get(capID).getlocation().equals("01"))
    		return "Cuisine";
    	
    	return "Locataion non définit";
    	
    }

}