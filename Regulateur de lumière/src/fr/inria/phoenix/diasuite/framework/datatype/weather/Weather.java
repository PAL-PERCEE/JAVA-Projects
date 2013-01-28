package fr.inria.phoenix.diasuite.framework.datatype.weather;
import java.io.Serializable;


/**
 * 
 *
 * @[81,0]
 * structure Weather {
 * type as WeatherType;
 * temperature as Temperature;
 * wind as WindInfo;
 * }
 */
public class Weather implements Serializable {

    private static final long serialVersionUID = 0;
    private fr.inria.phoenix.diasuite.framework.datatype.weathertype.WeatherType type;
    
    public fr.inria.phoenix.diasuite.framework.datatype.weathertype.WeatherType getType() {
        return type;
    }
    
    public void setType(fr.inria.phoenix.diasuite.framework.datatype.weathertype.WeatherType newTypeValue) {
        this.type = newTypeValue;
    }
    private fr.inria.phoenix.diasuite.framework.datatype.temperature.Temperature temperature;
    
    public fr.inria.phoenix.diasuite.framework.datatype.temperature.Temperature getTemperature() {
        return temperature;
    }
    
    public void setTemperature(fr.inria.phoenix.diasuite.framework.datatype.temperature.Temperature newTemperatureValue) {
        this.temperature = newTemperatureValue;
    }
    private fr.inria.phoenix.diasuite.framework.datatype.windinfo.WindInfo wind;
    
    public fr.inria.phoenix.diasuite.framework.datatype.windinfo.WindInfo getWind() {
        return wind;
    }
    
    public void setWind(fr.inria.phoenix.diasuite.framework.datatype.windinfo.WindInfo newWindValue) {
        this.wind = newWindValue;
    }

    public Weather() {
    }
  
    public Weather(fr.inria.phoenix.diasuite.framework.datatype.weathertype.WeatherType type, fr.inria.phoenix.diasuite.framework.datatype.temperature.Temperature temperature, fr.inria.phoenix.diasuite.framework.datatype.windinfo.WindInfo wind) {
      this.type = type;      
      this.temperature = temperature;      
      this.wind = wind;      

    }    
      @Override
      public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        result = prime * result + ((temperature == null) ? 0 : temperature.hashCode());
        result = prime * result + ((wind == null) ? 0 : wind.hashCode());

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
        Weather other = (Weather) obj;
        if (type == null) {
          if (other.type != null)
            return false;
        } else if (!type.equals(other.type))
          return false; 
        if (temperature == null) {
          if (other.temperature != null)
            return false;
        } else if (!temperature.equals(other.temperature))
          return false; 
        if (wind == null) {
          if (other.wind != null)
            return false;
        } else if (!wind.equals(other.wind))
          return false; 

        return true;
      }


      @Override
      public String toString() {
        return "Weather [" + 
       "type=" + type +  ", " +    "temperature=" + temperature +  ", " +    "wind=" + wind +  
          "]";
      }

}
