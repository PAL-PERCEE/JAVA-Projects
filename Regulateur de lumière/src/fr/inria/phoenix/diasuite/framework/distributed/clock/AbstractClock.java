package fr.inria.phoenix.diasuite.framework.distributed.clock;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.core.exception.InvocationException;
import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;


/**
 * BUILTIN SERVICES
 *
 * @[314,0]
 * device Clock extends BuiltIn {
 *   source tickSecond as Integer;
 *   source tickMinute as Integer;
 *   source tickHour as Integer;
 * }
 */
public abstract class AbstractClock extends Service {

    public AbstractClock(ServiceConfiguration serviceConfiguration , java.lang.String id) {
      super("/Device/Device/Service/BuiltIn/Clock/", serviceConfiguration);
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


        private java.lang.Integer _tickSecond;
        /**
         * @[315,1]
         * source tickSecond as Integer;
         */  
        protected void publishTickSecond(java.lang.Integer newTickSecondValue ) {
          _tickSecond = newTickSecondValue;
          getProcessor().publishValue(getOutProperties(), "tickSecond", newTickSecondValue); 
        }

        /**
         * @[315,1]
         * source tickSecond as Integer;
         */
        protected java.lang.Integer getTickSecond() throws Exception{
          return _tickSecond;    }
        private java.lang.Integer _tickMinute;
        /**
         * @[316,1]
         * source tickMinute as Integer;
         */  
        protected void publishTickMinute(java.lang.Integer newTickMinuteValue ) {
          _tickMinute = newTickMinuteValue;
          getProcessor().publishValue(getOutProperties(), "tickMinute", newTickMinuteValue); 
        }

        /**
         * @[316,1]
         * source tickMinute as Integer;
         */
        protected java.lang.Integer getTickMinute() throws Exception{
          return _tickMinute;    }
        private java.lang.Integer _tickHour;
        /**
         * @[317,1]
         * source tickHour as Integer;
         */  
        protected void publishTickHour(java.lang.Integer newTickHourValue ) {
          _tickHour = newTickHourValue;
          getProcessor().publishValue(getOutProperties(), "tickHour", newTickHourValue); 
        }

        /**
         * @[317,1]
         * source tickHour as Integer;
         */
        protected java.lang.Integer getTickHour() throws Exception{
          return _tickHour;    }
 

  public final Object orderCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
 
    throw new InvocationException("Undefined method name " + orderName);
  }
  
  public Object getValueCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
        if (orderName.equals("tickSecond")) {
          return getTickSecond();
        } else     if (orderName.equals("tickMinute")) {
          return getTickMinute();
        } else     if (orderName.equals("tickHour")) {
          return getTickHour();
        }

       if (orderName.equals("id")) {
         return id;
       }
    
    throw new InvocationException("Undefined method name " + orderName);
  }
    
}