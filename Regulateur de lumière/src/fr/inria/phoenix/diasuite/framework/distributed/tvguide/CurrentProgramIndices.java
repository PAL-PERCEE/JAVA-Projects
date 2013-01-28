package fr.inria.phoenix.diasuite.framework.distributed.tvguide;


import java.io.Serializable;

public final class CurrentProgramIndices implements Serializable {
    private static final long serialVersionUID = 0;
  
  private java.lang.String channelId;
  
  public java.lang.String channelId() {
  	return channelId;
  }
  
  public void setChannelId(java.lang.String channelId) {
  	this.channelId = channelId;
  }


  public CurrentProgramIndices(java.lang.String channelId) {
    this.channelId = channelId;

  }

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((channelId == null) ? 0 : channelId.hashCode());

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
      CurrentProgramIndices other = (CurrentProgramIndices) obj;
      if (channelId == null) {
        if (other.channelId != null)
          return false;
      } else if (!channelId.equals(other.channelId))
        return false; 

      return true;
    }

}