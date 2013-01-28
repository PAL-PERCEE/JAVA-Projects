/*
 * Copyright (C) 2011 Google Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package org.ros.rosjava_tutorial_pubsub;

import org.apache.commons.logging.Log;
import org.ros.message.MessageListener;
import org.ros.namespace.GraphName;
import org.ros.node.AbstractNodeMain;
import org.ros.node.ConnectedNode;
import org.ros.node.DefaultNodeMainExecutor;
import org.ros.node.NodeConfiguration;
import org.ros.node.NodeMain;
import org.ros.node.NodeMainExecutor;
import org.ros.node.topic.Subscriber;

import com.google.common.base.Preconditions;
import com.google.gdata.client.Query;
import com.google.gdata.client.calendar.CalendarQuery;
import com.google.gdata.client.calendar.CalendarService;
import com.google.gdata.data.DateTime;
import com.google.gdata.data.Link;
import com.google.gdata.data.PlainTextConstruct;
import com.google.gdata.data.batch.BatchOperationType;
import com.google.gdata.data.batch.BatchStatus;
import com.google.gdata.data.batch.BatchUtils;
import com.google.gdata.data.calendar.CalendarEntry;
import com.google.gdata.data.calendar.CalendarEventEntry;
import com.google.gdata.data.calendar.CalendarEventFeed;
import com.google.gdata.data.calendar.CalendarFeed;
import com.google.gdata.data.calendar.WebContent;
import com.google.gdata.data.extensions.ExtendedProperty;
import com.google.gdata.data.extensions.Recurrence;
import com.google.gdata.data.extensions.Reminder;
import com.google.gdata.data.extensions.When;
import com.google.gdata.data.extensions.Reminder.Method;
import com.google.gdata.util.ServiceException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;


/**
 * A simple {@link Subscriber} {@link NodeMain}.
 * 
 * @author damonkohler@google.com (Damon Kohler)
 */
public class Listener extends AbstractNodeMain {
	
	private static String PersonneName="Mdme Dubois ";
	
  public void Insertsql(String techno, String type, String description ){
	 
	  Connection laConnection;
	  Statement transmission;
	  
	  try{
		  
		Class.forName("com.mysql.jdbc.Driver");
		laConnection = DriverManager.getConnection("jdbc:mysql://192.168.0.12/actimetrie","xbeesink","rootroot");
		transmission = laConnection.createStatement();
	    transmission.executeUpdate("insert into activite (ID, Date, Techno, Type, Description) " +
	 		"values(NULL,now(),'"+techno+"','"+type+"','"+description+"')");
	    
		}catch(Exception e){
			
		System.out.println("Impossible de se connecter à la base de données");
		System.out.println("Problème at "+techno+" : "+ e.getMessage());
		
		}	  
  }
  
  
 private static CalendarService myService = new CalendarService("exampleCo-exampleApp-1");
  
  private static String userName = "mpigate.loria@gmail.com";
   private static String userPassword = "inrianancy";


  
//The base URL for a user's calendar metafeed (needs a username appended).
  private static final String METAFEED_URL_BASE = 
      "https://www.google.com/calendar/feeds/";

  // The string to add to the user's metafeedUrl to access the event feed for
  // their primary calendar.
  private static final String EVENT_FEED_URL_SUFFIX = "/private/full";

  // The URL for the metafeed of the specified user.
  // (e.g. http://www.google.com/feeds/calendar/jdoe@gmail.com)
  private static URL metafeedUrl = null;

  // The URL for the event feed of the specified user's primary calendar.
  // (e.g. http://www.googe.com/feeds/calendar/jdoe@gmail.com/private/full)
  private static URL eventFeedUrl = null;
  
  private static void creatURL(){
	    // Create the necessary URL objects.
	   try {
	      metafeedUrl = new URL(METAFEED_URL_BASE + userName);
	      eventFeedUrl = new URL(METAFEED_URL_BASE + userName+ EVENT_FEED_URL_SUFFIX);
	    } catch (MalformedURLException e) {
	      // Bad URL
	      System.err.println("Uh oh - you've got an invalid URL.");
	      e.printStackTrace();
	      return;
	    }
  }


  /**
   * Helper method to create either single-instance or recurring events. For
   * simplicity, some values that might normally be passed as parameters (such
   * as author name, email, etc.) are hard-coded.
   * 
   * @param service An authenticated CalendarService object.
   * @param eventTitle Title of the event to create.
   * @param eventContent Text content of the event to create.
   * @param recurData Recurrence value for the event, or null for
   *        single-instance events.
   * @param isQuickAdd True if eventContent should be interpreted as the text of
   *        a quick add event.
   * @param wc A WebContent object, or null if this is not a web content event.
   * @return The newly-created CalendarEventEntry.
   * @throws ServiceException If the service is unable to handle the request.
   * @throws IOException Error communicating with the server.
   */
  private static CalendarEventEntry createEvent(CalendarService service,
      String eventTitle, String eventContent, String recurData,
      boolean isQuickAdd, WebContent wc) throws ServiceException, IOException {
    CalendarEventEntry myEntry = new CalendarEventEntry();

    myEntry.setTitle(new PlainTextConstruct(eventTitle));
    myEntry.setContent(new PlainTextConstruct(eventContent));
    myEntry.setQuickAdd(isQuickAdd);
    myEntry.setWebContent(wc);

    // If a recurrence was requested, add it. Otherwise, set the
    // time (the current date and time) and duration (30 minutes)
    // of the event.
    if (recurData == null) {
      Calendar calendar = new GregorianCalendar();
      DateTime startTime = new DateTime(calendar.getTime(), TimeZone
          .getDefault());

      calendar.add(Calendar.MINUTE, 5);
      DateTime endTime = new DateTime(calendar.getTime(), 
          TimeZone.getDefault());

      When eventTimes = new When();
      eventTimes.setStartTime(startTime);
      eventTimes.setEndTime(endTime);
      myEntry.addTime(eventTimes);
    } else {
      Recurrence recur = new Recurrence();
      recur.setValue(recurData);
      myEntry.setRecurrence(recur);
    }

    // Send the request and receive the response:
    return service.insert(eventFeedUrl, myEntry);
  }

