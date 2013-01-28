package fr.inria.phoenix.diasuite.framework.distributed.thermostat;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.core.exception.InvocationException;
import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;


/**
 * 
 *
 * @[568,0]
 * device Thermostat extends Appliance {
 *   source targetTemperature as Temperature;
 *   action SetTemperature;
 * }
 */
public abstract class AbstractThermostat extends Service {

    public AbstractThermostat(ServiceConfiguration serviceConfiguration , java.lang.String id, java.lang.String location, java.lang.String user) {
      super("/Device/Device/PhysicalDevice/Appliance/Thermostat/", serviceConfiguration);
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
        protected abstract void setTemperature(java.lang.Float value, fr.inria.phoenix.diasuite.framework.datatype.temperatureunit.TemperatureUnit unit) throws Exception;

        /**
         * 
         */
        protected abstract void off() throws Exception;

        /**
         * 
         */
        protected abstract void on() throws Exception;


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
        private fr.inria.phoenix.diasuite.framework.datatype.temperature.Temperature _targetTemperature;
        /**
         * @[570,1]
         * source targetTemperature as Temperature;
         */  
        protected void publishTargetTemperature(fr.inria.phoenix.diasuite.framework.datatype.temperature.Temperature newTargetTemperatureValue ) {
          _targetTemperature = newTargetTemperatureValue;
          getProcessor().publishValue(getOutProperties(), "targetTemperature", newTargetTemperatureValue); 
        }

        /**
         * @[570,1]
         * source targetTemperature as Temperature;
         */
        protected fr.inria.phoenix.diasuite.framework.datatype.temperature.Temperature getTargetTemperature() throws Exception{
          return _targetTemperature;    }
 

  public final Object orderCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
        if (orderName.equals("setTemperature")) {
          setTemperature((java.lang.Float)args[0], (fr.inria.phoenix.diasuite.framework.datatype.temperatureunit.TemperatureUnit)args[1]);
          return null;
        } else     if (orderName.equals("off")) {
          off();
          return null;
        } else     if (orderName.equals("on")) {
          on();
          return null;
        } 
    throw new InvocationException("Undefined method name " + orderName);
  }
  
  public Object getValueCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
        if (orderName.equals("status")) {
          return getStatus();
        } else     if (orderName.equals("targetTemperature")) {
          return getTargetTemperature();
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