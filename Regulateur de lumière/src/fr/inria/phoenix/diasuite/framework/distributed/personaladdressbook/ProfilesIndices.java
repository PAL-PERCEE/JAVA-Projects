package fr.inria.phoenix.diasuite.framework.distributed.personaladdressbook;


import java.io.Serializable;

public final class ProfilesIndices implements Serializable {
    private static final long serialVersionUID = 0;
  
  private fr.inria.phoenix.diasuite.framework.datatype.personalprofile.PersonalProfile filter;
  
  public fr.inria.phoenix.diasuite.framework.datatype.personalprofile.PersonalProfile filter() {
  	return filter;
  }
  
  public void setFilter(fr.inria.phoenix.diasuite.framework.datatype.personalprofile.PersonalProfile filter) {
  	this.filter = filter;
  }


  public ProfilesIndices(fr.inria.phoenix.diasuite.framework.datatype.personalprofile.PersonalProfile filter) {
    this.filter = filter;

  }

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((filter == null) ? 0 : filter.hashCode());

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
      ProfilesIndices other = (ProfilesIndices) obj;
      if (filter == null) {
        if (other.filter != null)
          return false;
      } else if (!filter.equals(other.filter))
        return false; 

      return true;
    }

}