package fr.inria.phoenix.diasuite.framework.distributed.contactsensor;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.core.exception.InvocationException;
import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;


/**
 * 
 *
 * @[509,0]
 * device ContactSensor extends Sensor {
 *   source state as Boolean;
 * }
 */
public abstract class AbstractContactSensor extends Service {

    public AbstractContactSensor(ServiceConfiguration serviceConfiguration , java.lang.String id, java.lang.String location, java.lang.String user) {
      super("/Device/Device/PhysicalDevice/Sensor/ContactSensor/", serviceConfiguration);
      updateId(id);
      updateLocation(location);
      updateUser(user);
    }

    @Override
    public final java.util.Map<String, Object> getAttributesCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source) {
        java.util.Map<String, Object> attributes = new java.util.HashMap<String, Object>();
        attributes.put("id",id);
        attributes.put("location",location);
        attributes.put("user",user);

        return attributes;
    }
    
        
        private java.lang.String id;

        /**
         * @[293,11]
         * attribute id as String;
         * @param newIdValue
         */
        protected void updateId(java.lang.String newIdValue) {
          if (id != newIdValue) {
            id = newIdValue;
            updateAttribute("id", newIdValue);
          }
        }

        /**
         * @[293,11]
         * attribute id as String;
         * @return
         */  
        public java.lang.String getId() {
          return id;
        }

        private java.lang.String location;

        /**
         * @[440,11]
         * attribute location as String;
         * @param newLocationValue
         */
        protected void updateLocation(java.lang.String newLocationValue) {
          if (location != newLocationValue) {
            location = newLocationValue;
            updateAttribute("location", newLocationValue);
          }
        }

        /**
         * @[440,11]
         * attribute location as String;
         * @return
         */  
        public java.lang.String getLocation() {
          return location;
        }

        private java.lang.String user;

        /**
         * @[441,11]
         * attribute user as String;
         * @param newUserValue
         */
        protected void updateUser(java.lang.String newUserValue) {
          if (user != newUserValue) {
            user = newUserValue;
            updateAttribute("user", newUserValue);
          }
        }

        /**
         * @[441,11]
         * attribute user as String;
         * @return
         */  
        public java.lang.String getUser() {
          return user;
        }


  protected final void internalPostInitialize() {postInitialize();}


        private java.lang.Boolean _state;
        /**
         * @[510,1]
         * source state as Boolean;
         */  
        protected void publishState(java.lang.Boolean newStateValue ) {
          _state = newStateValue;
          getProcessor().publishValue(getOutProperties(), "state", newStateValue); 
        }

        /**
         * @[510,1]
         * source state as Boolean;
         */
        protected java.lang.Boolean getState() throws Exception{
          return _state;    }
 

  public final Object orderCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
 
    throw new InvocationException("Undefined method name " + orderName);
  }
  
  public Object getValueCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
        if (orderName.equals("state")) {
          return getState();
        }

       if (orderName.equals("id")) {
         return id;
       } else      if (orderName.equals("location")) {
         return location;
       } else      if (orderName.equals("user")) {
         return user;
       }
    
    throw new InvocationException("Undefined method name " + orderName);
  }
    
}