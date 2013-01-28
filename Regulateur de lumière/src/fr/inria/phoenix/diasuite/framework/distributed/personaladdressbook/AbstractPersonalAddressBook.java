package fr.inria.phoenix.diasuite.framework.distributed.personaladdressbook;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.core.exception.InvocationException;
import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;


/**
 * 
 *
 * @[748,0]
 * device PersonalAddressBook extends UserService {
 *   source profiles as PersonalProfile[] indexed by filter as PersonalProfile;
 * }
 */
public abstract class AbstractPersonalAddressBook extends Service {

    public AbstractPersonalAddressBook(ServiceConfiguration serviceConfiguration , java.lang.String id, java.lang.String user) {
      super("/Device/Device/Service/UserService/PersonalAddressBook/", serviceConfiguration);
      updateId(id);
      updateUser(user);
    }

    @Override
    public final java.util.Map<String, Object> getAttributesCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source) {
        java.util.Map<String, Object> attributes = new java.util.HashMap<String, Object>();
        attributes.put("id",id);
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

        private java.lang.String user;

        /**
         * @[307,11]
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
         * @[307,11]
         * attribute user as String;
         * @return
         */  
        public java.lang.String getUser() {
          return user;
        }


  protected final void internalPostInitialize() {postInitialize();}


        private java.util.HashMap<ProfilesIndices,java.util.List<fr.inria.phoenix.diasuite.framework.datatype.personalprofile.PersonalProfile>> _profiles = new java.util.HashMap<ProfilesIndices,java.util.List<fr.inria.phoenix.diasuite.framework.datatype.personalprofile.PersonalProfile>>();
        /**
         * @[749,1]
         * source profiles as PersonalProfile[] indexed by filter as PersonalProfile;
         */  
        protected void publishProfiles(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.personalprofile.PersonalProfile> newProfilesValue , fr.inria.phoenix.diasuite.framework.datatype.personalprofile.PersonalProfile filter) {
          ProfilesIndices _indices_ = new ProfilesIndices(filter);
          _profiles.put(_indices_,newProfilesValue);
          getProcessor().publishValue(getOutProperties(), "profiles", newProfilesValue
    			, filter ); 
        }

        /**
         * @[749,1]
         * source profiles as PersonalProfile[] indexed by filter as PersonalProfile;
         */
        protected java.util.List<fr.inria.phoenix.diasuite.framework.datatype.personalprofile.PersonalProfile> getProfiles(fr.inria.phoenix.diasuite.framework.datatype.personalprofile.PersonalProfile filter) throws Exception{
          return _profiles.get(new ProfilesIndices(filter));    }
 

  public final Object orderCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
 
    throw new InvocationException("Undefined method name " + orderName);
  }
  
  public Object getValueCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
        if (orderName.equals("profiles")) {
          return getProfiles((fr.inria.phoenix.diasuite.framework.datatype.personalprofile.PersonalProfile)args[0]);
        }

       if (orderName.equals("id")) {
         return id;
       } else      if (orderName.equals("user")) {
         return user;
       }
    
    throw new InvocationException("Undefined method name " + orderName);
  }
    
}