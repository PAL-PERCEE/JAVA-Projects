package fr.inria.phoenix.diasuite.framework.distributed.telephonygateway;

import java.io.Serializable;

import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;


public final class RedirectionNumberInFromTelephonyGateway implements Serializable {
    private static final long serialVersionUID = 0;
  
  private java.lang.String value;

  public java.lang.String value(){
    return value;
  }

  public RedirectionNumberInFromTelephonyGateway(Service service, RemoteServiceInfo remoteServiceInfo, java.lang.String value) {
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
      RedirectionNumberInFromTelephonyGateway other = (RedirectionNumberInFromTelephonyGateway) obj;
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


    public void subscribeRedirectionNumberIn() {
      getService().getProcessor().subscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "redirectionNumberIn");
    }

    public void unsubscribeRedirectionNumberIn() {
      getService().getProcessor().unsubscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "redirectionNumberIn");
    }
  }

}