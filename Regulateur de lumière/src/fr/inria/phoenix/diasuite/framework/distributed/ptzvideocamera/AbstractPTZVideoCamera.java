package fr.inria.phoenix.diasuite.framework.distributed.ptzvideocamera;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.core.exception.InvocationException;
import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;


/**
 * 
 *
 * @[458,0]
 * device PTZVideoCamera extends VideoCamera {
 *   source panAngle as Float;
 *   source tiltAngle as Float;
 *   source zoom as Float;
 *   action PTZ;
 * }
 */
public abstract class AbstractPTZVideoCamera extends Service {

    public AbstractPTZVideoCamera(ServiceConfiguration serviceConfiguration , java.lang.String id, java.lang.String location, java.lang.String user) {
      super("/Device/Device/PhysicalDevice/Camera/VideoCamera/PTZVideoCamera/", serviceConfiguration);
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
        protected abstract void panLeft() throws Exception;

        /**
         * 
         */
        protected abstract void tilt(java.lang.Float angle) throws Exception;

        /**
         * 
         */
        protected abstract void stopRecording() throws Exception;

        /**
         * 
         */
        protected abstract void panRight() throws Exception;

        /**
         * 
         */
        protected abstract void zoom(java.lang.Float factor) throws Exception;

        /**
         * 
         */
        protected abstract void zoomOut() throws Exception;

        /**
         * 
         */
        protected abstract void startRecording() throws Exception;

        /**
         * 
         */
        protected abstract void tiltDown() throws Exception;

        /**
         * 
         */
        protected abstract void zoomIn() throws Exception;

        /**
         * 
         */
        protected abstract void tiltUp() throws Exception;

        /**
         * 
         */
        protected abstract void pan(java.lang.Float angle) throws Exception;

        /**
         * 
         */
        protected abstract void goToPreset(java.lang.String presetName) throws Exception;


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
        private java.lang.Float _panAngle;
        /**
         * @[460,1]
         * source panAngle as Float;
         */  
        protected void publishPanAngle(java.lang.Float newPanAngleValue ) {
          _panAngle = newPanAngleValue;
          getProcessor().publishValue(getOutProperties(), "panAngle", newPanAngleValue); 
        }

        /**
         * @[460,1]
         * source panAngle as Float;
         */
        protected java.lang.Float getPanAngle() throws Exception{
          return _panAngle;    }
        private java.lang.Float _tiltAngle;
        /**
         * @[461,1]
         * source tiltAngle as Float;
         */  
        protected void publishTiltAngle(java.lang.Float newTiltAngleValue ) {
          _tiltAngle = newTiltAngleValue;
          getProcessor().publishValue(getOutProperties(), "tiltAngle", newTiltAngleValue); 
        }

        /**
         * @[461,1]
         * source tiltAngle as Float;
         */
        protected java.lang.Float getTiltAngle() throws Exception{
          return _tiltAngle;    }
        private java.lang.Float _zoom;
        /**
         * @[462,1]
         * source zoom as Float;
         */  
        protected void publishZoom(java.lang.Float newZoomValue ) {
          _zoom = newZoomValue;
          getProcessor().publishValue(getOutProperties(), "zoom", newZoomValue); 
        }

        /**
         * @[462,1]
         * source zoom as Float;
         */
        protected java.lang.Float getZoom() throws Exception{
          return _zoom;    }
 

  public final Object orderCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
        if (orderName.equals("panLeft")) {
          panLeft();
          return null;
        } else     if (orderName.equals("tilt")) {
          tilt((java.lang.Float)args[0]);
          return null;
        } else     if (orderName.equals("stopRecording")) {
          stopRecording();
          return null;
        } else     if (orderName.equals("panRight")) {
          panRight();
          return null;
        } else     if (orderName.equals("zoom")) {
          zoom((java.lang.Float)args[0]);
          return null;
        } else     if (orderName.equals("zoomOut")) {
          zoomOut();
          return null;
        } else     if (orderName.equals("startRecording")) {
          startRecording();
          return null;
        } else     if (orderName.equals("tiltDown")) {
          tiltDown();
          return null;
        } else     if (orderName.equals("zoomIn")) {
          zoomIn();
          return null;
        } else     if (orderName.equals("tiltUp")) {
          tiltUp();
          return null;
        } else     if (orderName.equals("pan")) {
          pan((java.lang.Float)args[0]);
          return null;
        } else     if (orderName.equals("goToPreset")) {
          goToPreset((java.lang.String)args[0]);
          return null;
        } 
    throw new InvocationException("Undefined method name " + orderName);
  }
  
  public Object getValueCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
        if (orderName.equals("image")) {
          return getImage();
        } else     if (orderName.equals("video")) {
          return getVideo();
        } else     if (orderName.equals("panAngle")) {
          return getPanAngle();
        } else     if (orderName.equals("tiltAngle")) {
          return getTiltAngle();
        } else     if (orderName.equals("zoom")) {
          return getZoom();
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