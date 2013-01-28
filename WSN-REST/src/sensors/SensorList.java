package sensors;

import java.util.Iterator;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

/**
 * Resource which has only one representation.
 */
public class SensorList extends ServerResource {

	
   @Get
  
    public String getHtml() {
    	
	  // return "<html><body><h1>Hello, World!!</h1></body>  <a href=www.googleee.com> haaa </a></html>";
	   String reading="La liste des capteurs actifs\n";
	   Iterator<String> it = FirstStepsApplication.lsknx.sensorlist.iterator();
	   
	   while(it.hasNext()){
		   reading+=it.next();
	   }
	  
    
    		//reading+=FirstStepsApplication.lsknx.sensorlist.toString();
        return reading;
    }

}