  /**
   * Creates a single-occurrence event.
   * 
   * @param service An authenticated CalendarService object.
   * @param eventTitle Title of the event to create.
   * @param eventContent Text content of the event to create.
   * @return The newly-created CalendarEventEntry.
   * @throws ServiceException If the service is unable to handle the request.
   * @throws IOException Error communicating with the server.
   */
  private static CalendarEventEntry createSingleEvent(CalendarService service,
      String eventTitle, String eventContent) throws ServiceException,
      IOException {
    return createEvent(service, eventTitle, eventContent, null, false, null);
  }

 	
	
  @Override
  public GraphName getDefaultNodeName() {
    return new GraphName("MADYNESGate/SQListener");
  }

  @Override
  public void onStart(ConnectedNode connectedNode) {
  
      
    //Capteur présence chambre
  Subscriber<std_msgs.Int32> pr_chambre = connectedNode.newSubscriber("knx_chambre", "std_msgs/Int32");
  pr_chambre.addMessageListener(new MessageListener<std_msgs.Int32>() {
    @Override
    public void onNewMessage(std_msgs.Int32 message) {
      int val = message.getData();    
      if(val == 1){
      Insertsql("Knx","Présence",PersonneName+"ENTRE dans sa chambre");
      
      //###########"Insert in google Agenda
      creatURL();
      
	    try {
		      myService.setUserCredentials(userName, userPassword);
		      // Demonstrate creating a single-occurrence event.
		      CalendarEventEntry singleEvent = createSingleEvent(myService,
		    		  PersonneName+"ENTRE dans sa chambre", "Techno: KNX, Type: Présence");
		      System.out.println("Successfully created event "
		          + singleEvent.getTitle().getPlainText());
		    } catch (IOException e) {
		      // Communications error
		      System.err.println("There was a problem communicating with the service.");
		      e.printStackTrace();
		    } catch (ServiceException e) {
		      // Server side error
		      System.err.println("The server had a problem handling your request.");
		      e.printStackTrace();
		    }
		    //###########"Agenda
      }
      else if(val==0){
      Insertsql("Knx","Présence",PersonneName+"SORT de sa chambre");
      creatURL();
      
	    try {
		      myService.setUserCredentials(userName, userPassword);

		      // Demonstrate creating a single-occurrence event.
		      CalendarEventEntry singleEvent = createSingleEvent(myService,
		    		  PersonneName+"SORT de sa chambre", "Techno: KNX, Type: Présence");
		      System.out.println("Successfully created event "
		          + singleEvent.getTitle().getPlainText());

		    } catch (IOException e) {
		      // Communications error
		      System.err.println("There was a problem communicating with the service.");
		      e.printStackTrace();
		    } catch (ServiceException e) {
		      // Server side error
		      System.err.println("The server had a problem handling your request.");
		      e.printStackTrace();
		    }
      }
    }
  });
  
  //Capteur présence cuisine
  Subscriber<std_msgs.Int32> pr_cuisine = connectedNode.newSubscriber("knx_cuisine", "std_msgs/Int32");
  pr_cuisine.addMessageListener(new MessageListener<std_msgs.Int32>() {
    @Override
    public void onNewMessage(std_msgs.Int32 message) {
      int val = message.getData();    
      if(val == 1){
      Insertsql("Knx","Présence",PersonneName+"SE PRESENTE dans la cuisine");
      
      //###########"Insert in google Agenda
      creatURL();
      
	    try {
		      myService.setUserCredentials(userName, userPassword);
		      // Demonstrate creating a single-occurrence event.
		      CalendarEventEntry singleEvent = createSingleEvent(myService,
		    		  PersonneName+"SE PRESENTE dans la cuisine", "Techno: Knx, Type: Présence");
		      System.out.println("Successfully created event "
		          + singleEvent.getTitle().getPlainText());
		    } catch (IOException e) {
		      // Communications error
		      System.err.println("There was a problem communicating with the service.");
		      e.printStackTrace();
		    } catch (ServiceException e) {
		      // Server side error
		      System.err.println("The server had a problem handling your request.");
		      e.printStackTrace();
		    }
		    //###########"Agenda
      
      }
      else if(val==0){
      Insertsql("Knx","Présence",PersonneName+"QUITTE la cuisine");
      
      //###########"Insert in google Agenda
      creatURL();
      
	    try {
		      myService.setUserCredentials(userName, userPassword);
		      // Demonstrate creating a single-occurrence event.
		      CalendarEventEntry singleEvent = createSingleEvent(myService,
		    		  PersonneName+"QUITTE la cuisine", "Techno: Knx, Type: Présence");
		      System.out.println("Successfully created event "
		          + singleEvent.getTitle().getPlainText());
		    } catch (IOException e) {
		      // Communications error
		      System.err.println("There was a problem communicating with the service.");
		      e.printStackTrace();
		    } catch (ServiceException e) {
		      // Server side error
		      System.err.println("The server had a problem handling your request.");
		      e.printStackTrace();
		    }
		    //###########"Agenda
      
      }
    }
  });
  
  //Capteur présence sdb
  Subscriber<std_msgs.Int32> pr_sdb = connectedNode.newSubscriber("knx_sdbdouche", "std_msgs/Int32");
  pr_sdb.addMessageListener(new MessageListener<std_msgs.Int32>() {
    @Override
    public void onNewMessage(std_msgs.Int32 message) {
      int val = message.getData();    
      if(val == 1){
      Insertsql("Knx","Présence",PersonneName+"ENTRE dans la salle de bain");
      
      //###########"Insert in google Agenda
      creatURL();
      
	    try {
		      myService.setUserCredentials(userName, userPassword);
		      // Demonstrate creating a single-occurrence event.
		      CalendarEventEntry singleEvent = createSingleEvent(myService,
		    		  PersonneName+"ENTRE dans la salle de bain", "Techno: Knx, Type: Présence");
		      System.out.println("Successfully created event "
		          + singleEvent.getTitle().getPlainText());
		    } catch (IOException e) {
		      // Communications error
		      System.err.println("There was a problem communicating with the service.");
		      e.printStackTrace();
		    } catch (ServiceException e) {
		      // Server side error
		      System.err.println("The server had a problem handling your request.");
		      e.printStackTrace();
		    }
		    //###########"Agenda
      
      }
      else if(val==0){
      Insertsql("Knx","Présence",PersonneName+"SORT de la salle de bain");
      
      //###########"Insert in google Agenda
      creatURL();
      
	    try {
		      myService.setUserCredentials(userName, userPassword);
		      // Demonstrate creating a single-occurrence event.
		      CalendarEventEntry singleEvent = createSingleEvent(myService,
		    		  PersonneName+"SORT de la salle de bain", "Techno: Knx, Type: Présence");
		      System.out.println("Successfully created event "
		          + singleEvent.getTitle().getPlainText());
		    } catch (IOException e) {
		      // Communications error
		      System.err.println("There was a problem communicating with the service.");
		      e.printStackTrace();
		    } catch (ServiceException e) {
		      // Server side error
		      System.err.println("The server had a problem handling your request.");
		      e.printStackTrace();
		    }
		    //###########"Agenda
      
      }
    }
  });
  
  //Capteur présence sam
  Subscriber<std_msgs.Int32> pr_sam = connectedNode.newSubscriber("knx_test", "std_msgs/Int32");
  pr_sam.addMessageListener(new MessageListener<std_msgs.Int32>() {
    @Override
    public void onNewMessage(std_msgs.Int32 message) {
      int val = message.getData();    
      if(val == 1){
      Insertsql("Knx","Présence",PersonneName+"SE PRESENTE dans la salle à manger");
      
      //###########"Insert in google Agenda
      creatURL();
      
	    try {
		      myService.setUserCredentials(userName, userPassword);
		      // Demonstrate creating a single-occurrence event.
		      CalendarEventEntry singleEvent = createSingleEvent(myService,
		    		  PersonneName+"SE PRESENTE dans la salle à manger", "Techno: Knx, Type: Présence");
		      System.out.println("Successfully created event "
		          + singleEvent.getTitle().getPlainText());
		    } catch (IOException e) {
		      // Communications error
		      System.err.println("There was a problem communicating with the service.");
		      e.printStackTrace();
		    } catch (ServiceException e) {
		      // Server side error
		      System.err.println("The server had a problem handling your request.");
		      e.printStackTrace();
		    }
		    //###########"Agenda
      
      }
      else if(val==0){
      Insertsql("Knx","Présence",PersonneName+"QUITTE la salle à manger");
      
      //###########"Insert in google Agenda
      creatURL();
      
	    try {
		      myService.setUserCredentials(userName, userPassword);
		      // Demonstrate creating a single-occurrence event.
		      CalendarEventEntry singleEvent = createSingleEvent(myService,
		    		  PersonneName+"QUITTE la salle à manger", "Techno: Knx, Type: Présence");
		      System.out.println("Successfully created event "
		          + singleEvent.getTitle().getPlainText());
		    } catch (IOException e) {
		      // Communications error
		      System.err.println("There was a problem communicating with the service.");
		      e.printStackTrace();
		    } catch (ServiceException e) {
		      // Server side error
		      System.err.println("The server had a problem handling your request.");
		      e.printStackTrace();
		    }
		    //###########"Agenda
      
      }
    }
  });
  
  //Capteur lumière chambre
  Subscriber<std_msgs.Int32> E_chambre = connectedNode.newSubscriber("knx_E_chambre", "std_msgs/Int32");
  E_chambre.addMessageListener(new MessageListener<std_msgs.Int32>() {
    @Override
    public void onNewMessage(std_msgs.Int32 message) {
      int val = message.getData();    
      if(val == 1){
      Insertsql("Knx","Eclairage",PersonneName+"ALLUME la lumière de la chambre");
      
      //###########"Insert in google Agenda
      creatURL();
      
	    try {
		      myService.setUserCredentials(userName, userPassword);
		      // Demonstrate creating a single-occurrence event.
		      CalendarEventEntry singleEvent = createSingleEvent(myService,
		    		  PersonneName+"ALLUME la lumière de la chambre", "Techno: Knx, Type: Présence");
		      System.out.println("Successfully created event "
		          + singleEvent.getTitle().getPlainText());
		    } catch (IOException e) {
		      // Communications error
		      System.err.println("There was a problem communicating with the service.");
		      e.printStackTrace();
		    } catch (ServiceException e) {
		      // Server side error
		      System.err.println("The server had a problem handling your request.");
		      e.printStackTrace();
		    }
		    //###########"Agenda
      
      }
      else if(val==0){
      Insertsql("Knx","Eclairage",PersonneName+"ETEINT la lumière de la chambre");
      
      //###########"Insert in google Agenda
      creatURL();
      
	    try {
		      myService.setUserCredentials(userName, userPassword);
		      // Demonstrate creating a single-occurrence event.
		      CalendarEventEntry singleEvent = createSingleEvent(myService,
		    		  PersonneName+"ETEINT la lumière de la chambre", "Techno: Knx, Type: Présence");
		      System.out.println("Successfully created event "
		          + singleEvent.getTitle().getPlainText());
		    } catch (IOException e) {
		      // Communications error
		      System.err.println("There was a problem communicating with the service.");
		      e.printStackTrace();
		    } catch (ServiceException e) {
		      // Server side error
		      System.err.println("The server had a problem handling your request.");
		      e.printStackTrace();
		    }
		    //###########"Agenda
      
      }
    }
  });
  
  //Capteur lumière cuisine
  Subscriber<std_msgs.Int32> E_cuisine = connectedNode.newSubscriber("knx_E_cuisine", "std_msgs/Int32");
  E_cuisine.addMessageListener(new MessageListener<std_msgs.Int32>() {
    @Override
    public void onNewMessage(std_msgs.Int32 message) {
      int val = message.getData();    
      if(val == 1){
      Insertsql("Knx","Eclairage",PersonneName+"ALLUME la lumière de la cuisine");
      
      //###########"Insert in google Agenda
      creatURL();
      
	    try {
		      myService.setUserCredentials(userName, userPassword);
		      // Demonstrate creating a single-occurrence event.
		      CalendarEventEntry singleEvent = createSingleEvent(myService,
		    		  PersonneName+"ALLUME la lumière de la cuisine", "Techno: Knx, Type: Présence");
		      System.out.println("Successfully created event "
		          + singleEvent.getTitle().getPlainText());
		    } catch (IOException e) {
		      // Communications error
		      System.err.println("There was a problem communicating with the service.");
		      e.printStackTrace();
		    } catch (ServiceException e) {
		      // Server side error
		      System.err.println("The server had a problem handling your request.");
		      e.printStackTrace();
		    }
		    //###########"Agenda
      
      }
      else if(val==0){
      Insertsql("Knx","Eclairage",PersonneName+"ETEINT la lumière de la cuisine");
      
      //###########"Insert in google Agenda
      creatURL();
      
	    try {
		      myService.setUserCredentials(userName, userPassword);
		      // Demonstrate creating a single-occurrence event.
		      CalendarEventEntry singleEvent = createSingleEvent(myService,
		    		  PersonneName+"ETEINT la lumière de la cuisine", "Techno: Knx, Type: Présence");
		      System.out.println("Successfully created event "
		          + singleEvent.getTitle().getPlainText());
		    } catch (IOException e) {
		      // Communications error
		      System.err.println("There was a problem communicating with the service.");
		      e.printStackTrace();
		    } catch (ServiceException e) {
		      // Server side error
		      System.err.println("The server had a problem handling your request.");
		      e.printStackTrace();
		    }
		    //###########"Agenda
      
      }
    }
  });
  
  //Capteur lumière sdb
  Subscriber<std_msgs.Int32> E_sdb= connectedNode.newSubscriber("knx_E_SDB", "std_msgs/Int32");
  E_sdb.addMessageListener(new MessageListener<std_msgs.Int32>() {
    @Override
    public void onNewMessage(std_msgs.Int32 message) {
      int val = message.getData();    
      if(val == 1){
      Insertsql("Knx","Eclairage",PersonneName+"ALLUME la lumière de la salle de bain");
      
      //###########"Insert in google Agenda
      creatURL();
      
	    try {
		      myService.setUserCredentials(userName, userPassword);
		      // Demonstrate creating a single-occurrence event.
		      CalendarEventEntry singleEvent = createSingleEvent(myService,
		    		  PersonneName+"ALLUME la lumière de la salle de bain", "Techno: Knx, Type: Présence");
		      System.out.println("Successfully created event "
		          + singleEvent.getTitle().getPlainText());
		    } catch (IOException e) {
		      // Communications error
		      System.err.println("There was a problem communicating with the service.");
		      e.printStackTrace();
		    } catch (ServiceException e) {
		      // Server side error
		      System.err.println("The server had a problem handling your request.");
		      e.printStackTrace();
		    }
		    //###########"Agenda
      
      }
      else if(val==0){
      Insertsql("Knx","Eclairage",PersonneName+"ETEINT la lumière de la salle de bain");
      
      //###########"Insert in google Agenda
      creatURL();
      
	    try {
		      myService.setUserCredentials(userName, userPassword);
		      // Demonstrate creating a single-occurrence event.
		      CalendarEventEntry singleEvent = createSingleEvent(myService,
		    		  PersonneName+"ETEINT la lumière de la salle de bain", "Techno: Knx, Type: Présence");
		      System.out.println("Successfully created event "
		          + singleEvent.getTitle().getPlainText());
		    } catch (IOException e) {
		      // Communications error
		      System.err.println("There was a problem communicating with the service.");
		      e.printStackTrace();
		    } catch (ServiceException e) {
		      // Server side error
		      System.err.println("The server had a problem handling your request.");
		      e.printStackTrace();
		    }
		    //###########"Agenda
      
      }
    }
  });
  
  //Capteur lumière salon
  Subscriber<std_msgs.Int32> E_salon= connectedNode.newSubscriber("knx_E_salon", "std_msgs/Int32");
  E_salon.addMessageListener(new MessageListener<std_msgs.Int32>() {
    @Override
    public void onNewMessage(std_msgs.Int32 message) {
      int val = message.getData();    
      if(val == 1){
      Insertsql("Knx","Eclairage",PersonneName+"ALLUME la lumière du salon");
      
      //###########"Insert in google Agenda
      creatURL();
      
	    try {
		      myService.setUserCredentials(userName, userPassword);
		      // Demonstrate creating a single-occurrence event.
		      CalendarEventEntry singleEvent = createSingleEvent(myService,
		    		  PersonneName+"ALLUME la lumière du salon", "Techno: Knx, Type: Présence");
		      System.out.println("Successfully created event "
		          + singleEvent.getTitle().getPlainText());
		    } catch (IOException e) {
		      // Communications error
		      System.err.println("There was a problem communicating with the service.");
		      e.printStackTrace();
		    } catch (ServiceException e) {
		      // Server side error
		      System.err.println("The server had a problem handling your request.");
		      e.printStackTrace();
		    }
		    //###########"Agenda
      
      }
      else if(val==0){
      Insertsql("Knx","Eclairage",PersonneName+"ETEINT la lumière du salon");
      
      //###########"Insert in google Agenda
      creatURL();
      
	    try {
		      myService.setUserCredentials(userName, userPassword);
		      // Demonstrate creating a single-occurrence event.
		      CalendarEventEntry singleEvent = createSingleEvent(myService,
		    		  PersonneName+"ETEINT la lumière du salon", "Techno: Knx, Type: Eclairage");
		      System.out.println("Successfully created event "
		          + singleEvent.getTitle().getPlainText());
		    } catch (IOException e) {
		      // Communications error
		      System.err.println("There was a problem communicating with the service.");
		      e.printStackTrace();
		    } catch (ServiceException e) {
		      // Server side error
		      System.err.println("The server had a problem handling your request.");
		      e.printStackTrace();
		    }
		    //###########"Agenda
      
      }
    }
  });
  
 
  //Capteur lumière salon
  Subscriber<std_msgs.Int32> E_sam= connectedNode.newSubscriber("knx_E_SAM", "std_msgs/Int32");
  E_sam.addMessageListener(new MessageListener<std_msgs.Int32>() {
    @Override
    public void onNewMessage(std_msgs.Int32 message) {
      int val = message.getData();    
      if(val == 1){
      Insertsql("Knx","Eclairage",PersonneName+"ALLUME la lumière de la salle à manger");
      
      //###########"Insert in google Agenda
      creatURL();
      
	    try {
		      myService.setUserCredentials(userName, userPassword);
		      // Demonstrate creating a single-occurrence event.
		      CalendarEventEntry singleEvent = createSingleEvent(myService,
		    		  PersonneName+"ALLUME la lumière de la salle à manger", "Techno: Knx, Type: Eclairage");
		      System.out.println("Successfully created event "
		          + singleEvent.getTitle().getPlainText());
		    } catch (IOException e) {
		      // Communications error
		      System.err.println("There was a problem communicating with the service.");
		      e.printStackTrace();
		    } catch (ServiceException e) {
		      // Server side error
		      System.err.println("The server had a problem handling your request.");
		      e.printStackTrace();
		    }
		    //###########"Agenda
      
      }
      else if(val==0){
      Insertsql("Knx","Eclairage",PersonneName+"ETEINT la lumière de la salle à manger");
      
      //###########"Insert in google Agenda
      creatURL();
      
	    try {
		      myService.setUserCredentials(userName, userPassword);
		      // Demonstrate creating a single-occurrence event.
		      CalendarEventEntry singleEvent = createSingleEvent(myService,
		    		  PersonneName+"ETEINT la lumière de la salle à manger", "Techno: Knx, Type: Eclairage");
		      System.out.println("Successfully created event "
		          + singleEvent.getTitle().getPlainText());
		    } catch (IOException e) {
		      // Communications error
		      System.err.println("There was a problem communicating with the service.");
		      e.printStackTrace();
		    } catch (ServiceException e) {
		      // Server side error
		      System.err.println("The server had a problem handling your request.");
		      e.printStackTrace();
		    }
		    //###########"Agenda
      
      }
    }
  });
  
  //Capteur volet roulant salon
  Subscriber<std_msgs.Int32> volet_salon= connectedNode.newSubscriber("knx_volet_salon", "std_msgs/Int32");
  volet_salon.addMessageListener(new MessageListener<std_msgs.Int32>() {
    @Override
    public void onNewMessage(std_msgs.Int32 message) {
      int val = message.getData();    
      if(val == 1){
      Insertsql("Knx","Action",PersonneName+"OUVRE le volet roulant roulant du salon");
      
      //###########"Insert in google Agenda
      creatURL();
      
	    try {
		      myService.setUserCredentials(userName, userPassword);
		      // Demonstrate creating a single-occurrence event.
		      CalendarEventEntry singleEvent = createSingleEvent(myService,
		    		  PersonneName+"OUVRE le volet roulant roulant du salon", "Techno: Knx, Type: Action");
		      System.out.println("Successfully created event "
		          + singleEvent.getTitle().getPlainText());
		    } catch (IOException e) {
		      // Communications error
		      System.err.println("There was a problem communicating with the service.");
		      e.printStackTrace();
		    } catch (ServiceException e) {
		      // Server side error
		      System.err.println("The server had a problem handling your request.");
		      e.printStackTrace();
		    }
		    //###########"Agenda
      
      }
      else if(val==2){
      Insertsql("Knx","Action",PersonneName+"FERME le volet roulant du salon");
      
      //###########"Insert in google Agenda
      creatURL();
      
	    try {
		      myService.setUserCredentials(userName, userPassword);
		      // Demonstrate creating a single-occurrence event.
		      CalendarEventEntry singleEvent = createSingleEvent(myService,
		    		  PersonneName+"FERME le volet roulant du salon", "Techno: Knx, Type: Action");
		      System.out.println("Successfully created event "
		          + singleEvent.getTitle().getPlainText());
		    } catch (IOException e) {
		      // Communications error
		      System.err.println("There was a problem communicating with the service.");
		      e.printStackTrace();
		    } catch (ServiceException e) {
		      // Server side error
		      System.err.println("The server had a problem handling your request.");
		      e.printStackTrace();
		    }
		    //###########"Agenda
      
      }
    }
  });
    
  //Capteur volet roulant chambre
  Subscriber<std_msgs.Int32> volet_chambre= connectedNode.newSubscriber("knx_volet_chambre", "std_msgs/Int32");
  volet_chambre.addMessageListener(new MessageListener<std_msgs.Int32>() {
    @Override
    public void onNewMessage(std_msgs.Int32 message) {
      int val = message.getData();    
      if(val == 1){
      Insertsql("Knx","Action",PersonneName+"OUVRE le volet roulant de la chambre");
      
      //###########"Insert in google Agenda
      creatURL();
      
	    try {
		      myService.setUserCredentials(userName, userPassword);
		      // Demonstrate creating a single-occurrence event.
		      CalendarEventEntry singleEvent = createSingleEvent(myService,
		    		  PersonneName+"OUVRE le volet roulant roulant de la chambre", "Techno: Knx, Type: Action");
		      System.out.println("Successfully created event "
		          + singleEvent.getTitle().getPlainText());
		    } catch (IOException e) {
		      // Communications error
		      System.err.println("There was a problem communicating with the service.");
		      e.printStackTrace();
		    } catch (ServiceException e) {
		      // Server side error
		      System.err.println("The server had a problem handling your request.");
		      e.printStackTrace();
		    }
		    //###########"Agenda
      
      }
      else if(val==2){
      Insertsql("Knx","Action",PersonneName+"FERME le volet roulant de la chambre");
      
      //###########"Insert in google Agenda
      creatURL();
      
	    try {
		      myService.setUserCredentials(userName, userPassword);
		      // Demonstrate creating a single-occurrence event.
		      CalendarEventEntry singleEvent = createSingleEvent(myService,
		    		  PersonneName+"FERME le volet roulant de la chambre", "Techno: Knx, Type: Action");
		      System.out.println("Successfully created event "
		          + singleEvent.getTitle().getPlainText());
		    } catch (IOException e) {
		      // Communications error
		      System.err.println("There was a problem communicating with the service.");
		      e.printStackTrace();
		    } catch (ServiceException e) {
		      // Server side error
		      System.err.println("The server had a problem handling your request.");
		      e.printStackTrace();
		    }
		    //###########"Agenda
      
      }
    }
  });
  
  //Capteur Porte WC 24/04
Subscriber<PALGATE_msgs.ZigbeeFrame> door_wc = connectedNode.newSubscriber("MADYNESGate/ZigbeeNode/cap24", "PALGATE_msgs/ZigbeeFrame");
door_wc.addMessageListener(new MessageListener<PALGATE_msgs.ZigbeeFrame>() {
  @Override
  public void onNewMessage(PALGATE_msgs.ZigbeeFrame message) {
   // System.out.println(message.getSensvals());
    String delims = "[#]";
    String[] data = message.getSensvals().split(delims);    
    System.out.println(data[1]);
    if(data[1].equals("1")){
    Insertsql("Zigbee","Action",PersonneName+"OUVRE la porte de la Salle de Bain");
    
    //###########"Insert in google Agenda
    creatURL();
    
	    try {
		      myService.setUserCredentials(userName, userPassword);
		      // Demonstrate creating a single-occurrence event.
		      CalendarEventEntry singleEvent = createSingleEvent(myService,
		    		  PersonneName+"OUVRE la porte de la Salle de Bain", "Techno: Zigbee, Type: Action");
		      System.out.println("Successfully created event "
		          + singleEvent.getTitle().getPlainText());
		    } catch (IOException e) {
		      // Communications error
		      System.err.println("There was a problem communicating with the service.");
		      e.printStackTrace();
		    } catch (ServiceException e) {
		      // Server side error
		      System.err.println("The server had a problem handling your request.");
		      e.printStackTrace();
		    }
		    //###########"Agenda
    
    }
    else if(data[1].equals("0")){
    Insertsql("Zigbee","Action",PersonneName+"FERME la porte de la Salle de Bain");
    
    //###########"Insert in google Agenda
    creatURL();
    
	    try {
		      myService.setUserCredentials(userName, userPassword);
		      // Demonstrate creating a single-occurrence event.
		      CalendarEventEntry singleEvent = createSingleEvent(myService,
		    		  PersonneName+"FERME la porte de la Salle de Bain", "Techno: Zigbee, Type: Action");
		      System.out.println("Successfully created event "
		          + singleEvent.getTitle().getPlainText());
		    } catch (IOException e) {
		      // Communications error
		      System.err.println("There was a problem communicating with the service.");
		      e.printStackTrace();
		    } catch (ServiceException e) {
		      // Server side error
		      System.err.println("The server had a problem handling your request.");
		      e.printStackTrace();
		    }
		    //###########"Agenda
    
    }
  }
});

// Capteur de d'ouverture porte chambre 25/05
// Var09#0#Var08#54%
Subscriber<PALGATE_msgs.ZigbeeFrame> porte_chambre = connectedNode.newSubscriber("MADYNESGate/ZigbeeNode/cap25", "PALGATE_msgs/ZigbeeFrame");
porte_chambre.addMessageListener(new MessageListener<PALGATE_msgs.ZigbeeFrame>() {
  @Override
  public void onNewMessage(PALGATE_msgs.ZigbeeFrame message) {
  //  System.out.println(message.getSensvals());
    String delims = "[#]";
    String[] data = message.getSensvals().split(delims);     
    if(data[1].equals("1")){
        Insertsql("Zigbee","Action",PersonneName+"OUVRE la porte de la chambre");
        
        //###########"Insert in google Agenda
        creatURL();
        
    	    try {
    		      myService.setUserCredentials(userName, userPassword);
    		      // Demonstrate creating a single-occurrence event.
    		      CalendarEventEntry singleEvent = createSingleEvent(myService,
    		    		  PersonneName+"OUVRE la porte de la chambre", "Techno: Zigbee, Type: Action");
    		      System.out.println("Successfully created event "
    		          + singleEvent.getTitle().getPlainText());
    		    } catch (IOException e) {
    		      // Communications error
    		      System.err.println("There was a problem communicating with the service.");
    		      e.printStackTrace();
    		    } catch (ServiceException e) {
    		      // Server side error
    		      System.err.println("The server had a problem handling your request.");
    		      e.printStackTrace();
    		    }
    		    //###########"Agenda
        
        }
        else if(data[1].equals("0")){
        Insertsql("Zigbee","Action",PersonneName+"FERME la porte de la chambre");
        
        //###########"Insert in google Agenda
        creatURL();
        
    	    try {
    		      myService.setUserCredentials(userName, userPassword);
    		      // Demonstrate creating a single-occurrence event.
    		      CalendarEventEntry singleEvent = createSingleEvent(myService,
    		    		  PersonneName+"FERME la porte de la chambre", "Techno: Zigbee, Type: Action");
    		      System.out.println("Successfully created event "
    		          + singleEvent.getTitle().getPlainText());
    		    } catch (IOException e) {
    		      // Communications error
    		      System.err.println("There was a problem communicating with the service.");
    		      e.printStackTrace();
    		    } catch (ServiceException e) {
    		      // Server side error
    		      System.err.println("The server had a problem handling your request.");
    		      e.printStackTrace();
    		    }
    		    //###########"Agenda
        
        }
  }
});

// Capteur de pression chaise salon_1 13/03
// Var04#0#Var08#42%
Subscriber<PALGATE_msgs.ZigbeeFrame> pression_chaise1 = connectedNode.newSubscriber("MADYNESGate/ZigbeeNode/cap13", "PALGATE_msgs/ZigbeeFrame");
pression_chaise1.addMessageListener(new MessageListener<PALGATE_msgs.ZigbeeFrame>() {
  @Override
  public void onNewMessage(PALGATE_msgs.ZigbeeFrame message) {
  //  System.out.println(message.getSensvals());
    String delims = "[#]";
    String[] data = message.getSensvals().split(delims);     
    if(data[1].equals("1")){
        Insertsql("Zigbee","Présence",PersonneName+"S ASSOIE sur le canapé 1 du salon");
        
        //###########"Insert in google Agenda
        creatURL();
        
    	    try {
    		      myService.setUserCredentials(userName, userPassword);
    		      // Demonstrate creating a single-occurrence event.
    		      CalendarEventEntry singleEvent = createSingleEvent(myService,
    		    		  PersonneName+"S ASSOIE sur le canapé 1 du salon", "Techno: Zigbee, Type: Action");
    		      System.out.println("Successfully created event "
    		          + singleEvent.getTitle().getPlainText());
    		    } catch (IOException e) {
    		      // Communications error
    		      System.err.println("There was a problem communicating with the service.");
    		      e.printStackTrace();
    		    } catch (ServiceException e) {
    		      // Server side error
    		      System.err.println("The server had a problem handling your request.");
    		      e.printStackTrace();
    		    }
    		    //###########"Agenda
        
        }
        else if(data[1].equals("0")){
        Insertsql("Zigbee","Présence",PersonneName+"SE LEVE du canapé 1 du salon");
        
        //###########"Insert in google Agenda
        creatURL();
        
    	    try {
    		      myService.setUserCredentials(userName, userPassword);
    		      // Demonstrate creating a single-occurrence event.
    		      CalendarEventEntry singleEvent = createSingleEvent(myService,
    		    		  PersonneName+"SE LEVE du canapé 1 du salon", "Techno: Zigbee, Type: Action");
    		      System.out.println("Successfully created event "
    		          + singleEvent.getTitle().getPlainText());
    		    } catch (IOException e) {
    		      // Communications error
    		      System.err.println("There was a problem communicating with the service.");
    		      e.printStackTrace();
    		    } catch (ServiceException e) {
    		      // Server side error
    		      System.err.println("The server had a problem handling your request.");
    		      e.printStackTrace();
    		    }
    		    //###########"Agenda
        
        }
  }
});

// Capteur de pression chaise salon_2 132/03
// Var04#0#Var08#42%
Subscriber<PALGATE_msgs.ZigbeeFrame> pression_chaise2 = connectedNode.newSubscriber("MADYNESGate/ZigbeeNode/cap132", "PALGATE_msgs/ZigbeeFrame");
pression_chaise2.addMessageListener(new MessageListener<PALGATE_msgs.ZigbeeFrame>() {
  @Override
  public void onNewMessage(PALGATE_msgs.ZigbeeFrame message) {
  //  System.out.println(message.getSensvals());
    String delims = "[#]";
    String[] data = message.getSensvals().split(delims);     
    if(data[1].equals("1")){
        Insertsql("Zigbee","Présence",PersonneName+"S ASSOIE sur le canapé 2 du salon");
        
        //###########"Insert in google Agenda
        creatURL();
        
    	    try {
    		      myService.setUserCredentials(userName, userPassword);
    		      // Demonstrate creating a single-occurrence event.
    		      CalendarEventEntry singleEvent = createSingleEvent(myService,
    		    		  PersonneName+"S ASSOIE sur le canapé 2 du salon", "Techno: Zigbee, Type: Action");
    		      System.out.println("Successfully created event "
    		          + singleEvent.getTitle().getPlainText());
    		    } catch (IOException e) {
    		      // Communications error
    		      System.err.println("There was a problem communicating with the service.");
    		      e.printStackTrace();
    		    } catch (ServiceException e) {
    		      // Server side error
    		      System.err.println("The server had a problem handling your request.");
    		      e.printStackTrace();
    		    }
    		    //###########"Agenda
        
        }
        else if(data[1].equals("0")){
        Insertsql("Zigbee","Présence",PersonneName+"SE LEVE du canapé 2 du salon");
        
        //###########"Insert in google Agenda
        creatURL();
        
    	    try {
    		      myService.setUserCredentials(userName, userPassword);
    		      // Demonstrate creating a single-occurrence event.
    		      CalendarEventEntry singleEvent = createSingleEvent(myService,
    		    		  PersonneName+"SE LEVE du canapé 2 du salon", "Techno: Zigbee, Type: Action");
    		      System.out.println("Successfully created event "
    		          + singleEvent.getTitle().getPlainText());
    		    } catch (IOException e) {
    		      // Communications error
    		      System.err.println("There was a problem communicating with the service.");
    		      e.printStackTrace();
    		    } catch (ServiceException e) {
    		      // Server side error
    		      System.err.println("The server had a problem handling your request.");
    		      e.printStackTrace();
    		    }
    		    //###########"Agenda
        
        }
  }
});

// Capteur de pression lit chambre 15/05
// Var04#0#Var08#43%
Subscriber<PALGATE_msgs.ZigbeeFrame> pression_lit = connectedNode.newSubscriber("MADYNESGate/ZigbeeNode/cap15", "PALGATE_msgs/ZigbeeFrame");
pression_lit.addMessageListener(new MessageListener<PALGATE_msgs.ZigbeeFrame>() {
  @Override
  public void onNewMessage(PALGATE_msgs.ZigbeeFrame message) {
  //  System.out.println(message.getSensvals());
    String delims = "[#]";
    String[] data = message.getSensvals().split(delims);     
    if(data[1].equals("1")){
        Insertsql("Zigbee","Présence",PersonneName+"S ALLONGE sur son lit de la chambre");
        
        //###########"Insert in google Agenda
        creatURL();
        
    	    try {
    		      myService.setUserCredentials(userName, userPassword);
    		      // Demonstrate creating a single-occurrence event.
    		      CalendarEventEntry singleEvent = createSingleEvent(myService,
    		    		  PersonneName+"S ALLONGE sur son lit de la chambre", "Techno: Zigbee, Type: Action");
    		      System.out.println("Successfully created event "
    		          + singleEvent.getTitle().getPlainText());
    		    } catch (IOException e) {
    		      // Communications error
    		      System.err.println("There was a problem communicating with the service.");
    		      e.printStackTrace();
    		    } catch (ServiceException e) {
    		      // Server side error
    		      System.err.println("The server had a problem handling your request.");
    		      e.printStackTrace();
    		    }
    		    //###########"Agenda
        
        }
        else if(data[1].equals("0")){
        Insertsql("Zigbee","Présence",PersonneName+"SE LEVE de son lit de la chambre");
        
        //###########"Insert in google Agenda
        creatURL();
        
    	    try {
    		      myService.setUserCredentials(userName, userPassword);
    		      // Demonstrate creating a single-occurrence event.
    		      CalendarEventEntry singleEvent = createSingleEvent(myService,
    		    		  PersonneName+"SE LEVE de son lit de la chambre", "Techno: Zigbee, Type: Action");
    		      System.out.println("Successfully created event "
    		          + singleEvent.getTitle().getPlainText());
    		    } catch (IOException e) {
    		      // Communications error
    		      System.err.println("There was a problem communicating with the service.");
    		      e.printStackTrace();
    		    } catch (ServiceException e) {
    		      // Server side error
    		      System.err.println("The server had a problem handling your request.");
    		      e.printStackTrace();
    		    }
    		    //###########"Agenda
        
        }
  }
});
    
  }
  

  
  public static void main(String[] argv) throws Exception {
	  	  
	  	java.net.URI masterUri = java.net.URI.create("http://127.0.0.1:11311");
	    NodeConfiguration nodeConfiguration = NodeConfiguration.newPublic("127.0.0.1", masterUri);

	    Listener sub = new Listener();
	    NodeMain nodeMain = sub;
	    

	    Preconditions.checkState(nodeMain != null);
	    NodeMainExecutor nodeMainExecutor = DefaultNodeMainExecutor.newDefault();
	    nodeMainExecutor.execute(nodeMain, nodeConfiguration);
	  }
  
  
}
