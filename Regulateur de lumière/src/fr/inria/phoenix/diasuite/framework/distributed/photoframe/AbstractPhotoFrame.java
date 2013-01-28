package fr.inria.phoenix.diasuite.framework.distributed.photoframe;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.core.exception.InvocationException;
import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;


/**
 * 
 *
 * @[590,0]
 * device PhotoFrame extends PhysicalDevice {
 *   source photos as File[];
 *   action PhotoFrameManagement;
 * }
 */
public abstract class AbstractPhotoFrame extends Service {

    public AbstractPhotoFrame(ServiceConfiguration serviceConfiguration , java.lang.String id, java.lang.String location, java.lang.String user) {
      super("/Device/Device/PhysicalDevice/PhotoFrame/", serviceConfiguration);
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
        protected abstract void removePhoto(fr.inria.phoenix.diasuite.framework.datatype.file.File photo) throws Exception;

        /**
         * 
         */
        protected abstract void addPhoto(fr.inria.phoenix.diasuite.framework.datatype.file.File photo) throws Exception;

        /**
         * 
         */
        protected abstract void removeAllPhoto() throws Exception;

        /**
         * 
         */
        protected abstract void setCurrentPhoto(fr.inria.phoenix.diasuite.framework.datatype.file.File photo) throws Exception;


        private java.util.List<fr.inria.phoenix.diasuite.framework.datatype.file.File> _photos;
        /**
         * @[591,1]
         * source photos as File[];
         */  
        protected void publishPhotos(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.file.File> newPhotosValue ) {
          _photos = newPhotosValue;
          getProcessor().publishValue(getOutProperties(), "photos", newPhotosValue); 
        }

        /**
         * @[591,1]
         * source photos as File[];
         */
        protected java.util.List<fr.inria.phoenix.diasuite.framework.datatype.file.File> getPhotos() throws Exception{
          return _photos;    }
 

  public final Object orderCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
        if (orderName.equals("removePhoto")) {
          removePhoto((fr.inria.phoenix.diasuite.framework.datatype.file.File)args[0]);
          return null;
        } else     if (orderName.equals("addPhoto")) {
          addPhoto((fr.inria.phoenix.diasuite.framework.datatype.file.File)args[0]);
          return null;
        } else     if (orderName.equals("removeAllPhoto")) {
          removeAllPhoto();
          return null;
        } else     if (orderName.equals("setCurrentPhoto")) {
          setCurrentPhoto((fr.inria.phoenix.diasuite.framework.datatype.file.File)args[0]);
          return null;
        } 
    throw new InvocationException("Undefined method name " + orderName);
  }
  
  public Object getValueCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
        if (orderName.equals("photos")) {
          return getPhotos();
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