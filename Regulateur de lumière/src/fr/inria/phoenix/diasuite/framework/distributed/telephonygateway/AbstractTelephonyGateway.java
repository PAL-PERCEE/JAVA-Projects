package fr.inria.phoenix.diasuite.framework.distributed.telephonygateway;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.core.exception.InvocationException;
import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;


/**
 * Telephony
 *
 * @[407,0]
 * device TelephonyGateway extends HomeService {
 *   source redirectionNumberOut as String;
 *   source redirectionNumberIn as String;
 *   source currentCall as Call;
 *   source missedCalls as MissedCall[];
 *   source lastMissedCall as MissedCall;
 *   action TelephonyGatewayConfiguration;
 * }
 */
public abstract class AbstractTelephonyGateway extends Service {

    public AbstractTelephonyGateway(ServiceConfiguration serviceConfiguration , java.lang.String id) {
      super("/Device/Device/Service/HomeService/TelephonyGateway/", serviceConfiguration);
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
        protected abstract void setRedirectionNumberOut(java.lang.String number) throws Exception;

        /**
         * 
         */
        protected abstract void setRedirectionNumberIn(java.lang.String number) throws Exception;


        private java.lang.String _redirectionNumberOut;
        /**
         * @[409,1]
         * source redirectionNumberOut as String;
         */  
        protected void publishRedirectionNumberOut(java.lang.String newRedirectionNumberOutValue ) {
          _redirectionNumberOut = newRedirectionNumberOutValue;
          getProcessor().publishValue(getOutProperties(), "redirectionNumberOut", newRedirectionNumberOutValue); 
        }

        /**
         * @[409,1]
         * source redirectionNumberOut as String;
         */
        protected java.lang.String getRedirectionNumberOut() throws Exception{
          return _redirectionNumberOut;    }
        private java.lang.String _redirectionNumberIn;
        /**
         * @[410,1]
         * source redirectionNumberIn as String;
         */  
        protected void publishRedirectionNumberIn(java.lang.String newRedirectionNumberInValue ) {
          _redirectionNumberIn = newRedirectionNumberInValue;
          getProcessor().publishValue(getOutProperties(), "redirectionNumberIn", newRedirectionNumberInValue); 
        }

        /**
         * @[410,1]
         * source redirectionNumberIn as String;
         */
        protected java.lang.String getRedirectionNumberIn() throws Exception{
          return _redirectionNumberIn;    }
        private fr.inria.phoenix.diasuite.framework.datatype.call.Call _currentCall;
        /**
         * @[411,1]
         * source currentCall as Call;
         */  
        protected void publishCurrentCall(fr.inria.phoenix.diasuite.framework.datatype.call.Call newCurrentCallValue ) {
          _currentCall = newCurrentCallValue;
          getProcessor().publishValue(getOutProperties(), "currentCall", newCurrentCallValue); 
        }

        /**
         * @[411,1]
         * source currentCall as Call;
         */
        protected fr.inria.phoenix.diasuite.framework.datatype.call.Call getCurrentCall() throws Exception{
          return _currentCall;    }
        private java.util.List<fr.inria.phoenix.diasuite.framework.datatype.missedcall.MissedCall> _missedCalls;
        /**
         * @[412,1]
         * source missedCalls as MissedCall[];
         */  
        protected void publishMissedCalls(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.missedcall.MissedCall> newMissedCallsValue ) {
          _missedCalls = newMissedCallsValue;
          getProcessor().publishValue(getOutProperties(), "missedCalls", newMissedCallsValue); 
        }

        /**
         * @[412,1]
         * source missedCalls as MissedCall[];
         */
        protected java.util.List<fr.inria.phoenix.diasuite.framework.datatype.missedcall.MissedCall> getMissedCalls() throws Exception{
          return _missedCalls;    }
        private fr.inria.phoenix.diasuite.framework.datatype.missedcall.MissedCall _lastMissedCall;
        /**
         * @[413,1]
         * source lastMissedCall as MissedCall;
         */  
        protected void publishLastMissedCall(fr.inria.phoenix.diasuite.framework.datatype.missedcall.MissedCall newLastMissedCallValue ) {
          _lastMissedCall = newLastMissedCallValue;
          getProcessor().publishValue(getOutProperties(), "lastMissedCall", newLastMissedCallValue); 
        }

        /**
         * @[413,1]
         * source lastMissedCall as MissedCall;
         */
        protected fr.inria.phoenix.diasuite.framework.datatype.missedcall.MissedCall getLastMissedCall() throws Exception{
          return _lastMissedCall;    }
 

  public final Object orderCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
        if (orderName.equals("setRedirectionNumberOut")) {
          setRedirectionNumberOut((java.lang.String)args[0]);
          return null;
        } else     if (orderName.equals("setRedirectionNumberIn")) {
          setRedirectionNumberIn((java.lang.String)args[0]);
          return null;
        } 
    throw new InvocationException("Undefined method name " + orderName);
  }
  
  public Object getValueCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
        if (orderName.equals("redirectionNumberOut")) {
          return getRedirectionNumberOut();
        } else     if (orderName.equals("redirectionNumberIn")) {
          return getRedirectionNumberIn();
        } else     if (orderName.equals("currentCall")) {
          return getCurrentCall();
        } else     if (orderName.equals("missedCalls")) {
          return getMissedCalls();
        } else     if (orderName.equals("lastMissedCall")) {
          return getLastMissedCall();
        }

       if (orderName.equals("id")) {
         return id;
       }
    
    throw new InvocationException("Undefined method name " + orderName);
  }
    
}