package fr.inria.phoenix.diasuite.framework.distributed.servicetablet;


import java.io.Serializable;

public final class TabletActionIndices implements Serializable {
    private static final long serialVersionUID = 0;
  
  private fr.inria.phoenix.diasuite.framework.datatype.personalprofile.PersonalProfile profile;
  
  public fr.inria.phoenix.diasuite.framework.datatype.personalprofile.PersonalProfile profile() {
  	return profile;
  }
  
  public void setProfile(fr.inria.phoenix.diasuite.framework.datatype.personalprofile.PersonalProfile profile) {
  	this.profile = profile;
  }


  public TabletActionIndices(fr.inria.phoenix.diasuite.framework.datatype.personalprofile.PersonalProfile profile) {
    this.profile = profile;

  }

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((profile == null) ? 0 : profile.hashCode());

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
      TabletActionIndices other = (TabletActionIndices) obj;
      if (profile == null) {
        if (other.profile != null)
          return false;
      } else if (!profile.equals(other.profile))
        return false; 

      return true;
    }

}