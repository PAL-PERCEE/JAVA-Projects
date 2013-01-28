package fr.inria.phoenix.diasuite.framework.distributed.weatherforecaster;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.core.exception.InvocationException;
import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;


/**
 * 
 *
 * @[394,0]
 * device WeatherForecaster extends HomeService {
 *   source currentWeather as Weather indexed by region as String;
 *   source weatherForecasts as WeatherForecast[] indexed by region as String;
 * }
 */
public abstract class AbstractWeatherForecaster extends Service {

    public AbstractWeatherForecaster(ServiceConfiguration serviceConfiguration , java.lang.String id) {
      super("/Device/Device/Service/HomeService/WeatherForecaster/", serviceConfiguration);
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


        private java.util.HashMap<CurrentWeatherIndices,fr.inria.phoenix.diasuite.framework.datatype.weather.Weather> _currentWeather = new java.util.HashMap<CurrentWeatherIndices,fr.inria.phoenix.diasuite.framework.datatype.weather.Weather>();
        /**
         * @[395,1]
         * source currentWeather as Weather indexed by region as String;
         */  
        protected void publishCurrentWeather(fr.inria.phoenix.diasuite.framework.datatype.weather.Weather newCurrentWeatherValue , java.lang.String region) {
          CurrentWeatherIndices _indices_ = new CurrentWeatherIndices(region);
          _currentWeather.put(_indices_,newCurrentWeatherValue);
          getProcessor().publishValue(getOutProperties(), "currentWeather", newCurrentWeatherValue
    			, region ); 
        }

        /**
         * @[395,1]
         * source currentWeather as Weather indexed by region as String;
         */
        protected fr.inria.phoenix.diasuite.framework.datatype.weather.Weather getCurrentWeather(java.lang.String region) throws Exception{
          return _currentWeather.get(new CurrentWeatherIndices(region));    }
        private java.util.HashMap<WeatherForecastsIndices,java.util.List<fr.inria.phoenix.diasuite.framework.datatype.weatherforecast.WeatherForecast>> _weatherForecasts = new java.util.HashMap<WeatherForecastsIndices,java.util.List<fr.inria.phoenix.diasuite.framework.datatype.weatherforecast.WeatherForecast>>();
        /**
         * @[396,1]
         * source weatherForecasts as WeatherForecast[] indexed by region as String;
         */  
        protected void publishWeatherForecasts(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.weatherforecast.WeatherForecast> newWeatherForecastsValue , java.lang.String region) {
          WeatherForecastsIndices _indices_ = new WeatherForecastsIndices(region);
          _weatherForecasts.put(_indices_,newWeatherForecastsValue);
          getProcessor().publishValue(getOutProperties(), "weatherForecasts", newWeatherForecastsValue
    			, region ); 
        }

        /**
         * @[396,1]
         * source weatherForecasts as WeatherForecast[] indexed by region as String;
         */
        protected java.util.List<fr.inria.phoenix.diasuite.framework.datatype.weatherforecast.WeatherForecast> getWeatherForecasts(java.lang.String region) throws Exception{
          return _weatherForecasts.get(new WeatherForecastsIndices(region));    }
 

  public final Object orderCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
 
    throw new InvocationException("Undefined method name " + orderName);
  }
  
  public Object getValueCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
        if (orderName.equals("currentWeather")) {
          return getCurrentWeather((java.lang.String)args[0]);
        } else     if (orderName.equals("weatherForecasts")) {
          return getWeatherForecasts((java.lang.String)args[0]);
        }

       if (orderName.equals("id")) {
         return id;
       }
    
    throw new InvocationException("Undefined method name " + orderName);
  }
    
}