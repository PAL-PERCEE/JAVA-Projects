package fr.inria.phoenix.diasuite.framework.distributed.shutter;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.core.exception.InvocationException;
import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;


/**
 * MISC
 *
 * @[577,0]
 * device Shutter extends PhysicalDevice {
 *   source position as Float;
 *   action Open;
 *   action Close;
 *   action SetShutterPosition;
 * }
 */
public abstract class AbstractShutter extends Service {

    public AbstractShutter(ServiceConfiguration serviceConfiguration , java.lang.String id, java.lang.String location, java.lang.String user) {
      super("/Device/Device/PhysicalDevice/Shutter/", serviceConfiguration);
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
        protected abstract void open() throws Exception;

        /**
         * 
         */
        protected abstract void setPosition(java.lang.Float position) throws Exception;

        /**
         * 
         */
        protected abstract void close() throws Exception;


        private java.lang.Float _position;
        /**
         * @[581,1]
         * source position as Float;
         */  
        protected void publishPosition(java.lang.Float newPositionValue ) {
          _position = newPositionValue;
          getProcessor().publishValue(getOutProperties(), "position", newPositionValue); 
        }

        /**
         * @[581,1]
         * source position as Float;
         */
        protected java.lang.Float getPosition() throws Exception{
          return _position;    }
 

  public final Object orderCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
        if (orderName.equals("open")) {
          open();
          return null;
        } else     if (orderName.equals("setPosition")) {
          setPosition((java.lang.Float)args[0]);
          return null;
        } else     if (orderName.equals("close")) {
          close();
          return null;
        } 
    throw new InvocationException("Undefined method name " + orderName);
  }
  
  public Object getValueCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
        if (orderName.equals("position")) {
          return getPosition();
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