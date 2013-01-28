package sensors;

import java.util.Iterator;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.data.MediaType;
import org.restlet.representation.StringRepresentation;
import org.restlet.routing.Router;
import org.restlet.Request;
import org.restlet.Response;;

public class FirstStepsApplication extends Application {

	
	
	public static Listener lsknx;
	
	public FirstStepsApplication(Listener l){
		this.lsknx = l;
		
	}
	
	
    /**
     * Creates a root Restlet that will receive all incoming calls.
     */
    @Override
    public Restlet createInboundRoot() {
        // Create a router Restlet that routes each call to a
        // new instance of HelloWorldResource.
        Router router = new Router(getContext());

        // Defines routes
        router.attach("/sensor/{cap}/{reading}",SensorsValue.class);
  //      router.attach("/sensor/list",SensorList.class);
        
        Restlet mainpage = new Restlet() {
            @Override
            public void handle(Request request, Response response) {
                StringBuilder stringBuilder = new StringBuilder();
  
                Iterator<String> it = lsknx.sensorlist.iterator();
                
              
                
                
                stringBuilder.append("<html>");
                stringBuilder.append("<head><title>Hello Application " +
                        "Servlet Page</title>" +
                        "<meta http-equiv=\"refresh\" content=\"10\">"+
                        "</head>");
                stringBuilder.append("<body bgcolor=white>");
                stringBuilder.append("<table border=\"0\">");
                stringBuilder.append("<tr>");
                stringBuilder.append("<td>");
                stringBuilder.append("<h3>available Sensors calls</h3>");
                stringBuilder.append("<br>return sensor's readings<br>");
                stringBuilder.append("<ol>");
                
                
                while(it.hasNext()){
                	
                	String id = it.next();
                	 stringBuilder.append("<li><a href=\""+id+"/readings\">Capteur "+id+"</a> - Location: "+ SensorsValue.GetCapLocation(Integer.parseInt(id))+"</li><br>");
                }
             
  
                stringBuilder.append("</ol>");
                stringBuilder.append("</td>");
                stringBuilder.append("</tr>");
                stringBuilder.append("</table>");
                stringBuilder.append("</body>");
                stringBuilder.append("</html>");
  
                response.setEntity(new StringRepresentation(
                        stringBuilder.toString(),
                        MediaType.TEXT_HTML));
            }
        };
        router.attach("/sensor/list", mainpage);
        
        return router;
    }

       
    
}