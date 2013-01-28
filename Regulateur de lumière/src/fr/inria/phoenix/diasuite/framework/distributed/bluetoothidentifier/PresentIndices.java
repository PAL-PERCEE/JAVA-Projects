package fr.inria.phoenix.diasuite.framework.distributed.bluetoothidentifier;


import java.io.Serializable;

public final class PresentIndices implements Serializable {
    private static final long serialVersionUID = 0;
  
  private java.lang.String id;
  
  public java.lang.String id() {
  	return id;
  }
  
  public void setId(java.lang.String id) {
  	this.id = id;
  }


  public PresentIndices(java.lang.String id) {
    this.id = id;

  }

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((id == null) ? 0 : id.hashCode());

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
      PresentIndices other = (PresentIndices) obj;
      if (id == null) {
        if (other.id != null)
          return false;
      } else if (!id.equals(other.id))
        return false; 

      return true;
    }

}