package fr.inria.phoenix.scenario.tutorial_phoenix.impl.device;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;


public  class KNX_Interface {
	
	
	public static void createXMLFile( String texte)
	{
		//fname = "lamp.xml";
		try
		{

			FileWriter fw = new FileWriter("knx_file.xml", false);
			
			// le BufferedWriter output auquel on donne comme argument le FileWriter fw cree juste au dessus
			BufferedWriter output = new BufferedWriter(fw);
			
			//on marque dans le fichier ou plutot dans le BufferedWriter qui sert comme un tampon(stream)
			output.write(texte);
			//on peut utiliser plusieurs fois methode write
			
			output.flush();
			//ensuite flush envoie dans le fichier, ne pas oublier cette methode pour le BufferedWriter
			
			output.close();
			//et on le ferme
			//System.out.println("fichier créé");
		}
		catch(IOException ioe){
			System.out.print("Erreur : ");
			ioe.printStackTrace();
			}

	}
	
	public static String getXML_Ovalue()
	{
		String knxval = "";
		
		  SAXBuilder builder = new SAXBuilder();
		  File xmlFile = new File("knx_file.xml");

		  try {
	 
			Document document = (Document) builder.build(xmlFile);
			Element rootNode = document.getRootElement();
			List list = rootNode.getChildren("object");
	 
			for (int i = 0; i < list.size(); i++) {
	 
			   Element node = (Element) list.get(i);
			   knxval = node.getChildText("ovalue");
			//   System.out.println("First Name : " + node.getChildText("ovalue"));
			}
	 
		  } catch (IOException io) {
			System.out.println(io.getMessage());
		  } catch (JDOMException jdomex) {
			System.out.println(jdomex.getMessage());
		  }
		return knxval;
	}
	
	
	public static float getKNXValue(String target) {
				
		String get_cgi_api = "http://192.168.0.110/cgi/acquire.cgi?login=user&passwd=toto&target="+target+"&form=4&op=2&stamptrig=0";
	     
		try {  
	    	URL oracle = new URL(get_cgi_api);
	        BufferedReader in = new BufferedReader(new InputStreamReader(oracle.openStream()));

	        String inputLine;
	        while ((inputLine = in.readLine()) != null)
	        {
	        //	System.out.println(inputLine + " \n");
	       createXMLFile(inputLine);
	        in.close();
	        }
	      }
		catch (Exception e) {
	            System.err.println("Got an exception on executing URL! ");
	            System.err.println(e.getMessage());
	      }
		
	      String xmlVal = getXML_Ovalue();
	      
	           
	      return (Float.parseFloat(xmlVal));
	}
	
	public static void setKNXValue(String target, int value){
		
		 String send_cgi_api = "http://192.168.0.110/cgi/senddata.cgi?op=1&login=user&passwd=toto&target="+target+"&value="+value;
	    
		try {  
	    	URL oracle = new URL(send_cgi_api);
	        BufferedReader in = new BufferedReader(new InputStreamReader(oracle.openStream()));
	       
	       /* String inputLine;
	        while ((inputLine = in.readLine()) != null)
	        {
	       	System.out.println(inputLine + " \n");
	        in.close();
	        }*/
	        
	      }
	    catch (Exception e) {
	            System.err.println("Got an exception on executing URL! ");
	            System.err.println(e.getMessage());
	      }
	}
	
	
	
	  public static void main(String[] argv) throws Exception {
		 
	     
		  setKNXValue("VariationChambre", 40);

		 // System.out.println("Get value of EclairageCuisine = "+ getKNXValue("EtatLumCuisine"));
		  
		  
	  }
	
	
}
