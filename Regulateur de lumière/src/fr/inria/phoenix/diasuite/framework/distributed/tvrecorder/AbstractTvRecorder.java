package fr.inria.phoenix.diasuite.framework.distributed.tvrecorder;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.core.exception.InvocationException;
import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;


/**
 * 
 *
 * @[644,0]
 * device TvRecorder extends PhysicalDevice {
 *   source recordedProgram as File indexed by name as String;
 *   action TvRecording;
 * }
 */
public abstract class AbstractTvRecorder extends Service {

    public AbstractTvRecorder(ServiceConfiguration serviceConfiguration , java.lang.String id, java.lang.String location, java.lang.String user) {
      super("/Device/Device/PhysicalDevice/TvRecorder/", serviceConfiguration);
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
        protected abstract void record(java.lang.String name, java.lang.String channel, fr.inria.phoenix.diasuite.framework.datatype.date.Date startDate, fr.inria.phoenix.diasuite.framework.datatype.date.Date endDate) throws Exception;


        private java.util.HashMap<RecordedProgramIndices,fr.inria.phoenix.diasuite.framework.datatype.file.File> _recordedProgram = new java.util.HashMap<RecordedProgramIndices,fr.inria.phoenix.diasuite.framework.datatype.file.File>();
        /**
         * @[646,1]
         * source recordedProgram as File indexed by name as String;
         */  
        protected void publishRecordedProgram(fr.inria.phoenix.diasuite.framework.datatype.file.File newRecordedProgramValue , java.lang.String name) {
          RecordedProgramIndices _indices_ = new RecordedProgramIndices(name);
          _recordedProgram.put(_indices_,newRecordedProgramValue);
          getProcessor().publishValue(getOutProperties(), "recordedProgram", newRecordedProgramValue
    			, name ); 
        }

        /**
         * @[646,1]
         * source recordedProgram as File indexed by name as String;
         */
        protected fr.inria.phoenix.diasuite.framework.datatype.file.File getRecordedProgram(java.lang.String name) throws Exception{
          return _recordedProgram.get(new RecordedProgramIndices(name));    }
 

  public final Object orderCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
        if (orderName.equals("record")) {
          record((java.lang.String)args[0], (java.lang.String)args[1], (fr.inria.phoenix.diasuite.framework.datatype.date.Date)args[2], (fr.inria.phoenix.diasuite.framework.datatype.date.Date)args[3]);
          return null;
        } 
    throw new InvocationException("Undefined method name " + orderName);
  }
  
  public Object getValueCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
        if (orderName.equals("recordedProgram")) {
          return getRecordedProgram((java.lang.String)args[0]);
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