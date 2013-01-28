package fr.inria.phoenix.diasuite.framework.distributed.dimmablelight;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.core.exception.InvocationException;
import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;


/**
 * 
 *
 * @[554,0]
 * device DimmableLight extends Light {
 *   source level as Float;
 *   action VariationControl;
 * }
 */
public abstract class AbstractDimmableLight extends Service {

    public AbstractDimmableLight(ServiceConfiguration serviceConfiguration , java.lang.String id, java.lang.String location, java.lang.String user) {
      super("/Device/Device/PhysicalDevice/Appliance/Light/DimmableLight/", serviceConfiguration);
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

        /**
         * 
         */
        protected abstract void on() throws Exception;

        /**
         * 
         */
        protected abstract void off() throws Exception;

        /**
         * 
         */
        protected abstract void setValue(java.lang.Float value) throws Exception;

        /**
         * 
         */
        protected abstract void increase() throws Exception;

        /**
         * 
         */
        protected abstract void decrease() throws Exception;


        private fr.inria.phoenix.diasuite.framework.datatype.onoffstatus.OnOffStatus _status;
        /**
         * @[548,1]
         * source status as OnOffStatus;
         */  
        protected void publishStatus(fr.inria.phoenix.diasuite.framework.datatype.onoffstatus.OnOffStatus newStatusValue ) {
          _status = newStatusValue;
          getProcessor().publishValue(getOutProperties(), "status", newStatusValue); 
        }

        /**
         * @[548,1]
         * source status as OnOffStatus;
         */
        protected fr.inria.phoenix.diasuite.framework.datatype.onoffstatus.OnOffStatus getStatus() throws Exception{
          return _status;    }
        private java.lang.Float _level;
        /**
         * @[556,1]
         * source level as Float;
         */  
        protected void publishLevel(java.lang.Float newLevelValue ) {
          _level = newLevelValue;
          getProcessor().publishValue(getOutProperties(), "level", newLevelValue); 
        }

        /**
         * @[556,1]
         * source level as Float;
         */
        protected java.lang.Float getLevel() throws Exception{
          return _level;    }
 

  public final Object orderCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
        if (orderName.equals("on")) {
          on();
          return null;
        } else     if (orderName.equals("off")) {
          off();
          return null;
        } else     if (orderName.equals("setValue")) {
          setValue((java.lang.Float)args[0]);
          return null;
        } else     if (orderName.equals("increase")) {
          increase();
          return null;
        } else     if (orderName.equals("decrease")) {
          decrease();
          return null;
        } 
    throw new InvocationException("Undefined method name " + orderName);
  }
  
  public Object getValueCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
        if (orderName.equals("status")) {
          return getStatus();
        } else     if (orderName.equals("level")) {
          return getLevel();
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