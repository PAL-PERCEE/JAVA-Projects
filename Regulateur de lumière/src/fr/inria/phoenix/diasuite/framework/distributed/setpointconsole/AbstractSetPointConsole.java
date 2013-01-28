package fr.inria.phoenix.diasuite.framework.distributed.setpointconsole;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.core.exception.InvocationException;
import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;


/**
 * Device
 *
 * @[14,0]
 * device SetPointConsole {
 *   source setPoint as Integer;
 * }
 */
public abstract class AbstractSetPointConsole extends Service {

    public AbstractSetPointConsole(ServiceConfiguration serviceConfiguration ) {
      super("/Device/SetPointConsole/", serviceConfiguration);
    }

    @Override
    public final java.util.Map<String, Object> getAttributesCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source) {
        java.util.Map<String, Object> attributes = new java.util.HashMap<String, Object>();
        return attributes;
    }
    
        

  protected final void internalPostInitialize() {postInitialize();}


        private java.lang.Integer _setPoint;
        /**
         * @[15,1]
         * source setPoint as Integer;
         */  
        protected void publishSetPoint(java.lang.Integer newSetPointValue ) {
          _setPoint = newSetPointValue;
          getProcessor().publishValue(getOutProperties(), "setPoint", newSetPointValue); 
        }

        /**
         * @[15,1]
         * source setPoint as Integer;
         */
        protected java.lang.Integer getSetPoint() throws Exception{
          return _setPoint;    }
 

  public final Object orderCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
 
    throw new InvocationException("Undefined method name " + orderName);
  }
  
  public Object getValueCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
        if (orderName.equals("setPoint")) {
          return getSetPoint();
        }

    
    throw new InvocationException("Undefined method name " + orderName);
  }
    
}