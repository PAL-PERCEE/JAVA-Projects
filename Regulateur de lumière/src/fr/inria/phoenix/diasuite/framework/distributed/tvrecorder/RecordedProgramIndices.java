package fr.inria.phoenix.diasuite.framework.distributed.tvrecorder;


import java.io.Serializable;

public final class RecordedProgramIndices implements Serializable {
    private static final long serialVersionUID = 0;
  
  private java.lang.String name;
  
  public java.lang.String name() {
  	return name;
  }
  
  public void setName(java.lang.String name) {
  	this.name = name;
  }


  public RecordedProgramIndices(java.lang.String name) {
    this.name = name;

  }

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((name == null) ? 0 : name.hashCode());

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
      RecordedProgramIndices other = (RecordedProgramIndices) obj;
      if (name == null) {
        if (other.name != null)
          return false;
      } else if (!name.equals(other.name))
        return false; 

      return true;
    }

}