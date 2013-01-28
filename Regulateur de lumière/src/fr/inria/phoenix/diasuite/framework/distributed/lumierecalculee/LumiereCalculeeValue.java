package fr.inria.phoenix.diasuite.framework.distributed.lumierecalculee;

import java.io.Serializable;

public final class LumiereCalculeeValue implements Serializable {
    private static final long serialVersionUID = 0;
  
  private java.lang.Integer value;

  public java.lang.Integer value(){
    return value;
  }

  public LumiereCalculeeValue(java.lang.Integer value) {
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
      LumiereCalculeeValue other = (LumiereCalculeeValue) obj;
      if (value == null) {
        if (other.value != null)
          return false;
      } else if (!value.equals(other.value))
        return false; 

      return true;
    }
}