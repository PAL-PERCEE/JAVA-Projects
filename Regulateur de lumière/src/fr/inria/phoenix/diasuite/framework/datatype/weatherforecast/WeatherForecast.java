package fr.inria.phoenix.diasuite.framework.datatype.weatherforecast;
import java.io.Serializable;


/**
 * 
 *
 * @[87,0]
 * structure WeatherForecast {
 * weather as Weather;
 * date as Date;
 * }
 */
public class WeatherForecast implements Serializable {

    private static final long serialVersionUID = 0;
    private fr.inria.phoenix.diasuite.framework.datatype.weather.Weather weather;
    
    public fr.inria.phoenix.diasuite.framework.datatype.weather.Weather getWeather() {
        return weather;
    }
    
    public void setWeather(fr.inria.phoenix.diasuite.framework.datatype.weather.Weather newWeatherValue) {
        this.weather = newWeatherValue;
    }
    private fr.inria.phoenix.diasuite.framework.datatype.date.Date date;
    
    public fr.inria.phoenix.diasuite.framework.datatype.date.Date getDate() {
        return date;
    }
    
    public void setDate(fr.inria.phoenix.diasuite.framework.datatype.date.Date newDateValue) {
        this.date = newDateValue;
    }

    public WeatherForecast() {
    }
  
    public WeatherForecast(fr.inria.phoenix.diasuite.framework.datatype.weather.Weather weather, fr.inria.phoenix.diasuite.framework.datatype.date.Date date) {
      this.weather = weather;      
      this.date = date;      

    }    
      @Override
      public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((weather == null) ? 0 : weather.hashCode());
        result = prime * result + ((date == null) ? 0 : date.hashCode());

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
        WeatherForecast other = (WeatherForecast) obj;
        if (weather == null) {
          if (other.weather != null)
            return false;
        } else if (!weather.equals(other.weather))
          return false; 
        if (date == null) {
          if (other.date != null)
            return false;
        } else if (!date.equals(other.date))
          return false; 

        return true;
      }


      @Override
      public String toString() {
        return "WeatherForecast [" + 
       "weather=" + weather +  ", " +    "date=" + date +  
          "]";
      }

}
