package fr.inria.phoenix.diasuite.framework.distributed.timer;


import java.io.Serializable;

public final class TimerTriggeredIndices implements Serializable {
    private static final long serialVersionUID = 0;
  
  private java.lang.String timerId;
  
  public java.lang.String timerId() {
  	return timerId;
  }
  
  public void setTimerId(java.lang.String timerId) {
  	this.timerId = timerId;
  }


  public TimerTriggeredIndices(java.lang.String timerId) {
    this.timerId = timerId;

  }

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((timerId == null) ? 0 : timerId.hashCode());

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
      TimerTriggeredIndices other = (TimerTriggeredIndices) obj;
      if (timerId == null) {
        if (other.timerId != null)
          return false;
      } else if (!timerId.equals(other.timerId))
        return false; 

      return true;
    }

}