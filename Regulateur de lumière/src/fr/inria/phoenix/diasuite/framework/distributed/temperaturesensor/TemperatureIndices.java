package fr.inria.phoenix.diasuite.framework.distributed.temperaturesensor;


import java.io.Serializable;

public final class TemperatureIndices implements Serializable {
    private static final long serialVersionUID = 0;
  
  private fr.inria.phoenix.diasuite.framework.datatype.temperatureunit.TemperatureUnit unit;
  
  public fr.inria.phoenix.diasuite.framework.datatype.temperatureunit.TemperatureUnit unit() {
  	return unit;
  }
  
  public void setUnit(fr.inria.phoenix.diasuite.framework.datatype.temperatureunit.TemperatureUnit unit) {
  	this.unit = unit;
  }


  public TemperatureIndices(fr.inria.phoenix.diasuite.framework.datatype.temperatureunit.TemperatureUnit unit) {
    this.unit = unit;

  }

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
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
      TemperatureIndices other = (TemperatureIndices) obj;
      if (unit == null) {
        if (other.unit != null)
          return false;
      } else if (!unit.equals(other.unit))
        return false; 

      return true;
    }

}