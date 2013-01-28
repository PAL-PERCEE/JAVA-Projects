package fr.inria.phoenix.diasuite.framework.datatype.missedcall;
import java.io.Serializable;


/**
 * 
 *
 * @[127,0]
 * structure MissedCall {
 * caller as String;
 * date as String;
 * }
 */
public class MissedCall implements Serializable {

    private static final long serialVersionUID = 0;
    private java.lang.String caller;
    
    public java.lang.String getCaller() {
        return caller;
    }
    
    public void setCaller(java.lang.String newCallerValue) {
        this.caller = newCallerValue;
    }
    private java.lang.String date;
    
    public java.lang.String getDate() {
        return date;
    }
    
    public void setDate(java.lang.String newDateValue) {
        this.date = newDateValue;
    }

    public MissedCall() {
    }
  
    public MissedCall(java.lang.String caller, java.lang.String date) {
      this.caller = caller;      
      this.date = date;      

    }    
      @Override
      public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((caller == null) ? 0 : caller.hashCode());
        result = prime * result + ((date == null) ? 0 : date.hashCode());

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
        MissedCall other = (MissedCall) obj;
        if (caller == null) {
          if (other.caller != null)
            return false;
        } else if (!caller.equals(other.caller))
          return false; 
        if (date == null) {
          if (other.date != null)
            return false;
        } else if (!date.equals(other.date))
          return false; 

        return true;
      }


      @Override
      public String toString() {
        return "MissedCall [" + 
       "caller=" + caller +  ", " +    "date=" + date +  
          "]";
      }

}
