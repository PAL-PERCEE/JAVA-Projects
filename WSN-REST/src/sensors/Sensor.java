package sensors;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Sensor {
	
	
	
	private int capID;
	private String location;
	
	private String Type;
		
	
	private String temp;
	private String light;
	private String charge;
	private String presence;
	private String pression;
	private String door;
	
	
	
	private List<String> variables = new ArrayList<String>() ; 
	
	
	public Sensor(){
		this.capID = 0;
		this.Type = "";
	}
	
	
	public Sensor(int capID, String Type ){
		
		this.capID = capID;
		this.Type = Type;
		this.temp="";
		this.light="";
		this.charge="";
	//	this.variables = variables;
	}
	
	
	public int getID(){
		
		return this.capID;
		
	}
	
	public void setLocation(String location){
		
		this.location = location;
	}
	
	public String getlocation(){
		
		return this.location;
	}
	
	
	public String getTemp(){
		
		return temp;
	}
	
	public void setTemp(String temp){
		
		this.temp = temp;
		
	}
	
	public void setLight(String light){
		
		this.light = light;
		
	}
	
	public String getLight(){
		
		return this.light;
		
	}
	
	
	public void setCharge(String charge){
		
		this.charge = charge;
		
	}
	
	public String getCharge(){
		
		return this.charge;
		
	}
	
	public void setPresence(String presence){
		
		this.presence = presence;
	}
	
	public String getPresence(){
		
		return this.presence;		
	}
	
	
	public void setPression(String pression){
		
		this.pression = pression;
	}
	
	public String getPression(){
		
		return this.pression;		
	}
	
	public void setDoor(String door){
		
		this.door = door;
	}
	
	public String getDoor(){
		
		return this.door;		
	}
	
	
	public List<String> getVariablesList(){
		
		return this.variables;
	}
	
	
	public String AfficheVariablesList(){
		
		String List = "[ ";
		Iterator it = this.variables.iterator();

        while(it.hasNext()){
        	List+=(String)it.next()+"  ";
        }
		List +="]";
        return List;
	}
	
	public void addVariable(String data){
		
		if(variables.indexOf(data)<0)
		this.variables.add(data);
	}

}
