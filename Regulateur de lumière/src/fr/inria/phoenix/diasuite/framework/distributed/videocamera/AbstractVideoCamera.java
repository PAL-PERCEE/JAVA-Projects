package fr.inria.phoenix.diasuite.framework.distributed.videocamera;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.core.exception.InvocationException;
import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;


/**
 * 
 *
 * @[453,0]
 * device VideoCamera extends Camera {
 *   source video as File;
 *   action StartStopRecording;
 * }
 */
public abstract class AbstractVideoCamera extends Service {

    public AbstractVideoCamera(ServiceConfiguration serviceConfiguration , java.lang.String id, java.lang.String location, java.lang.String user) {
      super("/Device/Device/PhysicalDevice/Camera/VideoCamera/", serviceConfiguration);
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
        protected abstract void stopRecording() throws Exception;

        /**
         * 
         */
        protected abstract void startRecording() throws Exception;


        private fr.inria.phoenix.diasuite.framework.datatype.file.File _image;
        /**
         * @[450,1]
         * source image as File;
         */  
        protected void publishImage(fr.inria.phoenix.diasuite.framework.datatype.file.File newImageValue ) {
          _image = newImageValue;
          getProcessor().publishValue(getOutProperties(), "image", newImageValue); 
        }

        /**
         * @[450,1]
         * source image as File;
         */
        protected fr.inria.phoenix.diasuite.framework.datatype.file.File getImage() throws Exception{
          return _image;    }
        private fr.inria.phoenix.diasuite.framework.datatype.file.File _video;
        /**
         * @[455,1]
         * source video as File;
         */  
        protected void publishVideo(fr.inria.phoenix.diasuite.framework.datatype.file.File newVideoValue ) {
          _video = newVideoValue;
          getProcessor().publishValue(getOutProperties(), "video", newVideoValue); 
        }

        /**
         * @[455,1]
         * source video as File;
         */
        protected fr.inria.phoenix.diasuite.framework.datatype.file.File getVideo() throws Exception{
          return _video;    }
 

  public final Object orderCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
        if (orderName.equals("stopRecording")) {
          stopRecording();
          return null;
        } else     if (orderName.equals("startRecording")) {
          startRecording();
          return null;
        } 
    throw new InvocationException("Undefined method name " + orderName);
  }
  
  public Object getValueCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
        if (orderName.equals("image")) {
          return getImage();
        } else     if (orderName.equals("video")) {
          return getVideo();
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