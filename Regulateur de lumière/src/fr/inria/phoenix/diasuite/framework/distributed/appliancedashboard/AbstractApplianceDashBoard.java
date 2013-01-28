package fr.inria.phoenix.diasuite.framework.distributed.appliancedashboard;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.core.exception.InvocationException;
import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;


/**
 * 
 *
 * @[602,0]
 * device ApplianceDashBoard extends IHM {
 *   action ADBStatus;
 * }
 */
public abstract class AbstractApplianceDashBoard extends Service {

    public AbstractApplianceDashBoard(ServiceConfiguration serviceConfiguration , java.lang.String id) {
      super("/Device/Device/IHM/ApplianceDashBoard/", serviceConfiguration);
      updateId(id);
    }

    @Override
    public final java.util.Map<String, Object> getAttributesCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source) {
        java.util.Map<String, Object> attributes = new java.util.HashMap<String, Object>();
        attributes.put("id",id);

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


  protected final void internalPostInitialize() {postInitialize();}

        /**
         * 
         */
        protected abstract void changeStatus(fr.inria.phoenix.diasuite.framework.datatype.appliancetype.ApplianceType appliance, java.lang.Boolean status) throws Exception;


 

  public final Object orderCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
        if (orderName.equals("changeStatus")) {
          changeStatus((fr.inria.phoenix.diasuite.framework.datatype.appliancetype.ApplianceType)args[0], (java.lang.Boolean)args[1]);
          return null;
        } 
    throw new InvocationException("Undefined method name " + orderName);
  }
  
  public Object getValueCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {

       if (orderName.equals("id")) {
         return id;
       }
    
    throw new InvocationException("Undefined method name " + orderName);
  }
    
}