package fr.inria.phoenix.diasuite.framework.datatype.temperature;
import java.io.Serializable;


/**
 * 
 *
 * @[72,0]
 * structure Temperature {
 * value as Float;
 * unit as TemperatureUnit;
 * }
 */
public class Temperature implements Serializable {

    private static final long serialVersionUID = 0;
    private java.lang.Float value;
    
    public java.lang.Float getValue() {
        return value;
    }
    
    public void setValue(java.lang.Float newValueValue) {
        this.value = newValueValue;
    }
    private fr.inria.phoenix.diasuite.framework.datatype.temperatureunit.TemperatureUnit unit;
    
    public fr.inria.phoenix.diasuite.framework.datatype.temperatureunit.TemperatureUnit getUnit() {
        return unit;
    }
    
    public void setUnit(fr.inria.phoenix.diasuite.framework.datatype.temperatureunit.TemperatureUnit newUnitValue) {
        this.unit = newUnitValue;
    }

    public Temperature() {
    }
  
    public Temperature(java.lang.Float value, fr.inria.phoenix.diasuite.framework.datatype.temperatureunit.TemperatureUnit unit) {
      this.value = value;      
      this.unit = unit;      

    }    
      @Override
      public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((value == null) ? 0 : value.hashCode());
        result = prime * result + ((unit == null) ? 0 : unit.hashCode());

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
        Temperature other = (Temperature) obj;
        if (value == null) {
          if (other.value != null)
            return false;
        } else if (!value.equals(other.value))
          return false; 
        if (unit == null) {
          if (other.unit != null)
            return false;
        } else if (!unit.equals(other.unit))
          return false; 

        return true;
      }


      @Override
      public String toString() {
        return "Temperature [" + 
       "value=" + value +  ", " +    "unit=" + unit +  
          "]";
      }

}
