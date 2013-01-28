package fr.inria.phoenix.diasuite.framework.distributed.servicetablet;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.core.exception.InvocationException;
import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;


/**
 * 
 *
 * @[742,0]
 * device ServiceTablet extends PhysicalDevice {
 *   source tabletMode as ServiceTabletMode;
 *   source tabletAction as ServiceTabletMode indexed by profile as PersonalProfile;
 *   action PushContacts;
 * }
 */
public abstract class AbstractServiceTablet extends Service {

    public AbstractServiceTablet(ServiceConfiguration serviceConfiguration , java.lang.String id, java.lang.String location, java.lang.String user) {
      super("/Device/Device/PhysicalDevice/ServiceTablet/", serviceConfiguration);
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
        protected abstract void pushContacts(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.personalprofile.PersonalProfile> profiles) throws Exception;


        private fr.inria.phoenix.diasuite.framework.datatype.servicetabletmode.ServiceTabletMode _tabletMode;
        /**
         * @[744,1]
         * source tabletMode as ServiceTabletMode;
         */  
        protected void publishTabletMode(fr.inria.phoenix.diasuite.framework.datatype.servicetabletmode.ServiceTabletMode newTabletModeValue ) {
          _tabletMode = newTabletModeValue;
          getProcessor().publishValue(getOutProperties(), "tabletMode", newTabletModeValue); 
        }

        /**
         * @[744,1]
         * source tabletMode as ServiceTabletMode;
         */
        protected fr.inria.phoenix.diasuite.framework.datatype.servicetabletmode.ServiceTabletMode getTabletMode() throws Exception{
          return _tabletMode;    }
        private java.util.HashMap<TabletActionIndices,fr.inria.phoenix.diasuite.framework.datatype.servicetabletmode.ServiceTabletMode> _tabletAction = new java.util.HashMap<TabletActionIndices,fr.inria.phoenix.diasuite.framework.datatype.servicetabletmode.ServiceTabletMode>();
        /**
         * @[745,1]
         * source tabletAction as ServiceTabletMode indexed by profile as PersonalProfile;
         */  
        protected void publishTabletAction(fr.inria.phoenix.diasuite.framework.datatype.servicetabletmode.ServiceTabletMode newTabletActionValue , fr.inria.phoenix.diasuite.framework.datatype.personalprofile.PersonalProfile profile) {
          TabletActionIndices _indices_ = new TabletActionIndices(profile);
          _tabletAction.put(_indices_,newTabletActionValue);
          getProcessor().publishValue(getOutProperties(), "tabletAction", newTabletActionValue
    			, profile ); 
        }

        /**
         * @[745,1]
         * source tabletAction as ServiceTabletMode indexed by profile as PersonalProfile;
         */
        protected fr.inria.phoenix.diasuite.framework.datatype.servicetabletmode.ServiceTabletMode getTabletAction(fr.inria.phoenix.diasuite.framework.datatype.personalprofile.PersonalProfile profile) throws Exception{
          return _tabletAction.get(new TabletActionIndices(profile));    }
 

  public final Object orderCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
        if (orderName.equals("pushContacts")) {
          pushContacts((java.util.List<fr.inria.phoenix.diasuite.framework.datatype.personalprofile.PersonalProfile>)args[0]);
          return null;
        } 
    throw new InvocationException("Undefined method name " + orderName);
  }
  
  public Object getValueCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
        if (orderName.equals("tabletMode")) {
          return getTabletMode();
        } else     if (orderName.equals("tabletAction")) {
          return getTabletAction((fr.inria.phoenix.diasuite.framework.datatype.personalprofile.PersonalProfile)args[0]);
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