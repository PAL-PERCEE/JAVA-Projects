package fr.inria.phoenix.diasuite.framework.distributed.tv;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.core.exception.InvocationException;
import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;


/**
 * ------------------------------------
 *
 * @[632,0]
 * device Tv extends PhysicalDevice {
 *   source currentChannel as String;
 *   source currentVolume as Float;
 *   source mute as Boolean;
 *   action ChannelControl;
 *   action VolumeControl;
 * }
 */
public abstract class AbstractTv extends Service {

    public AbstractTv(ServiceConfiguration serviceConfiguration , java.lang.String id, java.lang.String location, java.lang.String user) {
      super("/Device/Device/PhysicalDevice/Tv/", serviceConfiguration);
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
        protected abstract void volumeUp() throws Exception;

        /**
         * 
         */
        protected abstract void setVolume(java.lang.Float level) throws Exception;

        /**
         * 
         */
        protected abstract void changeChannel(java.lang.String channel) throws Exception;

        /**
         * 
         */
        protected abstract void previousChannel() throws Exception;

        /**
         * 
         */
        protected abstract void nextChannel() throws Exception;

        /**
         * 
         */
        protected abstract void volumeDown() throws Exception;

        /**
         * 
         */
        protected abstract void mute(java.lang.Boolean mute) throws Exception;


        private java.lang.String _currentChannel;
        /**
         * @[635,1]
         * source currentChannel as String;
         */  
        protected void publishCurrentChannel(java.lang.String newCurrentChannelValue ) {
          _currentChannel = newCurrentChannelValue;
          getProcessor().publishValue(getOutProperties(), "currentChannel", newCurrentChannelValue); 
        }

        /**
         * @[635,1]
         * source currentChannel as String;
         */
        protected java.lang.String getCurrentChannel() throws Exception{
          return _currentChannel;    }
        private java.lang.Float _currentVolume;
        /**
         * @[636,1]
         * source currentVolume as Float;
         */  
        protected void publishCurrentVolume(java.lang.Float newCurrentVolumeValue ) {
          _currentVolume = newCurrentVolumeValue;
          getProcessor().publishValue(getOutProperties(), "currentVolume", newCurrentVolumeValue); 
        }

        /**
         * @[636,1]
         * source currentVolume as Float;
         */
        protected java.lang.Float getCurrentVolume() throws Exception{
          return _currentVolume;    }
        private java.lang.Boolean _mute;
        /**
         * @[637,1]
         * source mute as Boolean;
         */  
        protected void publishMute(java.lang.Boolean newMuteValue ) {
          _mute = newMuteValue;
          getProcessor().publishValue(getOutProperties(), "mute", newMuteValue); 
        }

        /**
         * @[637,1]
         * source mute as Boolean;
         */
        protected java.lang.Boolean getMute() throws Exception{
          return _mute;    }
 

  public final Object orderCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
        if (orderName.equals("volumeUp")) {
          volumeUp();
          return null;
        } else     if (orderName.equals("setVolume")) {
          setVolume((java.lang.Float)args[0]);
          return null;
        } else     if (orderName.equals("changeChannel")) {
          changeChannel((java.lang.String)args[0]);
          return null;
        } else     if (orderName.equals("previousChannel")) {
          previousChannel();
          return null;
        } else     if (orderName.equals("nextChannel")) {
          nextChannel();
          return null;
        } else     if (orderName.equals("volumeDown")) {
          volumeDown();
          return null;
        } else     if (orderName.equals("mute")) {
          mute((java.lang.Boolean)args[0]);
          return null;
        } 
    throw new InvocationException("Undefined method name " + orderName);
  }
  
  public Object getValueCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
        if (orderName.equals("currentChannel")) {
          return getCurrentChannel();
        } else     if (orderName.equals("currentVolume")) {
          return getCurrentVolume();
        } else     if (orderName.equals("mute")) {
          return getMute();
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