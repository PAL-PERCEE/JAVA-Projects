package fr.inria.phoenix.diasuite.framework.distributed.clock;

import java.io.Serializable;

import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;


public final class TickHourFromClock implements Serializable {
    private static final long serialVersionUID = 0;
  
  private java.lang.Integer value;

  public java.lang.Integer value(){
    return value;
  }

  public TickHourFromClock(Service service, RemoteServiceInfo remoteServiceInfo, java.lang.Integer value) {
    this.sender = new ClockProxy(service, remoteServiceInfo);
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
      TickHourFromClock other = (TickHourFromClock) obj;
      if (value == null) {
        if (other.value != null)
          return false;
      } else if (!value.equals(other.value))
        return false; 

      return true;
    }

  private ClockProxy sender;
  
  public ClockProxy sender() {
    return sender;
  }

  public class ClockProxy extends Proxy {
    private ClockProxy(Service service, RemoteServiceInfo remoteServiceInfo) {
      super(service, remoteServiceInfo);
    }


    public java.lang.String id() {
      return (java.lang.String) getService().getProcessor().callGetValue(getService().getOutProperties(), getRemoteServiceInfo(), "id");
    }


    public void subscribeTickHour() {
      getService().getProcessor().subscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "tickHour");
    }

    public void unsubscribeTickHour() {
      getService().getProcessor().unsubscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "tickHour");
    }
  }

}