package fr.inria.phoenix.diasuite.framework.distributed.watermeter;

import java.io.Serializable;

import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;


public final class CurrentWaterConsumptionFromWaterMeter implements Serializable {
    private static final long serialVersionUID = 0;
  
  private java.lang.Float value;

  public java.lang.Float value(){
    return value;
  }

  public CurrentWaterConsumptionFromWaterMeter(Service service, RemoteServiceInfo remoteServiceInfo, java.lang.Float value) {
    this.sender = new WaterMeterProxy(service, remoteServiceInfo);
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
      CurrentWaterConsumptionFromWaterMeter other = (CurrentWaterConsumptionFromWaterMeter) obj;
      if (value == null) {
        if (other.value != null)
          return false;
      } else if (!value.equals(other.value))
        return false; 

      return true;
    }

  private WaterMeterProxy sender;
  
  public WaterMeterProxy sender() {
    return sender;
  }

  public class WaterMeterProxy extends Proxy {
    private WaterMeterProxy(Service service, RemoteServiceInfo remoteServiceInfo) {
      super(service, remoteServiceInfo);
    }


    public java.lang.String id() {
      return (java.lang.String) getService().getProcessor().callGetValue(getService().getOutProperties(), getRemoteServiceInfo(), "id");
    }

    public java.lang.String location() {
      return (java.lang.String) getService().getProcessor().callGetValue(getService().getOutProperties(), getRemoteServiceInfo(), "location");
    }

    public java.lang.String user() {
      return (java.lang.String) getService().getProcessor().callGetValue(getService().getOutProperties(), getRemoteServiceInfo(), "user");
    }


    public void subscribeCurrentWaterConsumption() {
      getService().getProcessor().subscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "currentWaterConsumption");
    }

    public void unsubscribeCurrentWaterConsumption() {
      getService().getProcessor().unsubscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "currentWaterConsumption");
    }
  }

}