package fr.inria.phoenix.diasuite.framework.distributed.tvmessenger;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.core.exception.InvocationException;
import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;


/**
 * 
 *
 * @[663,0]
 * device TvMessenger extends Messenger {
 * }
 */
public abstract class AbstractTvMessenger extends Service {

    public AbstractTvMessenger(ServiceConfiguration serviceConfiguration , java.lang.String id, java.lang.String location, java.lang.String user) {
      super("/Device/Device/PhysicalDevice/Messenger/TvMessenger/", serviceConfiguration);
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
        protected abstract void sendMessageWithImage(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to, java.lang.String title, java.lang.String content, java.lang.String image) throws Exception;

        /**
         * 
         */
        protected abstract void sendMessage(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to, java.lang.String title, java.lang.String content, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.file.File> attachments) throws Exception;


 

  public final Object orderCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
        if (orderName.equals("sendMessageWithImage")) {
          sendMessageWithImage((fr.inria.phoenix.diasuite.framework.datatype.contact.Contact)args[0], (java.lang.String)args[1], (java.lang.String)args[2], (java.lang.String)args[3]);
          return null;
        } else     if (orderName.equals("sendMessage")) {
          sendMessage((fr.inria.phoenix.diasuite.framework.datatype.contact.Contact)args[0], (java.lang.String)args[1], (java.lang.String)args[2], (java.util.List<fr.inria.phoenix.diasuite.framework.datatype.file.File>)args[3]);
          return null;
        } 
    throw new InvocationException("Undefined method name " + orderName);
  }
  
  public Object getValueCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {

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