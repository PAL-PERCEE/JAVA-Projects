package fr.inria.phoenix.diasuite.framework.distributed.smssender;

import java.io.Serializable;

import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;


public final class LastTrustedMessageFromSMSSender implements Serializable {
    private static final long serialVersionUID = 0;
  
  private fr.inria.phoenix.diasuite.framework.datatype.message.Message value;

  public fr.inria.phoenix.diasuite.framework.datatype.message.Message value(){
    return value;
  }

  public LastTrustedMessageFromSMSSender(Service service, RemoteServiceInfo remoteServiceInfo, fr.inria.phoenix.diasuite.framework.datatype.message.Message value) {
    this.sender = new SMSSenderProxy(service, remoteServiceInfo);
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
      LastTrustedMessageFromSMSSender other = (LastTrustedMessageFromSMSSender) obj;
      if (value == null) {
        if (other.value != null)
          return false;
      } else if (!value.equals(other.value))
        return false; 

      return true;
    }

  private SMSSenderProxy sender;
  
  public SMSSenderProxy sender() {
    return sender;
  }

  public class SMSSenderProxy extends Proxy {
    private SMSSenderProxy(Service service, RemoteServiceInfo remoteServiceInfo) {
      super(service, remoteServiceInfo);
    }


    public java.lang.String id() {
      return (java.lang.String) getService().getProcessor().callGetValue(getService().getOutProperties(), getRemoteServiceInfo(), "id");
    }


    public void subscribeLastTrustedMessage() {
      getService().getProcessor().subscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "lastTrustedMessage");
    }

    public void unsubscribeLastTrustedMessage() {
      getService().getProcessor().unsubscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "lastTrustedMessage");
    }
  }

}