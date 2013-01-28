package fr.inria.phoenix.diasuite.framework.distributed.temperaturesensor;

import java.io.Serializable;

import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;


public final class TemperatureFromTemperatureSensor implements Serializable {
    private static final long serialVersionUID = 0;
  
  private java.lang.Float value;

  public java.lang.Float value(){
    return value;
  }

  public TemperatureFromTemperatureSensor(Service service, RemoteServiceInfo remoteServiceInfo, java.lang.Float value, TemperatureIndices indices) {
    this.sender = new TemperatureSensorProxy(service, remoteServiceInfo);
    this.value = value;
    this.indices = indices;
  }
  
  public TemperatureFromTemperatureSensor(Service service, RemoteServiceInfo remoteServiceInfo, java.lang.Float value, fr.inria.phoenix.diasuite.framework.datatype.temperatureunit.TemperatureUnit unit) {
    this.sender = new TemperatureSensorProxy(service, remoteServiceInfo);
    this.value = value;
    this.indices = new TemperatureIndices(unit);
  }
  
  private TemperatureIndices indices;
  
  public TemperatureIndices indices(){
    return indices;
  }

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((value == null) ? 0 : value.hashCode());
      result = prime * result + ((indices == null) ? 0 : indices.hashCode());

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
      TemperatureFromTemperatureSensor other = (TemperatureFromTemperatureSensor) obj;
      if (value == null) {
        if (other.value != null)
          return false;
      } else if (!value.equals(other.value))
        return false; 
      if (indices == null) {
        if (other.indices != null)
          return false;
      } else if (!indices.equals(other.indices))
        return false; 

      return true;
    }

  private TemperatureSensorProxy sender;
  
  public TemperatureSensorProxy sender() {
    return sender;
  }

  public class TemperatureSensorProxy extends Proxy {
    private TemperatureSensorProxy(Service service, RemoteServiceInfo remoteServiceInfo) {
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


    public void subscribeTemperature() {
      getService().getProcessor().subscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "temperature");
    }

    public void unsubscribeTemperature() {
      getService().getProcessor().unsubscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "temperature");
    }
  }

}