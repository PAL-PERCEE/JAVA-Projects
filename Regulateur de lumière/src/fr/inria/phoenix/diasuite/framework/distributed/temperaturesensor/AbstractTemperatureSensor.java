package fr.inria.phoenix.diasuite.framework.distributed.temperaturesensor;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.core.exception.InvocationException;
import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;


/**
 * 
 *
 * @[505,0]
 * device TemperatureSensor extends Sensor {
 *   source temperature as Float indexed by unit as TemperatureUnit;
 * }
 */
public abstract class AbstractTemperatureSensor extends Service {

    public AbstractTemperatureSensor(ServiceConfiguration serviceConfiguration , java.lang.String id, java.lang.String location, java.lang.String user) {
      super("/Device/Device/PhysicalDevice/Sensor/TemperatureSensor/", serviceConfiguration);
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


        private java.util.HashMap<TemperatureIndices,java.lang.Float> _temperature = new java.util.HashMap<TemperatureIndices,java.lang.Float>();
        /**
         * @[506,1]
         * source temperature as Float indexed by unit as TemperatureUnit;
         */  
        protected void publishTemperature(java.lang.Float newTemperatureValue , fr.inria.phoenix.diasuite.framework.datatype.temperatureunit.TemperatureUnit unit) {
          TemperatureIndices _indices_ = new TemperatureIndices(unit);
          _temperature.put(_indices_,newTemperatureValue);
          getProcessor().publishValue(getOutProperties(), "temperature", newTemperatureValue
    			, unit ); 
        }

        /**
         * @[506,1]
         * source temperature as Float indexed by unit as TemperatureUnit;
         */
        protected java.lang.Float getTemperature(fr.inria.phoenix.diasuite.framework.datatype.temperatureunit.TemperatureUnit unit) throws Exception{
          return _temperature.get(new TemperatureIndices(unit));    }
 

  public final Object orderCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
 
    throw new InvocationException("Undefined method name " + orderName);
  }
  
  public Object getValueCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
        if (orderName.equals("temperature")) {
          return getTemperature((fr.inria.phoenix.diasuite.framework.datatype.temperatureunit.TemperatureUnit)args[0]);
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