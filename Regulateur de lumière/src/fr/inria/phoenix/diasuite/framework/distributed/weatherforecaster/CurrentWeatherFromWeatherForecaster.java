package fr.inria.phoenix.diasuite.framework.distributed.weatherforecaster;

import java.io.Serializable;

import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;


public final class CurrentWeatherFromWeatherForecaster implements Serializable {
    private static final long serialVersionUID = 0;
  
  private fr.inria.phoenix.diasuite.framework.datatype.weather.Weather value;

  public fr.inria.phoenix.diasuite.framework.datatype.weather.Weather value(){
    return value;
  }

  public CurrentWeatherFromWeatherForecaster(Service service, RemoteServiceInfo remoteServiceInfo, fr.inria.phoenix.diasuite.framework.datatype.weather.Weather value, CurrentWeatherIndices indices) {
    this.sender = new WeatherForecasterProxy(service, remoteServiceInfo);
    this.value = value;
    this.indices = indices;
  }
  
  public CurrentWeatherFromWeatherForecaster(Service service, RemoteServiceInfo remoteServiceInfo, fr.inria.phoenix.diasuite.framework.datatype.weather.Weather value, java.lang.String region) {
    this.sender = new WeatherForecasterProxy(service, remoteServiceInfo);
    this.value = value;
    this.indices = new CurrentWeatherIndices(region);
  }
  
  private CurrentWeatherIndices indices;
  
  public CurrentWeatherIndices indices(){
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
      CurrentWeatherFromWeatherForecaster other = (CurrentWeatherFromWeatherForecaster) obj;
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

  private WeatherForecasterProxy sender;
  
  public WeatherForecasterProxy sender() {
    return sender;
  }

  public class WeatherForecasterProxy extends Proxy {
    private WeatherForecasterProxy(Service service, RemoteServiceInfo remoteServiceInfo) {
      super(service, remoteServiceInfo);
    }


    public java.lang.String id() {
      return (java.lang.String) getService().getProcessor().callGetValue(getService().getOutProperties(), getRemoteServiceInfo(), "id");
    }


    public void subscribeCurrentWeather() {
      getService().getProcessor().subscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "currentWeather");
    }

    public void unsubscribeCurrentWeather() {
      getService().getProcessor().unsubscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "currentWeather");
    }
  }

}