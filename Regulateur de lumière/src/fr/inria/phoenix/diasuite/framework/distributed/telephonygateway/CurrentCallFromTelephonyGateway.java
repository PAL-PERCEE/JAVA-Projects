package fr.inria.phoenix.diasuite.framework.distributed.telephonygateway;

import java.io.Serializable;

import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;


public final class CurrentCallFromTelephonyGateway implements Serializable {
    private static final long serialVersionUID = 0;
  
  private fr.inria.phoenix.diasuite.framework.datatype.call.Call value;

  public fr.inria.phoenix.diasuite.framework.datatype.call.Call value(){
    return value;
  }

  public CurrentCallFromTelephonyGateway(Service service, RemoteServiceInfo remoteServiceInfo, fr.inria.phoenix.diasuite.framework.datatype.call.Call value) {
    this.sender = new TelephonyGatewayProxy(service, remoteServiceInfo);
    this.value = value;
  }

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((value == null) ? 0 : value.hashCode());

      return result;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      CurrentCallFromTelephonyGateway other = (CurrentCallFromTelephonyGateway) obj;
      if (value == null) {
        if (other.value != null)
          return false;
      } else if (!value.equals(other.value))
        return false; 

      return true;
    }

  private TelephonyGatewayProxy sender;
  
  public TelephonyGatewayProxy sender() {
    return sender;
  }

  public class TelephonyGatewayProxy extends Proxy {
    private TelephonyGatewayProxy(Service service, RemoteServiceInfo remoteServiceInfo) {
      super(service, remoteServiceInfo);
    }


    public java.lang.String id() {
      return (java.lang.String) getService().getProcessor().callGetValue(getService().getOutProperties(), getRemoteServiceInfo(), "id");
    }


    public void subscribeCurrentCall() {
      getService().getProcessor().subscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "currentCall");
    }

    public void unsubscribeCurrentCall() {
      getService().getProcessor().unsubscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "currentCall");
    }
  }

}