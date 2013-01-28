package fr.inria.phoenix.diasuite.framework.distributed.weatherforecaster;


import java.io.Serializable;

public final class CurrentWeatherIndices implements Serializable {
    private static final long serialVersionUID = 0;
  
  private java.lang.String region;
  
  public java.lang.String region() {
  	return region;
  }
  
  public void setRegion(java.lang.String region) {
  	this.region = region;
  }


  public CurrentWeatherIndices(java.lang.String region) {
    this.region = region;

  }

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((region == null) ? 0 : region.hashCode());

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
      CurrentWeatherIndices other = (CurrentWeatherIndices) obj;
      if (region == null) {
        if (other.region != null)
          return false;
      } else if (!region.equals(other.region))
        return false; 

      return true;
    }

}