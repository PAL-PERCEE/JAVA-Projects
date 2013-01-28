package fr.inria.phoenix.diasuite.framework.distributed.texttospeech;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.core.exception.InvocationException;
import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;


/**
 * 
 *
 * @[717,0]
 * device TextToSpeech extends PhysicalDevice {
 *   source textToAudio as File indexed by text as String;
 * }
 */
public abstract class AbstractTextToSpeech extends Service {

    public AbstractTextToSpeech(ServiceConfiguration serviceConfiguration , java.lang.String id, java.lang.String location, java.lang.String user) {
      super("/Device/Device/PhysicalDevice/TextToSpeech/", serviceConfiguration);
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


        private java.util.HashMap<TextToAudioIndices,fr.inria.phoenix.diasuite.framework.datatype.file.File> _textToAudio = new java.util.HashMap<TextToAudioIndices,fr.inria.phoenix.diasuite.framework.datatype.file.File>();
        /**
         * @[718,1]
         * source textToAudio as File indexed by text as String;
         */  
        protected void publishTextToAudio(fr.inria.phoenix.diasuite.framework.datatype.file.File newTextToAudioValue , java.lang.String text) {
          TextToAudioIndices _indices_ = new TextToAudioIndices(text);
          _textToAudio.put(_indices_,newTextToAudioValue);
          getProcessor().publishValue(getOutProperties(), "textToAudio", newTextToAudioValue
    			, text ); 
        }

        /**
         * @[718,1]
         * source textToAudio as File indexed by text as String;
         */
        protected fr.inria.phoenix.diasuite.framework.datatype.file.File getTextToAudio(java.lang.String text) throws Exception{
          return _textToAudio.get(new TextToAudioIndices(text));    }
 

  public final Object orderCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
 
    throw new InvocationException("Undefined method name " + orderName);
  }
  
  public Object getValueCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
        if (orderName.equals("textToAudio")) {
          return getTextToAudio((java.lang.String)args[0]);
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